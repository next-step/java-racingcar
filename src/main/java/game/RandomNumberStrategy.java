package game;

import game.impl.MovingStrategy;

import java.util.Random;

public class RandomNumberStrategy implements MovingStrategy {

    private static final Integer POINT = 4;

    private static final Integer POINT_FORWARD = POINT;

    private static final Integer RANDOM_NUMBER_MAX = 10;

    public int move(int playCount) {
        return getMovePosition(playCount);
    }

    /**
     * 시도횟수에 대한 이동 횟수 구하기
     *
     * @return
     */
    private int getMovePosition(int playCount) {

        int result = 0;
        for (int i = 0; i < playCount; i++) {
            result += getPoint();
        }
        return result;
    }

    /**
     * 전진 점수
     *
     * @return
     */
    private int getPoint() {
        int point = 1;
        boolean flag = isGoForward();
        if (!flag) {
            point = 0;
        }
        return point;
    }

    /**
     * 전진/정지 여부
     *
     * @return
     */
    private boolean isGoForward() {
        return new Random().nextInt(RANDOM_NUMBER_MAX) >= POINT_FORWARD;
    }

    public static RandomNumberStrategy create() {
        return new RandomNumberStrategy();
    }
}
