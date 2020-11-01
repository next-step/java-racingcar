package stringCalculator.exception;

public class TypeException extends IllegalArgumentException {

    public TypeException() {
        super("타입이 존재하지 않습니다.");
    }
}
