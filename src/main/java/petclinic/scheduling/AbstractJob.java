package petclinic.scheduling;

import jakarta.annotation.Resource;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractJob implements Job {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        jdbcTemplate.execute("insert into jobs(name) values(\'before " + context.getJobDetail().getJobClass().getName() + "\')");
        run(context);
        jdbcTemplate.execute("insert into jobs(name) values(\'after " + context.getJobDetail().getJobClass().getName() + "\')");
    }

    public abstract void run(JobExecutionContext context) throws JobExecutionException;
}
