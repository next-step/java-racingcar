package racingcar;

import java.util.List;

public class RacingGameView {

    private RacingGame racingGame;

    public RacingGameView(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void viewCarPositions() {
        List<Car> currentCars = this.racingGame.getCurrentCars();

        for (int i = 0; i < currentCars.size(); i++) {
            printCarPosition(currentCars.get(i));
            if (i == currentCars.size() - 1) {
                System.out.println();
            }
        }
    }

    public void viewWinners(List<Car> winners) {
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i != winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("가 최종 우승했습니다.");
    }

    private void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
