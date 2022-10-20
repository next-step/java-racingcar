package refactoringracingcar.view;

import refactoringracingcar.domain.Car;
import refactoringracingcar.domain.RacingCarGame;

import java.util.List;

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
        RacingCarGame racingCarGame = new RacingCarGame(cars);
        List<Car> winnerCars = racingCarGame.determineWinner();
        for (Car winnerCarName : winnerCars) {
            winnerResult += ", " + winnerCarName.getCarName();
        }
        System.out.println(winnerResult.substring(2) + "가 최종 우승했습니다.");
    }

}
