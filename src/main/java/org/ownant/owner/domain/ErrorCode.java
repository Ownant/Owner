package org.ownant.owner.domain;

public enum ErrorCode {
    OWNER_EMAIL_ALREADY_PRESENT("Owner with given email address already registered", 40901),
    OWNER_USERNAME_ALREADY_PRESENT("Owner with given username address already registered", 40902),
    INVALID_REQUEST("Request does not contain required information", 40001),

    OWNER_NOT_PRESENT("Owner with given id is not present", 40001);

    String message;
    int code;

    ErrorCode(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
