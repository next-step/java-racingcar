package race;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private final String FORWARD_STRING = "-";

    public void printRaceCondition(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> {
            int distance = racingCar.getPosition();
            System.out.println(racingCar.getName() + " : " + FORWARD_STRING.repeat(distance));
        });
        System.out.println();
    }

    public void printChampionWinner(List<RacingCar> winners) {
        String winnerNames = winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(","));

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
