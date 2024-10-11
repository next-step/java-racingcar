package racingcar.view;

import racingcar.model.Car;
import racingcar.model.RaceWinner;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public ResultView() {
        System.out.println("실행 결과");
    }

    public void printRacingResult(List<Car> cars, int raceCount, int totalNumberOfRace) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + generateDashedString(car.getMovingDistance()));
        }

        System.out.println();

        if (raceCount == totalNumberOfRace) {
            printRaceWinner(cars);
        }
    }

    private String generateDashedString(int movingDistance) {
        return "-".repeat(movingDistance);
    }

    private void printRaceWinner(List<Car> cars) {
        RaceWinner winner = new RaceWinner(cars);
        String winnerNames = winnerListToString(winner.getWinnerList());

        System.out.println(winnerNames);
    }

    private String winnerListToString(List<Car> winnerList) {
        List<String> nameList = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        String names = String.join(", ", nameList);
        names += "가 최종 우승했습니다.";

        return names;
    }
}
