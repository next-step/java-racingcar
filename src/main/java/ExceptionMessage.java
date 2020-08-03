public final class ExceptionMessage {
    // private 생성자를 만들면 객체 생성을 막을 수 있다.
    private ExceptionMessage() { }

    public static final String DIVIDE_BY_ZERO = "0으로 나눌 수 없습니다.";
    public static final String NOT_ARITHMETIC_SIMBOLS = "사칙 연산 기호가 아닙니다.";
    public static final String INPUT_VALUE_EMPTY = "입력 값이 비어 있습니다.";
}
