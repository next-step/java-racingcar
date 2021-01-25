package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.IntStream;

public class ConsoleOutput implements Output {
    @Override
    public void println(final String outputMessage) {
        System.out.println(outputMessage);
    }

    @Override
    public void printMidResult(final List<Car> cars) {
        cars.forEach(car -> {
            System.out.print(car.getName() + " : ");
            IntStream.range(0, car.getLocation())
                    .mapToObj(i -> "-")
                    .forEach(System.out::print);
            System.out.println();
        });
        System.out.println();
    }

    @Override
    public void printWinners(final List<String> winners) {
        System.out.println("최종 우승자: " + String.join(", ", winners));
    }

    @Override
    public void startPrintingGameResult() {
        System.out.println();
        System.out.println("실행 결과");
    }
}
