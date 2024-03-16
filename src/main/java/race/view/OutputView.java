package race.view;

import race.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String UNIT_MILEAGE = "-";
    private static final String COLON = " : ";
    private static final String REST = ", ";

    public void printMileages(List<Car> racingCars) {
        for (Car racingCar : racingCars) {
            if (racingCar.getPosition() == 0) {
                System.out.print(racingCar.getName() + COLON);
                System.out.println(UNIT_MILEAGE);
                continue;
            }
            System.out.print(racingCar.getName() + COLON);
            System.out.println(UNIT_MILEAGE.repeat(racingCar.getPosition()));
        }
    }

    public void printWinner(List<Car> winner) {
        String winners = winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(REST));
        System.out.println(winners + "가 최종 우승했습니다.");
    }

    public void printResultStatement() {
        printNewLine();
        System.out.println("실행 결과");
    }

    public void printNewLine() {
        System.out.println("\n");
    }
}
