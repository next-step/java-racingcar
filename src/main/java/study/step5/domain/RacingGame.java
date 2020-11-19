package study.step5.domain;

import java.util.Random;

/*
 * RacingGame
 *
 * 1.0.0
 *
 * 2020-11-17
 */
public class RacingGame {
    private Random random = new Random();

    public void start(Cars cars) {
        for (int i = 0; i < cars.getSize(); i++) {
            cars.getCar(i).go(randomNumber());
        }
    }

    /* 1~10 사이 랜덤숫자 추출 */
    private int randomNumber () {
        return random.nextInt(10);
    }
}