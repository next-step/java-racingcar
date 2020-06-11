package step4.model;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Result {

    private static final String NAME_SEPARATOR = ", ";
    private static final String DELIMITER = "";
    private static final int SUBSTRING_START = 0;
    private static final int SUBSTRING_END = 2;
    private List<Car> result;

    public Result(List<Car> result) {
        this.result = result;
    }

    public List<Car> getResult() {
        return this.result;
    }

    public int getMax() {
        return result.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(IllegalAccessError::new)
                .getPosition();
    }

    public String getWinner() {
        List<Car> winners = getWinners(getMax());
        String winner = winners.stream()
                .reduce(DELIMITER, getWinnerBiFunction(), String::concat);
        return winner.substring(SUBSTRING_START, winner.length() - SUBSTRING_END);
    };

    private static BiFunction<String, Car, String> getWinnerBiFunction() {
        return (sub, element) -> sub + element.getName() + NAME_SEPARATOR;
    }

    List<Car> getWinners(int maximum) {
        return result.stream()
                .filter(car -> car.getPosition() == maximum)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result1 = (Result) o;
        return Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return "Result{" +
                "result=" + result +
                '}';
    }


}
