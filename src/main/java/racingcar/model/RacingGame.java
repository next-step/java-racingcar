package racingcar.model;

import java.util.ArrayList;

public class RacingGame {
    private int time;
    private ArrayList<Car> cars = new ArrayList();

    public static RacingGame of(int time, int carCount) {
        return new RacingGame(time, carCount);
    }

    private RacingGame(int time, int carCount) {
        validateNegative(time, carCount);
        this.time = time;
        for (int i = 0; i < carCount; i++) {
            addCar();
        }
    }

    private void validateNegative(int time, int carCount) {
        if( 0 > time || 0 > carCount ){
            throw new IllegalArgumentException("음수는 입력이 불가합니다.");
        }
    }

    private void addCar() {
        cars.add(Car.of());
    }

    public ArrayList move() {
        time --;
        for (Car car : cars) {
            car.move(4);
        }
        return cars;
    }

    ArrayList getCars() {
        return cars;
    }

    public int getTime() {
        return time;
    }
}
