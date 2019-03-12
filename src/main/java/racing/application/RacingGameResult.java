package racing.application;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult implements Result<Car> {
    public List<String> judgeWinners(List<Car> cars) {
        List<Car> sorted = sortByPosition(cars);
        return getCarNameOfWinners(sorted);
    }

    public List<Car> sortByPosition(List<Car> cars) {
        return cars.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private List<String> getCarNameOfWinners(List<Car> sorted) {
        return sorted.stream()
                .filter(v -> getWinnerPosition(sorted) == v.getPosition())
                .map(v -> v.getName())
                .collect(Collectors.toList());
    }

    private int getWinnerPosition(List<Car> sorted) {
        return sorted.get(0).getPosition();
    }

    @Override
    public List<String> judge(List cars) {
        return judgeWinners(cars);
    }
}
