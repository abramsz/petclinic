package petclinic.job;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petclinic.rest.api.JobsApi;
import petclinic.rest.dto.JobDto;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("api/sched")
public class JobController implements JobsApi {

    @Resource
    private TaskScheduler taskScheduler;

    @Override
    public ResponseEntity<JobDto> getJob(Integer jobId) {
        var jobDto = new JobDto();
        jobDto.setId(jobId);
        jobDto.setName("hello " + jobId);

        log.info("before submit");
        taskScheduler.schedule(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("performImmediateTask");
        }, Instant.now());
        log.info("after submit");

        return new ResponseEntity<>(jobDto, HttpStatus.OK);
    }

}
