import CarRacing.view.ResultView;
import CarRacing.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestCarRacingResultView {

    ResultView resultView;

    @BeforeEach
    public void setUp() {
        resultView = new ResultView();
    }

    @Test
    @DisplayName("Distance 출력 정상인지 확인")
    public void printCurrentDistance() {
        List<Car> cars = new ArrayList<>(1);
        cars.add(new Car("pobi"));
        cars.get(0).move(5);

        System.out.println("== expected > pobi : ------");
        System.out.print(  "== actual   > ");
        ResultView.printCurrentDistance(cars);
    }

    @Test
    @DisplayName("Winner 여러 명 출력 확인")
    public void getWinners_manyWinners() {
        List<Car> cars = new ArrayList<>(4);
        cars.add(new Car("aaa"));
        cars.add(new Car("bbb"));
        cars.add(new Car("ccc"));
        cars.add(new Car("ddd"));
        cars.add(new Car("eee"));

        cars.get(0).move(5);
        cars.get(1).move(1);
        cars.get(2).move(4);
        cars.get(3).move(5);
        cars.get(4).move(5);

        System.out.println("== expected > aaa, ddd, eee가 최종 우승했습니다.");
        System.out.print(  "== actual   > ");
        ResultView.getWinners(cars);
    }
}
