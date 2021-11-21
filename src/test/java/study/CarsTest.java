package study;

import com.step3.model.car.Car;
import com.step3.model.car.Cars;
import com.step3.model.car.Name;
import com.step3.model.car.Position;
import com.step3.model.car.strategy.CarMoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @Test
    @DisplayName("차 List를 이용한 생성자 Test")
    void createFromList() {
        List<Car> cars = new ArrayList() {{
            add(new Car(new Name("test1"), new Position(0), new CarMoveStrategy()));
        }};

        assertThat(Cars.createFromList(cars))
                .isEqualTo(Cars.createFromList(new ArrayList() {{
                    add(new Car(new Name("test1"), new Position(0), new CarMoveStrategy()));
                }}));
    }

    @Test
    @DisplayName("차 이름을 이용한 생성자 Test")
    void createFromName() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new Name("test1"), new Position(0), new CarMoveStrategy()));
        cars.add(new Car(new Name("test2"), new Position(0), new CarMoveStrategy()));
        cars.add(new Car(new Name("test3"), new Position(0), new CarMoveStrategy()));

        assertThat(Cars.createFromName(new String[]{"test1", "test2", "test3"}, new CarMoveStrategy()))
                .isEqualTo(Cars.createFromList(cars));
    }

    @Test
    @DisplayName("cars의 이동거리 비교 후 우승자 결과 test")
    void getBestCars() {
        Cars cars = Cars.createFromName("pobi,crong,honux".split(","), new CarMoveStrategy());
        cars.getList().get(0).move(true);   // pobi 이동
        cars.getList().get(1).move(true);   // crong 이동
        assertThat(cars.getWinnerCars().getList()
                .stream()
                .map(c -> c.getName().get())
                .collect(Collectors.joining(","))
        ).isEqualTo("pobi,crong");
    }


    @Test
    @DisplayName("자동차 이름 5자 이상 예외처리 test")
    void validateCarName() {
        assertThatThrownBy(() -> Cars.createFromName("pobipobi,crong,honux".split(","), new CarMoveStrategy()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 5자 이하 필수");
    }
}
