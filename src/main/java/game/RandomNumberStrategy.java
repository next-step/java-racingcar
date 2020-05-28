package game;

import game.impl.MovingStrategy;

import java.util.Random;

public class RandomNumberStrategy implements MovingStrategy {

    public final Integer POINT_FORWARD = POINT;

    public final static Integer POINT = 4;

    public final static Integer RANDOM_NUMBER_MAX = 10;

    public int move(int count) {
        return getMovePosition(count);
    }

    /**
     * 시도횟수에 대한 이동 횟수 구하기
     *
     * @return
     */
    private int getMovePosition(int count) {

        int result = 0;
        for (int i = 0; i < count; i++) {
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
}
