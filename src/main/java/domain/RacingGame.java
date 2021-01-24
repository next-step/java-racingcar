package domain;

import java.util.ArrayList;

public class RacingGame {
    private ArrayList<Car> cars;
    private int tryNo;

    public RacingGame(String carNames, int tryNo){
        cars = CarFactory.getCars(carNames);
        this.tryNo = tryNo;
    }
}
