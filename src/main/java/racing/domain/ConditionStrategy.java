package racing.domain;

import java.util.Random;

public class ConditionStrategy implements GameCondition{

    private static final int MOVE_NUMBER = 4;
    private static final int RANDOM_RANGE = 10;
    private int randomNumber;

    public int getRandomNumber() {
        return this.randomNumber;
    }

    /**
     * 자동차가 움직이는 조건을 판단하는 랜덤 숫자를 생성 후 조건 값 이상이면 참을 반환한다.
     * @return
     */
    @Override
    public boolean moveCondition() {
        this.randomNumber = new Random().nextInt(RANDOM_RANGE);
        return (randomNumber >= MOVE_NUMBER);
    }
}
