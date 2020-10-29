package calculator;

public class Validator {
    private static Validator singleton = null;

    private Validator() {
        super();
    };

    public static synchronized Validator getInstance() {
        if (singleton == null) {
            singleton = new Validator();
        }
        return singleton;
    }

    public void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException(Const.NULL_ERROR_MSG);
        }
        if (input.length() < 1) {
            throw new IllegalArgumentException(Const.EMPTY_ERROR_MSG);
        }
    }

    public void validateArray(String[] array) {
        // 연산 가능한 최소한의 length 는 3이다. (e.g: 1 + 2)
        if (array.length < 3) {
            throw new IllegalArgumentException(Const.LESS_THAN_3_ERROR_MSG);
        }

        // 마지막이 숫자로 끝나려면, array 의 length 가 홀수여야 한다.
        if (array.length % 2 == 0) {
            throw new IllegalArgumentException(Const.ODD_ERROR_MSG);
        }
    }

}
