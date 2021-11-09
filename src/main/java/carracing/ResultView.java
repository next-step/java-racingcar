package carracing;

import java.util.Random;

/*
 * ResultView
 *
 * Version 1.0.0
 *
 * 2021-11-08
 *
 * author jiseok-choi
 */
public class ResultView {

    private final String[] racingCar;               /* 주행할 자동차 목록 */

    private static final int RANDOM_RANGE = 10;     /* 랜덤 숫자 범위 */
    private static final String RACING_INIT = "";   /* 차량 움직임 초기화 */
    private static final String MOVED = "-";        /* 차량 움직임 */
    private static final int MOVE_CONDITION = 4;    /* 차량 주행 조건 */

    public ResultView(int carCount) {

        racingCar = new String[carCount];
    }

    /**
     * 차량 주행 기능 메소드
     */
    public void racing() {
        Random random;
        for (int i = 0; i < racingCar.length; i++) {
            random = new Random();
            int randomNum = random.nextInt(RANDOM_RANGE);

            if (racingCar[i] == null) {
                racingCar[i] = RACING_INIT;
            }

            if (randomNum >= MOVE_CONDITION) {
                racingCar[i] = racingCar[i] + MOVED;
            }
        }
    }

    /**
     * 차량 주행 출력 메소드
     */
    public void printRacing() {
        System.out.println();
        for (String s : racingCar) {
            System.out.println(s);
        }
    }

}
