package edu.nextstep.racing;

import java.util.ArrayList;

public class RacingGame<T> {
    private ArrayList carList;

    RacingGame() {
        carList = new ArrayList<>();
    }

    public void setUp(MovingCheck movingCheck) {
        ResultView.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String[] carNames = InputView.splitCarName();

        ResultView.print("시도할 회수는 몇 회 인가요?");
        int gameNum = InputView.inputer();

        gameNumCheck(gameNum < 0, "Input Data Error");
        startGame(movingCheck, carNames, gameNum);
    }

    public void setUpTest(MovingCheck movingCheck, String carNames, int gameNum) {
        gameNumCheck(carNames.isEmpty(), "input data is empty");
        startGame(movingCheck, carNames.split(","), gameNum);
    }

    public void startGame(MovingCheck movingCheck, String[] carNames, int gameNum) {
        setUpRacingCar(carNames);

        ResultView.print("실행 결과");
        for (int i = 0; i < gameNum; i++) {
            carMoving(movingCheck, carNames);
            ResultView.newLine();
        }

        ArrayList winnerList = checkWinner();

        ResultView.winnerNameView(winnerList);
    }

    private ArrayList checkWinner() {
        int winnerPosition = 0;
        for (int i = 0; i < carList.size(); i++) {
            winnerPosition = getWinnerPosition(winnerPosition, i);
        }

        ArrayList winnerList = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            getWinnerList(winnerPosition, winnerList, i);
        }
        return winnerList;
    }

    private void setUpRacingCar(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carList.add(new RacingCar(carNames[i]));
        }
    }

    private void gameNumCheck(boolean condition, String errorMsg) {
        if (condition) {
            throw new IllegalArgumentException(errorMsg);
        }
    }

    private int getWinnerPosition(int winnerPosition, int i) {
        if ( ((RacingCar)carList.get(i)).getStatus() > winnerPosition ) {
            winnerPosition = ((RacingCar)carList.get(i)).getStatus();
        }
        return winnerPosition;
    }

    private void getWinnerList(int winnerPosition, ArrayList winnerList, int i) {
        if ( ((RacingCar)carList.get(i)).getStatus() == winnerPosition ) {
            winnerList.add(carList.get(i));
        }
    }

    private void carMoving(MovingCheck movingCheck, String[] carNames) {
        for (int j = 0; j < carNames.length; j++) {
            RacingCar car = (RacingCar)carList.get(j);
            car.move(movingCheck);
            ResultView.carLineView(car.getCarName(), car.getStatus());
        }
    }
}
