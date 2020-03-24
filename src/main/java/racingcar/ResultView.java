package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultView {

    public void printGameResult() {
        print("실행 결과");
    }

    private void print(String result) {
        System.out.println(result);
    }

    public void renderCarMovement(List<Car> cars) {
        for (Car c : cars) {
            print(Stream
                    .generate(() -> "-")
                    .limit(c.getPosition())
                    .collect(Collectors.joining()));
        }
        print("");
    }
}
