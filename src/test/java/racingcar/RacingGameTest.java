package racingcar;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private Car car;

    @Before
    public void setup() {
        car = new Car("kt");
    }
    @Test
    public void 전진() {
        assertThat(car.move(5)).isEqualTo(1);
    }
    @Test
    public void 정지() {
        assertThat(car.move(3)).isEqualTo(0);
    }
    @Test
    public void 우승자찾기() {
        Car car = new Car("kitae");
        car.move(5);
        assertThat(car.findWinner(1)).isEqualTo("kitae");
    }
    @Test
    public void 숫자비교() {
        Car car = new Car("kitae");
        car.move(5);
        assertThat(car.compareNum(2)).isEqualTo(2);
    }
    @Test
    public void 승자숫자() {
        List<Car> lists = new ArrayList<>();

        Car car1 = new Car("pobi");
        car1.move(5);
        lists.add(car1);

        Car car2 = new Car("kitae");
        car2.move(4);
        lists.add(car2);

        assertThat(WinnerNum.getWinnerNum(lists)).isEqualTo(1);
    }
}