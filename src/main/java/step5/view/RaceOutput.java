package step5.view;

import step5.domain.Car;
import step5.domain.Cars;

public class RaceOutput {

    private static final String INDICATOR = "-";

    private static final String SEPARATOR = ", ";

    public RaceOutput() {
        System.out.println("실행 결과");
    }

    public void printRoundResult(Cars cars) {
        for (Car car : cars) {
            System.out.println(car.name() + " : " + INDICATOR.repeat(car.location()));
        }
        System.out.println();
    }

    public void printWinners(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars.getWinners()) {
            stringBuilder.append(car.name()).append(SEPARATOR);
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(SEPARATOR));
        System.out.print(stringBuilder);
        System.out.println("(이)가 최종 우승했습니다.");
    }
}
