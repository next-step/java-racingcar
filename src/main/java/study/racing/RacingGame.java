package study.racing;

import study.racing.ui.InputView;
import study.racing.ui.ResultView;

public class RacingGame {
    private final InputView inputView;
    private final ResultView resultView;

    private int time;
    private int[] carPositions;

    public RacingGame() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void play() {
        configureGameSettings();

        System.out.println("실행 결과");

        for(int i=0; i<time; i++) {
            move();
            resultView.printCarPositions(carPositions);
        }
    }

    private void configureGameSettings() {
        int numOfCars = inputView.scanIntWithQuestion("자동차 대수는 몇 대 인가요?");
        this.time = inputView.scanIntWithQuestion("시도할 회수는 몇 회 인가요?");

        carPositions = new int[numOfCars];
    }

    private void move() {
        for(int i=0; i<carPositions.length; i++) {
            if(canMove()) {
                carPositions[i]++;
            }
        }
    }

    private boolean canMove() {
        boolean result = false;

        if(getRandomNumber() >= 4) {
            result = true;
        }

        return result;
    }

    private int getRandomNumber() {
        double tmp = Math.random();
        return (int)(tmp * 10);
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.play();
    }
}
