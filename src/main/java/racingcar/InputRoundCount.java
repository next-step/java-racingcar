package racingcar;

public class InputRoundCount {

    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "숫자만 입력이 가능합니다.";
    private static final String ONLY_POSITIVE_MESSAGE = "1 이상의 값만 가능합니다.";
    private int roundCount;

    public InputRoundCount(String value) {
        int roundCount = 0;
        try {
            roundCount = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }

        if (roundCount < 1) {
            throw new IllegalArgumentException(ONLY_POSITIVE_MESSAGE);
        }

        this.roundCount = roundCount;
    }

}
