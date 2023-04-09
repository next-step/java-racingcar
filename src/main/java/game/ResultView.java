package game;

import java.util.stream.IntStream;

public class ResultView {
    private final Cars cars;
    private final AggregationResults results;

    public ResultView(Cars cars) {
        this.cars = cars;
        this.results = new AggregationResults(cars.count());
    }


    public void show() {
        System.out.println("실행 결과");
        IntStream.range(0, cars.racingCount())
                .forEach(this::aggregateResultAndShow);
    }

    private void aggregateResultAndShow(int rep) {
        for (int carNumber = 0; carNumber < cars.count(); carNumber++) {
            CarAction currentCarAction = cars.racingResult(carNumber, rep);
            results.aggregate(carNumber, currentCarAction);
        }
        results.showResult();
    }
}