package step1;

/**
 * 비어 있는 문자일 경우
 */
public class InputEmptyDataException extends Exception{
    InputEmptyDataException(String msg){
        super(msg);
    }
}
