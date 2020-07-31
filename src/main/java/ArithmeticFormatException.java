public class ArithmeticFormatException extends IllegalArgumentException {

    public ArithmeticFormatException(IllegalArgumentException exception) {
        super();
    }

    @Override
    public String getMessage() {
        return "잘못된 수식을 입력하셨습니다.";
    }
}
