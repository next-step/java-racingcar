package racing.view;

import racing.Car;

import java.util.List;

public abstract class Result {

    private Result() {
    }

    public static void positionPrint(final List<Car> list) {

        for (Car car : list) {
            final int position = car.getPosition();
            positionCalculator(position);
        }

        System.out.println();
    }

    private static void positionCalculator(final int position) {

        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < position; i++) {
            sb.append("-");
        }

        sb.append("\n");

        System.out.print(sb.toString());
    }

}
