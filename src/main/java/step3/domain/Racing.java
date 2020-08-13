package step3.domain;

import step3.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {

    private int attemptNumber;
    private List<Car> cars;
    private final RacingRule racingRule;
    private final ResultView resultView;

    public Racing(String number, String attemptNumber) {
        this.attemptNumber = Integer.parseInt(attemptNumber);
        int carNumber = Integer.parseInt(number);
        this.racingRule = new RacingRule();
        this.cars = new ArrayList<>();
        this.resultView = new ResultView();

        for (int i = 0; i < carNumber; i++) {
            Car car = new Car();
            cars.add(car);
        }

    }

    public List<Car> getCars() {
        return cars;
    }

    private void racingRule() {
        cars.forEach(car -> {
            car.moveCar(racingRule.moveRule());
            resultView.resultOutput(car.getStatus());
        });

        System.out.println(" ");
    }

    public void racingStart() {
        System.out.println("실행 결과");
        IntStream.range(0, attemptNumber)
                .forEach(x -> racingRule());
    }
}
