package co.escuelaing.edu.co.dto;

public class UserDto {

    private final String id;

    private final String name;

    private final String email;

    private final String lastName;

    private final String createDate;

    public UserDto(String id, String name, String email, String lastName, String createDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.createDate = createDate;
    }
}
