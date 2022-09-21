package string;

public class IncludeNotNumberException extends RuntimeException{
    private static final String MESSAGE = "문자를 숫자로 변환중 숫자가 아닌 문자가 포함되어 있습니다. 문제발생문자 : ";

    public IncludeNotNumberException(String data) {
        super(MESSAGE + data);
    }
}
