package refactoringracingcar.view;

import refactoringracingcar.domain.Car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static refactoringracingcar.domain.RacingCarGame.cars;

public class ResultView {

    public String printGameStatus() {
        String carDistanceStatus = "";
        for (int i = 0; i < cars.size(); i++) {
            carDistanceStatus += cars.get(i).getCarName() + " : " + printStatusBar(i) + "\n";
        }
        carDistanceStatus += "\n";
        return carDistanceStatus;
    }

    private String printStatusBar(int participantTurn) {
        int moveDistance = cars.get(participantTurn).getCarPosition();
        String carStatus = "";
        for (int i = 0; i < moveDistance; i++) {
            carStatus += "-";
        }
        return carStatus;
    }

    public String printWinner() {
        String winnerResult = "";
        List<Car> winnerCars = determineWinner();
        for (Car winnerCarName : winnerCars) {
            winnerResult += ", " + winnerCarName.getCarName();
        }
        return winnerResult.substring(2) + "가 최종 우승했습니다.";
    }

    private List<Car> determineWinner() {
        Car winner = cars.stream().max(Comparator.comparing(Car::getCarPosition)).get();
        List<Car> winnerCars = cars.stream()
                .filter(car -> car.getCarPosition() == winner.getCarPosition())
                .collect(Collectors.toList());

        return winnerCars;
    }
}
