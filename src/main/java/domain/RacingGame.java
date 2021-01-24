package domain;

import view.ResultView;

import java.util.ArrayList;

public class RacingGame {
    private int tryNo;
    private int nowNo;

    private ArrayList<Car> cars;

    public RacingGame(String carNames, int tryNo){
        CarFactory carFactory = new CarFactory();
        cars = carFactory.generateCars(carNames);

        this.tryNo = tryNo;
        this.nowNo = 0;

        ResultView.printStartSign();
    }

    public Boolean isEnd() {
        return nowNo == tryNo;
    }

    public void race() {
        for (Car car : cars) {
            car.move();
            ResultView.printCarStatus(car);
        }
        ResultView.printEmptyLine();
    }
}
