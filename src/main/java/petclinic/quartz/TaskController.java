package petclinic.quartz;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petclinic.rest.api.TasksApi;
import petclinic.rest.dto.TaskDto;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("api")
public class TaskController implements TasksApi {

    @Resource
    private Scheduler scheduler;

    @Override
    public ResponseEntity<TaskDto> getTask(Integer id) {
        var task = new TaskDto();
        task.setId(id);
        task.setName("hello " + id);

        var job = JobBuilder.newJob(MyJob.class)
            .withIdentity(MyJob.class.getName(), "default")
            .build();

        var trigger = TriggerBuilder.newTrigger()
            .forJob(job)
            .withIdentity("myTrigger", "myTriggerGroup")
            .startAt(new Date())
            .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(1)
                .withRepeatCount(0))
            .startNow()
            .build();

        try {
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(task);
    }
}
