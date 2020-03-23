package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultView {

    public void printCarsPositions(List<Car> cars) {
        for (Car c : cars) {
            System.out.println(
                    Stream
                            .generate(() -> "-")
                            .limit(c.getPosition())
                            .collect(Collectors.joining())
            );
        }
        System.out.println();
    }

    public void printGameResult() {
        System.out.println("실행 결과");
    }
}
