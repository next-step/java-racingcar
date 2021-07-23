package study.racing.exception;

import java.util.InputMismatchException;

public class Exception {
    public static void InputMismatchException(String message){
        throw new InputMismatchException(message);
    };

    public static void IllegalArgumentException(String message){
        throw new IllegalArgumentException(message);
    };

}
