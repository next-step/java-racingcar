import CarRacing.Racing;
import CarRacing.view.ResultView;
import CarRacing.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCarRacingResultView {

    @Test
    @DisplayName("Distance 출력 정상인지 확인")
    public void printCurrentDistance() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.get(0).move(5);

        System.out.println("== expected > pobi : ------");
        System.out.print(  "== actual   > ");
        ResultView.printCurrentDistance(cars);
    }

    @Test
    @DisplayName("Winner 여러 명 출력 확인")
    public void printWinners_manyWinners() {
        List<String> winners = new ArrayList<>();
        winners.add("pobi");
        winners.add("crong");
        winners.add("honux");

        System.out.println("== expected > pobi, crong, honux가 최종 우승했습니다.");
        System.out.print(  "== actual   > ");
        ResultView.printWinners(winners);
    }
}
