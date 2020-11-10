package car.racing.view;

import car.racing.domain.Car;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView implements ResultViewContract {

    private static final String FORWARD = "-";
    private static final String SEPARATOR = " : ";
    private static final String DELIMITER = ",";

    @Override
    public void resultTitle() {
        System.out.println("\n실행 결과");
    }

    @Override
    public void newLine() {
        System.out.println();
    }

    @Override
    public void forward(Car car) {
        System.out.print(car.getName() + SEPARATOR);
        IntStream.range(0, car.getForwardCount())
                .forEach(i -> System.out.print(FORWARD));
        System.out.println();
    }

    @Override
    public void winners(List<String> racingWinners) {
        System.out.print(String.join(DELIMITER, racingWinners));
        System.out.println("가 최종 우승했습니다.");
    }
}