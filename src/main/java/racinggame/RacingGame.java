package racinggame;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public static void main(String[] args) {
        int carCount = InputView.getCarCount();
        int rounds = InputView.getRounds();

        List<Car> carList = createCars(carCount);
        Race race = new Race(carList);
        OutputView.printRace(race, rounds);
    }

    private static List<Car> createCars(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return carList;
    }
}
