package com.slot.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code=HttpStatus.CONFLICT,reason="slot Already Exists Exception...")
public class slotAlreadyExistsException extends Exception {

}
