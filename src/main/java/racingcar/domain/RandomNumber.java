package racingcar.domain;

public class RandomNumber {

    private final static int ADVANCED_CONDITION_NUMBER = 4;     // 전진 조건 숫자
    private final int number;

    public RandomNumber(int randomNumber) {
        if (randomNumber < 0 || randomNumber > 9) {
            throw new IllegalArgumentException("램덤 숫자는 0부터 9사이의 값이여야 합니다.");
        }
        this.number = randomNumber;
    }

    public boolean isAdvancedCondition() {
        return this.number >= ADVANCED_CONDITION_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RandomNumber that = (RandomNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
