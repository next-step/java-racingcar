package refactoringracingcar.view;

import refactoringracingcar.domain.Car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private ResultView() {

    }

    public static void printGameStatus(List<Car> cars) {
        String carDistanceStatus = "";
        for (int i = 0; i < cars.size(); i++) {
            carDistanceStatus += cars.get(i).getCarName() + " : " + printStatusBar(i, cars) + "\n";
        }
        System.out.println(carDistanceStatus);
    }

    private static String printStatusBar(int participantTurn, List<Car> cars) {
        int moveDistance = cars.get(participantTurn).getCarPosition();
        String carStatus = "";
        for (int i = 0; i < moveDistance; i++) {
            carStatus += "-";
        }
        return carStatus;
    }

    public static void printWinner(List<Car> cars) {
        String winnerResult = "";
        List<Car> winnerCars = determineWinner(cars);
        for (Car winnerCarName : winnerCars) {
            winnerResult += ", " + winnerCarName.getCarName();
        }
        System.out.println(winnerResult.substring(2) + "가 최종 우승했습니다.");
    }

    private static List<Car> determineWinner(List<Car> cars) {
        Car winner = cars.stream().max(Comparator.comparing(Car::getCarPosition)).get();
        List<Car> winnerCars = cars.stream()
                .filter(car -> car.getCarPosition() == winner.getCarPosition())
                .collect(Collectors.toList());

        return winnerCars;
    }
}
