package lamph11.api.exception;

import lombok.Data;

@Data
public class BaseException extends Throwable {

    private String errorMessage;
    private Object errorList;

    public BaseException(String message){
        super(message);
    }

}
