package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }


    public void setCarNumber(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
    }

    public void setCarNames(String[] carNames) {
        for (String carName : carNames) {
            this.addCar(carName);
        }
    }

    public void addCar(String name) {
        Car newCar = new Car(name);
        cars.add(newCar);
    }

    // List 에 영향을 못 미치게 해주기
    // 수정부가능한 컬렉션 반환
    public List<Car> getCar() {
        return Collections.unmodifiableList(this.cars);
    }

    public int getCatNumber() {
        return cars.size();
    }

    public String getWinners() {
        StringBuilder winners = new StringBuilder();
        int max = -1;
        for (Car car : cars) {
            max = getWinner(winners, max, car);
        }

        return winners.toString();
    }

    private int getWinner(StringBuilder winners, int max, Car car) {
        if (car.getPosition() < max) return max;

        if (car.getPosition() > max) {
            max = car.getPosition();
            winners.setLength(0);
            winners.append(car.getName());
            return max;
        }

        if (car.getPosition() == max) {
            winners.append(" ");
            winners.append(car.getName());
            return max;
        }

        return max;
    }

}
