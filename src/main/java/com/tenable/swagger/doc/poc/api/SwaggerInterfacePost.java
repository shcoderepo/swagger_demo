package com.tenable.swagger.doc.poc.api;

import com.tenable.swagger.doc.poc.api.model.User;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.*;

@Documented
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returned if Tenable.io successfully creates the user.",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = User.class),
                        examples = @ExampleObject(name = "userExample", ref = "#/components/examples/userExample"))}),
        @ApiResponse(responseCode = "400", description = "Returned if a request parameter is invalid.",
                content = @Content),
        @ApiResponse(responseCode = "403", description = "Returned if you do not have permission to create a user.",
                content = @Content),
        @ApiResponse(responseCode = "409", description = "Returned if you attempt to create a duplicate user.",
                content = @Content),
        @ApiResponse(responseCode = "429", description = "Returned if you attempt to send too many requests in a" +
                " specific period of time. For more information, see [Rate Limiting](doc:rate-limiting).",
                content = {@Content(mediaType = "text/html", examples = @ExampleObject(name = "user429Example", ref = "#/components/examples/user429Example"))})
})
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@interface SwaggerInterfacePost {
    public String key() default "";
}

