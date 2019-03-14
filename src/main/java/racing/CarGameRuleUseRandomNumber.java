package racing;

import java.util.Random;

public class CarGameRuleUseRandomNumber implements GameRule {
    // 상수 : 최대 랜덤값
    final int CONST_MAX_RANDOM_NUM = 10;
    // 상수 : 조건값
    final int CONST_CONDITION_NUM = 4;

    @Override
    public boolean moveRacingGameRule() {
        Random random = new Random();
        return random.nextInt(CONST_MAX_RANDOM_NUM) >= CONST_CONDITION_NUM;
    }
}
