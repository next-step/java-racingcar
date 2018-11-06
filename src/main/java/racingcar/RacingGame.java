package racingcar;

import java.util.Random;

public class RacingGame {

    private static final int MIN_NUM = 4;
    private static final int BOUND = 10;
    private static int time;
    private static int[] carPositions = {0, 0, 0};

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame();

        // 값 입력
        inputView.input();

        // 입력받은 값 획득
        carPositions = inputView.getCarPositions();
        time = inputView.getTime();

        // 게임 회수만큼 레이싱 시작
        for (int i=0; i< time; i ++) {
            carPositions = racingGame.move();
            // 게임 회수 마다 전체 결과 출력
            ResultView.showResult(carPositions);

            // 한 회수당 구분을 위한 줄바꿈 처리
            System.out.println();
        }
    }

    public int[] move() {
        moveCarPositions();
        return carPositions;
    }

    /**
     * 입력된 차량 대수만큼 포지션 값을 움직인다.
     */
    public void moveCarPositions() {
        for (int position = 0; position <carPositions.length; position++) {
            moveOnePosition(position, isCanMove());
        }
    }

    /**
     * @param position
     * 전진 가능한 조건이라면 한칸 이동.
     */
    public void moveOnePosition(int position, boolean isCanMove) {
        if(isCanMove) {
            carPositions[position] = carPositions[position] + 1;
        }
    }

    /**
     * 전진 가능여부 체크.
     */
    public Boolean isCanMove() {
        return getRandom() >= MIN_NUM;
    }

    /**
     * 0 ~ 9 랜덤한 숫자를 반환.
     */
    public int getRandom() {
        return new Random().nextInt(BOUND);
    }

    public int[] getCarPositions() {
        return carPositions;
    }
}
