package racingcar.domain;

public class InputData {
    private final Integer number;
    private final Integer count;

    public InputData(Integer number, Integer count) {
        validateNegativeNumber(number, count);
        this.number = number;
        this.count = count;
    }

    private static void validateNegativeNumber(Integer number, Integer count) {
        if (number <= 0) throw new IllegalArgumentException("자동차 대수는 양수만 입력가능합니다");
        if (count <= 0) throw new IllegalArgumentException("자동차 시도 횟수는 양수만 입력 가능합니다");
    }


}
