package exception;

import com.example.usermanagementsystem.model.CustomError;
import com.example.usermanagementsystem.model.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public CustomError notFoundException(NotFoundException exception){
        return exception.getCustomError();
    }

    @ExceptionHandler(Exception.class)
    public CustomError internalException(Exception exception){
        return CustomError.builder()
                .code("500")
                .message("Internal Server")
                .build();
    }
}
