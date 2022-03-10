package exceptions;

public class DBConnectionException extends Exception{
    private String description ="";

    public DBConnectionException(String description) {
        this.description = description;
    }
    //save log
}
