package racingcar;

import java.util.List;

public class ResultView {
    private final Screen screen = new Screen();

    public void start() {
        screen.print("\n실행 결과");
    }

    public void score(List<Car> carList) {
        carList.forEach(car -> {
            String driven = convert(car.distanceDriven());
            screen.print(car.name() + " : " + driven);
        });
        screen.print("");
    }

    public void winner(String winnerNames) {
        screen.print(winnerNames + "가 최종 우승했습니다.");
    }

    private String convert(int distanceDriven) {
        return "-".repeat(Math.max(0, distanceDriven));
    }

}
