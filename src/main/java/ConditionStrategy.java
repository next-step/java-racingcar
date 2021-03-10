import java.util.Random;

public class ConditionStrategy implements GameCondition{

    private static final int RANDOM_RANGE = 10;

    /**
     * 자동차가 움직이는 조건을 판단하는 랜덤 숫자를 생성
     * @return
     */
    @Override
    public int moveCondition() {
        return new Random().nextInt(RANDOM_RANGE);
    }
}
