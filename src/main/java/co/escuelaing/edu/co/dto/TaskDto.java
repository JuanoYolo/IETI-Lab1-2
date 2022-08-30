package co.escuelaing.edu.co.dto;

public class TaskDto {

    private final String name;

    private final String description;

    private final String status;

    private final String assignedTo;

    private final String dueDate;

    private final String createdAt;

    public TaskDto(String name, String description, String status, String assignedTo, String dueDate, String createdAt) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.createdAt = createdAt;
    }
}
