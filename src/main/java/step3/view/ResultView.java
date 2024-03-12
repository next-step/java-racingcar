package step3.view;

import step3.Car;
import step3.dto.CarStatusDto;

import java.util.List;

public class ResultView {

    public static void displayCurrentCarsLocation(List<CarStatusDto> cars) {
        for (CarStatusDto carStatus : cars) {
            displayCarLocation(carStatus);
        }
        System.out.println();
    }

    private static void displayCarLocation(CarStatusDto carStatus) {
        System.out.print(carStatus.getName()+" : ");
        for (int i = 0; i < carStatus.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
