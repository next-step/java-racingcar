package step3;

import java.util.Random;

/**
 * 차가 전진하려면 4이상의 숫자를 얻어야 한다. 룰렛을 돌리면(spin) 숫자가 하나 나온다
 * 룰렛이
 */
public interface RaceRoulette {
    /**
     * 룰렛을 돌리면 임의의 숫자를 돌려준다.
     *
     * @return
     */
    int spin();

    static RaceRoulette simple(int max){
        return new RaceRoulette() {
            private int maxNumber = max;
            private Random random = new Random();

            @Override
            public int spin() {
                return random.nextInt(maxNumber);
            }
        };
    }
}
