package car.ui;

import car.dto.CarStatus;
import java.util.List;

public class CarStatusPrinter {

    public static void print(List<CarStatus> carStatuses) {
        for (CarStatus carStatus : carStatuses) {
            System.out.println(carStatus.getName() + " : " + "-".repeat(carStatus.getPosition()));
        }
        System.out.println();
    }

}
