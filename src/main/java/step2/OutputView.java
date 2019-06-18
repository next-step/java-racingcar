package step2;

import java.util.List;

public class OutputView {
    private static final String POSITION_OF_CAR = "-";

    public OutputView(List<Car> cars) {
        for(Car car : cars) {
            printCars(car);
        }
        System.out.println();
    }

    private void printCars(Car car) {
        for(int i=0;  i<car.getPosition(); i++) {
            System.out.print(POSITION_OF_CAR);
        }
        System.out.println();
    }

}
