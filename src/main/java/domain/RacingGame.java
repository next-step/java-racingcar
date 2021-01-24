package domain;

import java.util.ArrayList;

public class RacingGame {
    private int tryNo;
    private int nowNo;

    private ArrayList<Car> cars;

    public RacingGame(String carNames, int tryNo){
        CarFactory carFactory = new CarFactory();
        cars = carFactory.getCars(carNames);

        this.tryNo = tryNo;
        this.nowNo = 0;
    }

    public Boolean isEnd() {
        return nowNo == tryNo;
    }

    public void race() {

    }
}
