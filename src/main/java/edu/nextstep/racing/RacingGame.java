package edu.nextstep.racing;

import java.util.ArrayList;

public class RacingGame {
    ResultView resultViewer = null;
    InputView inputView = null;
    ArrayList<RacingCar> carList = null;
    int carNum = 0;
    int gameNum = 0;

    RacingGame() {
        resultViewer = new ResultView();
        inputView = new InputView();
        carList = new ArrayList<>();

        setUp();
    }

    public void setUp() {
        resultViewer.view("자동차 대수는 몇 대 인가요?");
        carNum = inputView.inputer();

        resultViewer.view("시도할 회수는 몇 회 인가요?");
        gameNum = inputView.inputer();
    }

    public void startGame() {
        for (int i = 0; i < carNum; i++) {
            carList.add(new RacingCar());
        }

        for (int i = 0; i < gameNum; i++) {
            for (int j = 0; j < carNum; j++) {
                carList.get(j).move();
            }
        }
    }

    public void resultGame() {
        resultViewer.view("실행 결과");

        for (int i = 0; i < carNum; i++) {
            resultViewer.view(String.valueOf(carList.get(i).getStatus()));
        }
    }

}
