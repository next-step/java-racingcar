package race.view;

import race.domain.RacingCar;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    private final String FORWARD_STRING = "-";

    public void printRaceCondition(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> {
            String distanceString = racingCar.drawForwardDistance(FORWARD_STRING);
            racingCar.printName();
            System.out.println(" : " + distanceString);
        });
        System.out.println();
    }

    public void printChampionWinner(List<RacingCar> winners) {
        IntStream.range(0, winners.size()).forEach(index -> {
            RacingCar racingCar = winners.get(index);
            racingCar.printNameWithComma(index != winners.size() - 1);
        });
        System.out.println("가 최종 우승했습니다.");
    }

    public void printRaceStartMessage() {
        System.out.println("실행 결과");
    }
}
