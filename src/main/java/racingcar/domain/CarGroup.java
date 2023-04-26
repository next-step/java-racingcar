package racingcar.domain;

import racingcar.dto.RandomValue;

import java.util.List;
import java.util.stream.Collectors;

public class CarGroup {

    private final List<Car> carGroup;

    public CarGroup(List<Car> carGroup) {
        this.carGroup = carGroup;
    }

    public void moveAll() {
        carGroup.stream()
                .forEach(car -> car.move(new RandomValue()));
    }

    public static List<String> extractWinnerNames(List<Car> playerList) {
        int distanceMax = recordDistanceMax(playerList);
        List<Car> winners = pickWinners(playerList, distanceMax);

        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private static int recordDistanceMax(List<Car> playerList) {
        int distanceMax = 0;
        for (Car car : playerList) {
            distanceMax = car.chooseLongerDistance(distanceMax);
        }
        return distanceMax;
    }

    private static List<Car> pickWinners(List<Car> playerList, int distanceMax) {
        return playerList.stream()
                .filter(car -> car.isSameDistance(distanceMax))
                .collect(Collectors.toList());
    }

    public List<Car> getCarList() {
        return List.copyOf(carGroup);
    }

}
