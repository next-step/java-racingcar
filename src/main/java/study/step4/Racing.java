package study.step4;

import java.util.ArrayList;
import java.util.List;

import static study.step4.ResultView.showResult;

public class Racing {

    NumberGenerator numberGenerator;
    List<Car> winners = new ArrayList<>();

    public Racing(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Car> run(Rule rule) {
        return start(rule);
    }

    private List<Car> start(Rule rule) {
        List<Car> cars = rule.getCars();
        for (int i = 0; i < rule.getMovingTimes(); i++) {
            moveCars(cars);
            showResult(cars);
        }
        return getWinners(cars);
    }

    private void moveCars(List<Car> cars) {
        for (Car car: cars) {
            move(car);
        }
    }

    private void move(Car car) {
        car.move(numberGenerator.generate());
    }

    private List<Car> getWinners(List<Car> cars) {
        for (Car car: cars) {
            addWinner(car, getMaxPosition(cars));
        }
        return winners;
    }

    private void addWinner(Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
    }

    private int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car: cars) {
            maxPosition = compare(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private int compare(int maxValue, int currentValue) {
        if (currentValue >= maxValue) {
            maxValue = currentValue;
        }
        return maxValue;
    }


}
