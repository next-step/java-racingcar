package race;

import java.util.List;

public class ResultView {

    public void printCurrentRoundProgress(List<Car> cars) {
        cars.forEach(car -> {
            System.out.println(car.getId() + "\t: " + "=".repeat(car.getPosition()));
        });

        System.out.println();
    }
}
