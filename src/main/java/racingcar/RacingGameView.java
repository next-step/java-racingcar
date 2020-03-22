package racingcar;

import java.util.ArrayList;

public class RacingGameView {

    private RacingGame racingGame;

    public RacingGameView(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void viewCarPositions() {
        ArrayList<Car> currentCars = this.racingGame.getCurrentCars();

        for (int i = 0; i < currentCars.size(); i++) {
            printCarPosition(currentCars.get(i));
            if (i == currentCars.size() - 1) {
                System.out.println();
            }
        }
    }

    private void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
