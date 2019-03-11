package racing;

import java.util.Random;

public class GameRule {
    // 상수 : 최대 랜덤값
    final int CONST_MAX_RANDOM_NUM = 10;
    // 상수 : 조건값
    final int CONST_CONDITION_NUM = 4;

    private  boolean useRandomYn;

    public GameRule(boolean useRandomYn)
    {
        this.useRandomYn = useRandomYn;
    }

    public boolean randomNumberRule()
    {
        if(!useRandomYn)
        {
            return true;
        }

        Random random = new Random();
        return random.nextInt(CONST_MAX_RANDOM_NUM) >= CONST_CONDITION_NUM;
    }
}
