package game.view;

import game.domain.CarAction;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultAggregation {
    private final List<StringBuilder> results;

    public ResultAggregation(int count) {
        this.results = initResult(count);
    }

    private List<StringBuilder> initResult(int count) {
        return IntStream.range(0, count)
                .mapToObj(n -> new StringBuilder())
                .collect(Collectors.toUnmodifiableList());
    }

    public void showResult() {
        for (StringBuilder sb : results) {
            System.out.println(sb.toString());
        }
        System.out.println();
    }

    public void aggregate(int carNumber, CarAction carAction) {
        aggregate(carNumber, carAction.value());
    }

    public void aggregate(int carNumber, String carActionValue) {
        StringBuilder currentResult = results.get(carNumber);
        currentResult.append(carActionValue);
    }
}