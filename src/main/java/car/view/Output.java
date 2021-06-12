package car.view;

import car.domain.Car;
import car.domain.RaceResult;
import car.domain.RaceResults;

import java.util.List;

public class Output {
    private final RaceResults raceResults;

    public Output(RaceResults raceResults) {
        this.raceResults = raceResults;
    }

    public String printLines(Car car) {
        StringBuilder lines = new StringBuilder();
        int km = car.getKm();

        for (int i = 0; i < km; i++) {
            lines.append("-");
        }
        return lines.toString();
    }

    public void printCars(RaceResult raceResult) {
        List<Car> cars = raceResult.getCars();

        for (Car car : cars) {
            System.out.println(car.getName() + " : " + printLines(car));
        }
        System.out.println("");
    }

    public void printWinner() {
        StringBuilder winners = raceResults.getWinners();

        System.out.println("최종 우승자: " + winners.substring(0, winners.length() - 2));
    }

    public void printRaceResult() {
        System.out.println("실행 결과");

        for (RaceResult raceResult : raceResults.getRaceResults()) {
            printCars(raceResult);
        }

        printWinner();
    }
}
