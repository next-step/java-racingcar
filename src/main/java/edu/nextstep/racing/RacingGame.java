package edu.nextstep.racing;

import java.util.ArrayList;

public class RacingGame<T> {
    private ArrayList carList;

    RacingGame() {
        carList = new ArrayList<>();
    }

    public void setUp(MovingCheck movingCheck) {
        ResultView.view("자동차 대수는 몇 대 인가요?");
        int carNum = InputView.inputer();

        ResultView.view("시도할 회수는 몇 회 인가요?");
        int gameNum = InputView.inputer();

        startGame(movingCheck, carNum, gameNum);
    }

    public void setUpTest(MovingCheck movingCheck, int carNum, int gameNum) {
        startGame(movingCheck, carNum, gameNum);
    }

    public void startGame(MovingCheck movingCheck, int carNum, int gameNum) {
        if (carNum < 0 || gameNum < 0) {
            throw new IllegalArgumentException("Input Data Error");
        }

        for (int i = 0; i < carNum; i++) {
            carList.add(new RacingCar());
        }

        for (int i = 0; i < gameNum; i++) {
            for (int j = 0; j < carNum; j++) {
                RacingCar car = (RacingCar)carList.get(j);
                car.move(movingCheck);
            }
        }

        resultGame(carNum);
    }

    public void resultGame(int carNum) {
        ResultView.view("실행 결과");

        for (int i = 0; i < carNum; i++) {
            RacingCar car = (RacingCar)carList.get(i);
            for (int j = 0; j < car.getStatus(); j++) {
                ResultView.carLineView();
            }
            ResultView.newLine();
        }
    }

}
