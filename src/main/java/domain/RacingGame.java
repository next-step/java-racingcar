package domain;

import view.ResultView;

import java.util.ArrayList;

public class RacingGame {
    private int tryNo;
    private int nowNo;

    private ArrayList<Car> cars;
    private ArrayList<String> winners;

    public RacingGame(String carNames, int tryNo){
        CarFactory carFactory = new CarFactory();
        cars = carFactory.generateCars(carNames);

        this.tryNo = tryNo;
        this.nowNo = 0;

        ResultView.printStartSign();
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public Boolean isEnd() {
        return nowNo == tryNo;
    }

    public void race() {
        for (Car car : cars) {
            car.move();
        }
        nowNo++;
    }

    public ArrayList<String> getWinners() {
        int maxStatus = getMaxStatus();
        winners = new ArrayList<>();
        for (Car car : cars) {
            findWinner(car, maxStatus);
        }
        return winners;
    }

    public int getMaxStatus() {
        int maxStatus = -1;
        for (Car car : cars) {
            maxStatus = getMax(car.getStatus(), maxStatus);
        }
        return maxStatus;
    }

    public int getMax(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public void findWinner(Car car, int maxStatus) {
        if (car.getStatus() == maxStatus) {
            winners.add(car.getName());
        }
    }
}
