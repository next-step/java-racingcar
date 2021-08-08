package racingcar;

public class MoveRuleByRandomValue implements MoveRule {

    private boolean movable;
    private final static int MIN_NUM_TO_MOVE = 4;

    public MoveRuleByRandomValue() {

    }
    /* 테스트를 위한 생성자 */
    public MoveRuleByRandomValue(int randomNumber) {
        this.movable = randomNumber >= MIN_NUM_TO_MOVE;
    }

    /* 테스트를 위한 생성자 */
    public MoveRuleByRandomValue(boolean movable) {
        this.movable = movable;
    }

    @Override
    public boolean ableToMoveCar() {
        movable = new RandomNumGenerator().getRandomNumber() >= MIN_NUM_TO_MOVE;
        return movable;
    }
}
