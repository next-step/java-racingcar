package racingcar.step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final String SIGN = "-";
    private int startRound = 1;
    private int finalRound;
    private int totalCar;

    private List<Car> cars = new ArrayList<>();

    private RacingGame() { }

    public RacingGame(int finalRound, int totalCar) {
        this.finalRound = finalRound;
        this.totalCar = totalCar;
        for (int i = 1; i <= totalCar; i++) {
            cars.add(new Car(i));
        }
    }

    public boolean isEndGame() {
        return finalRound == startRound;
    }

    public void startRace() {
        printCars();
        moveCars();
        roundUp();
    }

    private void moveCars() {
        cars.forEach(Car::move);
    }

    private void printCars() {
        cars.forEach(car -> {
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < car.getPosition(); i++) {
                        builder.append(SIGN);
                    }
                    System.out.println(builder);
                });
        System.out.println();
    }

    private void roundUp() {
        startRound++;
    }

}
