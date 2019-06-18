package RacingGame;

import java.util.List;

public class OutputView {

    public void printRace(List<Car> cars) {
        for (Car car : cars) {
            printPosition(car.getName(), car.getPosition());
        }
        System.out.println();
    }

    private void printPosition(String carName, int position) {
        System.out.print(carName + "\t: ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
