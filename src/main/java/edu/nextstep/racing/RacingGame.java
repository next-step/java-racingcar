package edu.nextstep.racing;

import java.util.ArrayList;

public class RacingGame<T> {
    private ArrayList carList;

    RacingGame() {
        carList = new ArrayList<>();
    }

    public void setUp(MovingCheck movingCheck) {
        ResultView.view("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String[] carNames = InputView.splitCarName();

        ResultView.view("시도할 회수는 몇 회 인가요?");
        int gameNum = InputView.inputer();

        startGame(movingCheck, carNames, gameNum);
    }

    public void setUpTest(MovingCheck movingCheck, String carNames, int gameNum) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("input data is empty");
        }
        startGame(movingCheck, carNames.split(","), gameNum);
    }

    public void startGame(MovingCheck movingCheck, String[] carNames, int gameNum) {
        if (gameNum < 0) {
            throw new IllegalArgumentException("Input Data Error");
        }

        for (int i = 0; i < carNames.length; i++) {
            carList.add(new RacingCar(carNames[i]));
        }

        ResultView.view("실행 결과");

        for (int i = 0; i < gameNum; i++) {
            for (int j = 0; j < carNames.length; j++) {
                RacingCar car = (RacingCar)carList.get(j);
                car.move(movingCheck);
            }
            resultGame(carNames.length);
            ResultView.newLine();
        }

        ArrayList winnerList = new ArrayList<>();
        int winnerPosition = 0;
        for (int i = 0; i < carList.size(); i++) {
            if ( ((RacingCar)carList.get(i)).getStatus() > winnerPosition ) {
                winnerPosition = ((RacingCar)carList.get(i)).getStatus();
            }
        }

        for (int i = 0; i < carList.size(); i++) {
            if ( ((RacingCar)carList.get(i)).getStatus() == winnerPosition ) {
                winnerList.add(carList.get(i));
            }
        }

        ResultView.winnerView(winnerList);
    }

    public void resultGame(int carNum) {
        for (int i = 0; i < carNum; i++) {
            RacingCar car = (RacingCar)carList.get(i);
            ResultView.carView(car.getCarName());
            for (int j = 0; j < car.getStatus(); j++) {
                ResultView.carLineView();
            }
            ResultView.newLine();
        }
    }
}
