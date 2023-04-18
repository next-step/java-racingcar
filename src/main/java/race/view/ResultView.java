package race.view;

import race.Car;
import race.Cars;

public class ResultView {
    private static final char POSITION_CHARACTER = '-';

    public static void showResultComment() {
        System.out.println("실행 결과");
    }

    public static void showCars(Cars cars) {
        for (Car car : cars.getCarList()) {
            showCar(car);
        }
        System.out.println();
    }

    private static void showCar(Car car) {
        StringBuilder stringBuilder = new StringBuilder()
                .append(car.getCarName().get())
                .append(" : ");
        System.out.print(stringBuilder);
        for (int i = 0; i < car.getPosition().get(); i++) {
            System.out.print(POSITION_CHARACTER);
        }
        System.out.println();
    }
}
