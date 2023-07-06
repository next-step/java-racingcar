package car.domain.model;

import car.exceptions.NumberNegativeException;

public class Count {

    private int tryCount;

    public Count(final int userInputCount) {
        this.tryCount = validatePositive(userInputCount);
    }

    /**
     * @param userInputCount
     * @return int
     * @throws NumberNegativeException : 음수인 경우
     */
    private int validatePositive(final int userInputCount) {
        if (userInputCount < 0) {
            throw new NumberNegativeException("음수로 입력해 주세요");
        }
        return userInputCount;
    }

    public void decreaseTryCount() {
        this.tryCount--;
    }

    public int getTryCount() {
        return this.tryCount;
    }

}
