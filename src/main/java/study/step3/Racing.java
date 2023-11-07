package study.step3;

import java.util.ArrayList;
import java.util.List;

import static study.step3.ResultView.showResult;
import static study.step3.ResultView.showResultTitle;

public class Racing {

    private List<Car> cars;
    private int movingTimes;

    private NumberGenerator numberGenerator;

    public Racing(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Racing(List<Car> cars, int movingTimes) {
        this.cars = cars;
        this.movingTimes = movingTimes;
    }

    public void start(Rule rule) {
        run(prepare(rule));
    }

    private Racing prepare(Rule rule) {
        return setUpRacing(rule);
    }

    private Racing setUpRacing(Rule rule) {
        List<Car> inReadyCars = new ArrayList<>();
        for (int i = 0; i < rule.getNumberOfCars(); i++) {
            inReadyCars.add(new Car());
        }
        return new Racing(inReadyCars, rule.getMovingTimes());
    }

    private void run(Racing racing) {
        showResultTitle();
        for (int i = 0; i < racing.getMovingTimes(); i++) {
            List<Car> cars = racing.getCars();
            move(cars);
            showResult(cars);
        }
    }

    private void move(List<Car> cars) {
        for (Car car: cars) {
            car.move(numberGenerator.generate());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMovingTimes() {
        return movingTimes;
    }

}
