package racingcar.view;

import racingcar.race.Car;
import racingcar.race.RacingCars;
import racingcar.race.RacingModel;

import java.util.List;

public class ResultView {

    private static int ONLY_ONE_WINNER = 1;
    private RacingCars racingCars;
    private RacingModel racingModel;

    public ResultView(RacingCars racingCars, RacingModel racingModel) {
        this.racingCars = racingCars;
        this.racingModel = racingModel;
    }

    public void printEachRacingStep() {
        for (Car racingCar : racingCars.getRacingCars()) {
            printCarPosition(racingCar);
        }
        System.out.println();
    }

    private void printCarPosition(Car racingCar) {
        System.out.print(racingCar.getName() + " : ");
        printCurrentPosition(racingCar);

        System.out.println();
    }

    private void printCurrentPosition(Car racingCar) {
        for (int current = 0; current < racingCar.getPosition(); current++) {
            System.out.print("-");
        }
    }

    public void printWinner(RacingCars cars) {
        int numberOfWinner = cars.getRacingCars().size();

        if (numberOfWinner == ONLY_ONE_WINNER) {
            System.out.print(cars.getRacingCars().get(0).getName() + "가 최종 우승했습니다.");
            return;
        }

        printMultipleWinner(cars, numberOfWinner);
    }

    private void printMultipleWinner(RacingCars cars, int numberOfWinner) {
        List<Car> racingCars = cars.getRacingCars();

        for (int winnerCount = 0; winnerCount < numberOfWinner - 1; winnerCount++) {
            Car winnerCar= racingCars.get(winnerCount);
            System.out.print(winnerCar.getName() + ", ");
        }
        printLastWinner(racingCars.get(numberOfWinner - 1));
    }

    private void printLastWinner(Car car) {
        System.out.println(car.getName() + "가 최종 우승했습니다.");
    }


}
