package racing.views;

import racing.domain.Car;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

public class ResultView {

    private final PrintStream out;

    public ResultView() {
        out = System.out;
    }

    public void showStartRace(List<Car> cars){
        out.println("실행 결과");
        showRaceRound(cars);
    }

    public void showRaceRound(List<Car> cars) {
        cars.forEach(car ->
                out.println(car.getName() + " : " + toAdvanceProgress(car.getNumberOfAdvance())));
        out.println();
    }

    public String toAdvanceProgress(int numberOfAdvance) {
        return Stream.generate(()-> "-")
                .limit(numberOfAdvance)
                .reduce("-", (a, b) -> a + b);
    }

    public void showWinners(List<String> winnerNames) {
        out.println(String.join(",", winnerNames) + "가 최종 우승했습니다.");
    }
}
