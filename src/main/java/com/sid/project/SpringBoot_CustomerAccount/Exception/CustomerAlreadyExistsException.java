package com.sid.project.SpringBoot_CustomerAccount.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistsException extends RuntimeException
{
    public CustomerAlreadyExistsException(String message)
    {
        super(message);
    }
}
