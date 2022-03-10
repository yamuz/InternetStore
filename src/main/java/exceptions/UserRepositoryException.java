package exceptions;

public class UserRepositoryException extends Exception{
    private String description ="";

    public UserRepositoryException(String description) {
        this.description = description;
    }
}
