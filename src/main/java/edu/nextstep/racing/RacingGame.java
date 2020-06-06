package edu.nextstep.racing;

import java.util.ArrayList;

public class RacingGame {
    ResultView resultViewer;
    InputView inputView;
    MovingCheck movingCheck;
    ArrayList<RacingCar> carList;
    private int carNum = 0;
    private int gameNum = 0;

    RacingGame(ResultView resultView, InputView inputView, MovingCheck movingCheck) {
        this.resultViewer = resultView;
        this.inputView = inputView;
        this.movingCheck = movingCheck;
        carList = new ArrayList<>();
    }

    public void setUp() {
        resultViewer.view("자동차 대수는 몇 대 인가요?");
        carNum = inputView.inputer();

        resultViewer.view("시도할 회수는 몇 회 인가요?");
        gameNum = inputView.inputer();
    }

    public void setUp(int carNum, int gameNum) {
        if (carNum < 0 || gameNum < 0) {
            throw new IllegalArgumentException("Input Data Error");
        }

        this.carNum = carNum;
        this.gameNum = gameNum;
    }

    public void startGame() {
        for (int i = 0; i < carNum; i++) {
            carList.add(new RacingCar());
        }

        for (int i = 0; i < gameNum; i++) {
            for (int j = 0; j < carNum; j++) {
                carList.get(j).move(movingCheck);
            }
        }
    }

    public void resultGame() {
        resultViewer.view("실행 결과");

        for (int i = 0; i < carNum; i++) {
            for (int j = 0; j < carList.get(i).getStatus(); j++) {
                resultViewer.carLineView();
            }
            resultViewer.newLine();
        }
    }

}
