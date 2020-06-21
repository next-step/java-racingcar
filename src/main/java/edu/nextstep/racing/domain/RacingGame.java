package edu.nextstep.racing.domain;

import edu.nextstep.racing.view.ResultView;

import java.util.ArrayList;

public class RacingGame<T> {
    private ArrayList carList;

    public RacingGame() {
        carList = new ArrayList<>();
    }

    public ArrayList getWinnerList() {
        ArrayList winnerList = checkWinner();
        return winnerList;
    }

    public void setUpRacingCar(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carList.add(new RacingCar(carNames[i]));
        }
    }

    public void gameNumCheck(boolean condition, String errorMsg) {
        if (condition) {
            throw new IllegalArgumentException(errorMsg);
        }
    }

    public void carMoving(MovingCheck movingCheck, String[] carNames) {
        for (int j = 0; j < carNames.length; j++) {
            RacingCar car = (RacingCar)carList.get(j);
            car.move(movingCheck);
            ResultView.carLineView(car.getCarName(), car.getStatus());
        }
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
}
