package game.view;

import game.domain.CarAction;
import game.domain.Cars;

import java.util.stream.IntStream;

public class ResultView {
    private final Cars cars;
    private final ResultAggregation aggregation;

    public ResultView(Cars cars) {
        this.cars = cars;
        this.aggregation = new ResultAggregation(cars.count());
    }


    public void show() {
        System.out.println("실행 결과");
        IntStream.range(0, cars.racingCount())
                .forEach(this::aggregateResultAndShow);
    }

    private void aggregateResultAndShow(int rep) {
        for (int carNumber = 0; carNumber < cars.count(); carNumber++) {
            CarAction currentCarAction = cars.racingResult(carNumber, rep);
            aggregation.aggregate(carNumber, currentCarAction);
        }
        aggregation.showResult();
    }
}