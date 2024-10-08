package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> carList;

    public Cars(List<Car> cars) {
        this.carList = cars;
    }

    public static Cars fromCarNames(List<String> carNames) {
        List<Car> carList = carNames.stream().map(c -> new Car(c, new RandomMoveStrategy())).collect(Collectors.toList());
        return new Cars(carList);
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public List<List<String>> runRace(int loop) {
        List<List<String>> raceResults = new ArrayList<>();
        for (int i = 0; i < loop; i++) {
            round();
            List<String> roundResult = carList.stream()
                    .map(car -> ResultView.generateCarStatusResult(car))
                    .collect(Collectors.toList());
            raceResults.add(roundResult);
        }

        return raceResults;
    }

    private void round() {
        for (Car car : this.carList) {
            car.run();
        }
    }

    public List<String> getWinners() {
        List<String> winnerNames = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car : this.carList) {
            saveWinnerName(car, maxPosition, winnerNames);
        }
        return winnerNames;
    }

    private static void saveWinnerName(Car car, int maxPosition, List<String> winnerNames) {
        if (car.comparePosition(maxPosition)) {
            winnerNames.add(car.getName());
        }
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : this.carList) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }
}
