package step3.view;

import step3.domain.Car;
import step3.domain.Cars;

public class OutputView {

    private static final String DISTANCE_CHARACTER = "-";

    public void printResult(Cars cars, int roundTime) {
        for(int i = 0; i < roundTime; i++) {
            printCarsDistance(i, cars);
        }
    }

    private void printCarsDistance(int round, Cars cars) {
        for(Car car : cars.getValue()) {
            int distance = car.getDistanceByRound(round);

            printDistance(distance);
        }
    }

    private void printDistance(int distance) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < distance; i++) {
            builder.append(DISTANCE_CHARACTER);
        }

        System.out.println(builder.toString());
    }
}
