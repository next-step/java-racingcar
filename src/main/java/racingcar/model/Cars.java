package racingcar.model;

import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cars {
    public final int RANDOM_RANGE = 10;

    private List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public Cars(int number) {
        this();
        this.setCarNumber(number);
    }

    public Cars(String[] carNames){
        this();
        this.setCarNames(carNames);
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
        return getWinnersNames(calculateMaxPosition(cars));
    }

    private String getWinnersNames(int max) {
        StringBuilder winners = new StringBuilder();
        for (Car car : cars) {
            boolean equal  = checkEqualMax(max, car);

            if (equal){
                appendCarName(winners, car);
            }
        }

        return winners.toString();
    }

    private boolean checkEqualMax(int max, Car car) {
        return car.getPosition() == max;
    }

    private void appendCarName(StringBuilder winners, Car car) {
        if(winners.length() > 0){
            winners.append(" ");
        }
        winners.append(car.getName());
    }

    private int calculateMaxPosition(List<Car> cars) {
        int max = -1;
        for (Car car : cars) {
            max = getMaxPosition(max, car);
        }
        return max;
    }

    public int getMaxPosition(int max, Car car) {
        return Math.max(max, car.getPosition());
    }

    public void printWinner() {
        ResultView.printWinner(this);
    }

    public void printResult() {
        ResultView.printResultWithName(this);
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(getRandomValue());
        }
    }

    public int getRandomValue() {
        Random random = new Random();
        return random.nextInt(RANDOM_RANGE);
    }
}
