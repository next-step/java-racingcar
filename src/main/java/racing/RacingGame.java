package racing;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private int time;
    private List<Integer> carPositions;
    private static final int MIN_NUM = 4;
    private static final int BOUND = 9 + 1;
    private Random random = SecureRandom.getInstanceStrong();

    /**
     * 초기화
     *
     * @param time   횟수
     * @param carNum 차 숫자
     */
    public RacingGame(int time, int carNum) throws NoSuchAlgorithmException {
        this.time = time;
        carPositions = new ArrayList<>();

        // 차 넣기
        for (int i = 0; i < carNum; i++) {
            carPositions.add(0);
        }
    }

    /**
     * 시작
     */
    public void start() {
        System.out.println("실행결과");

        for (int i = 0; i < time; i++) {
            carPositions = move();
            ResultView.printAll(carPositions);
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
            carPositions.set(i, position + canMove(randNum));
        }

        return carPositions;
    }

    /**
     * 움직일 수 있는지. 움직일 수 있으면 return 1
     *
     * @param num
     * @return
     */
    public static int canMove(int num) {
        if (num >= MIN_NUM) {
            return 1;
        }

        return 0;
    }
}
