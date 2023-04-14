import CarRacing.*;
import CarRacing.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCarRacing {
    @Test
    @DisplayName("4보다 적은 수 입력 시 차량 이동 없음")
    public void drive_less_4() {
        int actual = Racing.drive(3);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    @DisplayName("4보다 큰 수 입력 시 차량 이동")
    public void drive_more_4() {
        int actual = Racing.drive(5);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("4 입력 시 차량 이동")
    public void drive_equal_4() {
        int actual = Racing.drive(4);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("Winner 여러 명 출력 확인")
    public void getWinners_manyWinners() {
        List<Car> cars = new ArrayList<>();
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

        List<String> expected = new ArrayList<>();
        expected.add("aaa");
        expected.add("ddd");
        expected.add("eee");

        List<String> actual = Racing.getWinners(cars);
        assertThat(actual).isEqualTo(expected);
    }

}
