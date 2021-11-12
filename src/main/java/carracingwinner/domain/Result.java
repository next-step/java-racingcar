package carracingwinner.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Result {

    private final String result;
    private final List<String> winners;

    public Result(List<Car> cars) {
        this.result = makeResult(cars);
        this.winners = findWinners(cars);
    }

    private String makeResult(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        cars.forEach(car -> {
            sb.append(car.showCurrentState()).append('\n');
        });
        return sb.toString();
    }

    private List<String> findWinners(List<Car> cars) {
        int max = cars.stream()
                .mapToInt(car -> car.getPosition().getIntValue())
                .max()
                .getAsInt();

        return cars.stream()
                .filter(car -> car.getPosition().getIntValue() == max)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    public String getResult() {
        return result;
    }

    public List<String> getWinners() {
        return winners;
    }

}
