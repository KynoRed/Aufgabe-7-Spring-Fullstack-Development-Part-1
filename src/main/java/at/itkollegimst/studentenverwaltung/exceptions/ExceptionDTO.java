package at.itkollegimst.studentenverwaltung.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionDTO {

    private String code;
    private String message;

    public ExceptionDTO(String message) {

    }

    public ExceptionDTO(String number, String message) {

    }
}
