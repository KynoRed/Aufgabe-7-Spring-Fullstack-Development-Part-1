package at.itkollegimst.studentenverwaltung.exceptions;

public class StudentValidierungFehlgeschlagen extends ExceptionDTO {

    public StudentValidierungFehlgeschlagen(String message){
        super(message);
    }

    public String getMessage() {
        return "";
    }
}
