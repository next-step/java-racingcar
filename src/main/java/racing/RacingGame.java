package racing;

import racing.view.InputView;
import racing.view.ResultView;

import java.util.Random;

public class RacingGame {

    private int[] carPositions ;
    private Random random = new Random();
    private static final int MOVE_CONDITION_NUM = 4;

    public RacingGame(int carNum) {
        if (carNum == 0) {
            throw new IllegalArgumentException("차 대수는 0 이상이야 합니다.");
        }

        this.carPositions = new int[carNum];
    }

    public int[] move() {
        for (int i = 0 ; i < carPositions.length ; i++) {
            if (canMove()) {
                carPositions[i]++;
            }
        }
        return carPositions;
    }

    private boolean canMove() {
        return random.nextInt(10) > MOVE_CONDITION_NUM;
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int carNum = inputView.inputInt("자동차 대수는 몇 대 인가요?");
        RacingGame racingGame = new RacingGame(carNum);

        int time = inputView.inputInt("시도할 회수는 몇 회 인가요?");

        System.out.println("실행 결과");
        for (int t = 0 ; t < time ; t++) {
            resultView.printPositions(racingGame.move());
        }
    }

}
