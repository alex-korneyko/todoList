package ua.in.dris4ecoder.businessObjects;

/**
 * Created by Alex Korneyko on 18.09.2016 16:38.
 */
public class Task {

    private String taskName;
    private String description;
    private Boolean complete;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    public Task(String taskName, String description) {
        this(taskName);
        this.description = description;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", complete=" + complete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        return taskName != null ? taskName.equals(task.taskName) : task.taskName == null;

    }

    @Override
    public int hashCode() {
        return taskName != null ? taskName.hashCode() : 0;
    }
}
