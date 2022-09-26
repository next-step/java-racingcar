package game.view;

import game.model.Car;
import game.model.Cars;

public class OutputView {
    private static final String OUTPUT_SYMBOL = "-";


    private OutputView() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void print(Cars cars) {
        for (Car car : cars.getCarList()) {
            System.out.println(getStringForOutput(car.getPosition()));
        }
        System.out.println();
    }

    private static String getStringForOutput(int num) {
        return OUTPUT_SYMBOL.repeat(num);
    }

}
