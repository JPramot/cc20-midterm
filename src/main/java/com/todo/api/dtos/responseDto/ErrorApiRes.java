package com.todo.api.dtos.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Schema(
        name = "Error API Response",
        description = "Schema that holds error information"
)
@Getter@Setter
@NoArgsConstructor
public class ErrorApiRes {

    private boolean isSuccess = false;

    @Schema(
            name = "Details",
            description = "key value pair of error details"
    )
    private Map<String ,String > details;

    private String error;

    private String message;

    private String timestamp = LocalDateTime.now().toString();

    public ErrorApiRes(String message, String error) {
        this.message = message;
        this.error = error;
    }

    public ErrorApiRes(String message, String error, Map<String ,String > details) {
        this.message = message;
        this.error = error;
        this.details = details;
    }
}
