package petclinic.quartz;

/**
 * @author 两个蝴蝶飞
 * <p>
 * 用于接收 配置任务和触发器的信息
 */
public class JobAndTrigger {
    private static final long serialVersionUID = 1L;
    /**
     * @param jobName 任务名称
     * @param jobGroupName 任务组的名称
     * @param jobClassName 任务的名称
     * @param triggerName 触发器名称
     * @param triggerGroupName 触发器组名称
     * @param cronExpression cron表达式
     * @param repeatInterval 间隔
     * @param repeatCount 次数
     * @param startDelay 延迟开始时间
     */
    private String jobName;
    private String jobGroupName;
    private String jobClassName;
    private String triggerName;
    private String triggerGroupName;
    private String cronExpression;
    private Long repeatInterval;
    private Integer repeatCount;
    private Long startDelay;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroupName() {
        return jobGroupName;
    }

    public void setJobGroupName(String jobGroupName) {
        this.jobGroupName = jobGroupName;
    }

    public String getJobClassName() {
        return jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroupName() {
        return triggerGroupName;
    }

    public void setTriggerGroupName(String triggerGroupName) {
        this.triggerGroupName = triggerGroupName;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public Long getRepeatInterval() {
        return repeatInterval;
    }

    public void setRepeatInterval(Long repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    public Integer getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(Integer repeatCount) {
        this.repeatCount = repeatCount;
    }

    public Long getStartDelay() {
        return startDelay;
    }

    public void setStartDelay(Long startDelay) {
        this.startDelay = startDelay;
    }

    @Override
    public String toString() {
        return "JobAndTrigger [jobName=" + jobName + ", jobGroupName=" + jobGroupName + ", jobClassName=" + jobClassName + ", triggerName=" + triggerName + ", triggerGroupName=" + triggerGroupName + ", cronExpression=" + cronExpression + ", repeatInterval=" + repeatInterval + ", repeatCount=" + repeatCount + ", startDelay=" + startDelay + "]";
    }
}
