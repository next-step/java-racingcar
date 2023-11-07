package racing;

import java.util.Random;

public class CarMoveStrategy {

    public static final Random RANDOM = new Random();

    /**
     * 자동차가 움직일지를 결정하는 로직 함수입니다.
     *
     * @return 움직이는 여부. true면 움직이라는 신호입니다.
     */
    public static boolean doIMove() {
        return RANDOM.nextInt(10) >= 4;
    }
}