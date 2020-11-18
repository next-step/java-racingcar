package study.step5.domain;

import study.step5.domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String inputCarNames) {
        this.cars = split(inputCarNames);
    }

    /* 입력값 세팅 */
    private List<Car> split(String inputCarNames) {
        List<Car> cars = new ArrayList<>();
        String[] carNames = inputCarNames.split(",");
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }
    /* 우승자 추출 */
    public List<Car> getWinners() {
        int max = getMaxScore();
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            compareMaxScoreAddWinner(winners, car, max);
        }
        return Collections.unmodifiableList(winners);
    }
    /* 최대 스코어 추출 */
    private int getMaxScore() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(car.getScore(), max);
        }
        return max;
    }
    /* 최대스코어 비교 및 우승자 추가 */
    private void compareMaxScoreAddWinner(List<Car> winners, Car car, int max) {
        if (car.getScore() == max) {
            winners.add(car);
        }
    }

    public int getSize() {
        return this.cars.size();
    }

    public Car getCar(int carsIndex) {
        return this.cars.get(carsIndex);
    }
}
