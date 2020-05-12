package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Car;

public class OutputView {

    public void printStart() {
        System.out.println("\n실행 결과");
    }


    public void printRound(List<Car> cars) {
        cars.stream().forEach(car -> {
            StringBuilder builder = new StringBuilder();
            builder.append(car.getName());
            builder.append(" : ");

            int position = car.getPosition();
            for (int i = 0; i < position; i++) {
                    builder.append('-');
            }

            System.out.println(builder.toString());
        });

        System.out.println();
    }

    public void printEnd(List<Car> winners) {
         String carNames = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
         System.out.println(String.format("%s가 최종 우승했습니다.", carNames));
    }

}
