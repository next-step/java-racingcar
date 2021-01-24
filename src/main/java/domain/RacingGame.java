package domain;

import java.util.ArrayList;

public class RacingGame {
    private ArrayList<Car> cars;
    private int tryNo;
    private int nowNo;

    public RacingGame(String carNames, int tryNo){
        cars = CarFactory.getCars(carNames);
        this.tryNo = tryNo;
        this.nowNo = 0;
    }

    public Boolean isEnd() {
        return nowNo == tryNo;
    }

    public void race() {

    }
}
