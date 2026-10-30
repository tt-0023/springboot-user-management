package com.luna.myfirstcrud;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import  org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHander {
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<Result<Object>> handleBusinessException(BusinessException e) {
        Result<Object> result = Result.error(e.getCode(), e.getMessage());
        return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Result<String>> handleValidationException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .findFirst()
                .orElse("参数校验失败");
        return new ResponseEntity<>(Result.error(400, message), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Result> handleException(Exception e) {
        e.printStackTrace();
        Result result = Result.error(500, "服务器内部错误，请稍后重试");
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
