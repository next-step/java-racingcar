package racinggame.ui;

import racinggame.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String OUTPUT_CAR_POSITION = "-";
    public static final String OUTPUT_CAR_COMMA = ", ";

    public void printRacing(List<Car> cars) {
        System.out.println("실행 결과");
        StringBuilder sb = new StringBuilder();
        cars.forEach(car -> printCarPosition(car, sb));
        System.out.println();
    }

    private void printCarPosition(Car car, StringBuilder sb) {
        sb.append(car);
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(OUTPUT_CAR_POSITION);
        }
        System.out.println(sb);
        sb.setLength(0);
    }

    public void printWinners(List<Car> cars) {
        String result = cars.stream()
                .map(car -> car.getCarName().toString())
                .collect(Collectors.joining(OUTPUT_CAR_COMMA));

        if (!result.isEmpty()) {
            System.out.print(result + "가 최종 우승했습니다.");
        }
    }

}
