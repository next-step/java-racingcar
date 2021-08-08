package racingcar;

public class RandomStrategy implements MoveStrategy {

    private final static int MIN_NUM_TO_MOVE = 4;

    RandomNumber randomNumber;

    public RandomStrategy() {
        this.randomNumber = new RandomNumber();
    }

    /* 테스트를 위한 생성자 */
    public RandomStrategy(int randomNum) {
        this.randomNumber = new RandomNumber() {
            @Override
            public int getRandomNumber() {
                return randomNum;
            }
        };
    }

    @Override
    public boolean movable() {
        return randomNumber.getRandomNumber() >= MIN_NUM_TO_MOVE;
    }
}
