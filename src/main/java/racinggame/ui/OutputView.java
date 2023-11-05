package racinggame.ui;

import racinggame.domain.Car;

import java.util.List;

public class OutputView {

    public static final String OUTPUT_CAR_COLON = " : ";
    public static final String OUTPUT_CAR_POSITION = "-";

    public void printRacing(List<Car> cars) {
        System.out.println("실행 결과");
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
