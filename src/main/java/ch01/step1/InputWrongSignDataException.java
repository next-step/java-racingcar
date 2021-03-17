package ch01.step1;

/**
 * 잘못된 기호가 들어있을 경우
 */
public class InputWrongSignDataException extends Exception{
    InputWrongSignDataException(String msg){
        super(msg);
    }
}
