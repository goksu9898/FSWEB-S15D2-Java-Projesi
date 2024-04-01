package models;

public class Task {
    private String project;
    private String description;
    private String assignee;
    private Priority priority;
    private Status status;

    public String getProject() {
        return project;
    }

    public String getDescription() {
        return description;
    }

    public String getAssignee() {
        return assignee;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public Task(String project, String description, String assignee, Priority priority, Status status) {
        this.project = project;
        this.description = description;
        this.assignee = assignee;
        this.priority = priority;
        this.status = status;
    }

    @Override
    public String toString() {
        return "models.Task{" +
                "description='" + description + '\'' +
                ", assignee='" + assignee + '\'' +
                ", priority=" + priority + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!project.equals(task.project)) return false;
        return description.equals(task.description);
    }

    @Override
    public int hashCode() {
        int result = project.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
