package racinggame.ui;

import racinggame.domain.Car;
import racinggame.domain.Name;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String OUTPUT_CAR_COLON = " : ";
    public static final String OUTPUT_CAR_POSITION = "-";
    public static final String OUTPUT_CAR_COMMA = ", ";

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

    public void printWinners(List<Name> winnersName) {
        String result = winnersName.stream()
                .map(Name::toString)
                .collect(Collectors.joining(OUTPUT_CAR_COMMA));

        if (!result.isEmpty()) {
            System.out.print(result + "가 최종 우승했습니다.");
        }
    }

}
