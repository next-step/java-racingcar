package racinggame.ui;

import racinggame.domain.Car;
import racinggame.domain.RacingResult;

import java.util.List;

public class OutputView {

    public static final String OUTPUT_CAR_COLON = " : ";
    public static final String OUTPUT_CAR_POSITION = "-";

    public void printRacing(RacingResult racingResult) {
        System.out.println();
        System.out.println("실행 결과");
        racingResult.getRacingResults().forEach((step, cars) -> {
            printCars(cars);
        });
    }

    private void printCars(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        cars.forEach(car -> printCarPosition(car, sb));
        System.out.println();
    }

    private void printCarPosition(Car car, StringBuilder sb) {
        sb.append(car.getCarName() + OUTPUT_CAR_COLON);
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(OUTPUT_CAR_POSITION);
        }
        System.out.println(sb);
        sb.setLength(0);
    }

}
