package com.phdljr.anonymousboard.exception;

public class WrongPasswordException extends RuntimeException{

    public WrongPasswordException() {
        super("비밀번호가 일치하지 않습니다.");
    }
}
