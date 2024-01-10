package petclinic.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import petclinic.scheduling.AbstractJob;

@Slf4j
public class MyJob extends AbstractJob {

    @Override
    public void run(JobExecutionContext cxt) {
        log.info("MyJob execute: " + cxt.getJobDetail().getJobClass().getName());
    }
}
