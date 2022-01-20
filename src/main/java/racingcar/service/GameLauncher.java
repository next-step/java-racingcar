package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.RacingCar;

public class GameLauncher {

    private final List<RacingCar> racingCarList;

    public GameLauncher(List<String> nameList) {
        racingCarList = new ArrayList<>();

        for (String name : nameList) {
            racingCarList.add(new RacingCar(name));
        }
    }

    public void moveForwardAll() {
        for (RacingCar car : racingCarList) {
            car.moveForward();
        }
    }

    public void printRacing() {
        racingCarList.forEach(System.out::println);
    }

    public void printWinner() {
        int maxPosition = racingCarList.stream()
            .mapToInt(RacingCar::getPosition)
            .max().getAsInt();

        List<String> winnerList = racingCarList.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(RacingCar::getName)
            .collect(Collectors.toList());

        System.out.print("최종 우승자: " + String.join(", ", winnerList));
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }
}

