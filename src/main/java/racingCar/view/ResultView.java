package racingCar.view;

import racingCar.model.RacingCar;

import java.util.List;

public class ResultView {

    public void printResultTitle() {
        System.out.println("실행 결과");
    }

    private void printCarDistance(RacingCar racingCar) {

        int carDistance = racingCar.distance();

        for (int distance = 0; distance < carDistance; distance++) {
            System.out.print("-");
        }

        System.out.println();
    }

    public void printCarsDistance(List<RacingCar> racingCars) {

        for (int carIndex = 0; carIndex < racingCars.size(); carIndex++) {
            printCarDistance(racingCars.get(carIndex));
        }

        System.out.println();
    }
}
