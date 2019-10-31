package step1.racing.view;

import java.util.List;

import step1.racing.data.RacingCar;

public class CarPositionViewer {
    public static void rendering(List<RacingCar> carPositions, String flag) {
        carPositions.forEach(car -> System.out.println(car.printStatus(flag)));
    }
}
