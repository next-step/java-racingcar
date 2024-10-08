package race.view;

import race.model.RaceRecord;
import race.model.RaceResult;
import race.model.CarName;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private final String FORWARD_STRING = "-";


    public void printChampionWinner(List<CarName> winners) {
        String winnerNames = winners.stream()
                .map(CarName::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    public void printRaceStartMessage() {
        System.out.println("실행 결과");
    }

    public void printRaceResult(RaceResult raceResult) {
        for (RaceRecord car : raceResult.getResult()) {
            System.out.print(car.getName());
            System.out.print(" : ");
            System.out.print(FORWARD_STRING.repeat(car.getPosition()));
            System.out.println();
        }
        System.out.println();
    }
}
