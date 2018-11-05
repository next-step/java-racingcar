package racing;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final int MIN_NUM = 4;
    private static final int BOUND = 10;
    private static final int ZERO = 0;
    private Random random = SecureRandom.getInstanceStrong();
    private List<Integer> carPositions;
    private int time;


    /**
     * 초기화
     *
     * @param time   횟수
     * @param carNum 차 숫자
     */
    public RacingGame(int carNum, int time) throws NoSuchAlgorithmException {
        this.time = time;
        carPositions = new ArrayList<>();

        // 차 넣기
        for (int i = 0; i < carNum; i++) {
            carPositions.add(ZERO);
        }
    }

    /**
     * 이동
     *
     * @return
     */
    public List<Integer> move() {
        for (int i = 0; i < carPositions.size(); i++) {
            Integer position = carPositions.get(i);
            int randNum = random.nextInt(BOUND);
            if (canMove(randNum)) {
                carPositions.set(i, ++position);
            }
        }

        --time;
        return carPositions;
    }

    /**
     * 움직일 수 있는지. 움직일 수 있으면 return 1
     *
     * @param num
     * @return
     */
    public static boolean canMove(int num) {
        return num >= MIN_NUM;
    }

    /**
     * 게임이 진행 가능한지 여부
     *
     * @return
     */
    public boolean canContinue() {
        return time > ZERO;
    }
}
