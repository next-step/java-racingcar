package study;

import com.step3.model.car.Car;
import com.step3.model.car.Cars;
import com.step3.model.car.Name;
import com.step3.model.car.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    @DisplayName("차 List를 이용한 생성자 Test")
    void createFromList() {
        List<Car> cars = new ArrayList() {{
            add(new Car(new Name("test1"), new Position(0)));
        }};

        Cars fromList = Cars.createFromList(cars);

        assertThat(fromList.getList()).containsExactly(new Car(new Name("test1"), new Position(0)));
    }

    @Test
    @DisplayName("차 이름을 이용한 생성자 Test")
    void createFromName() {
        assertThat(Cars.createFromName(new String[]{"test1", "test2", "test3"}).getList())
                .containsExactly(
                        new Car(new Name("test1"), new Position(0)),
                        new Car(new Name("test2"), new Position(0)),
                        new Car(new Name("test3"), new Position(0))
                );
    }

    @Test
    void moveCars() {
        Cars cars = Cars.createFromName("pobi,crong,honux".split(","));

        assertThat(cars.moveCars(() -> true).getList())
                .isEqualTo(new ArrayList() {{
                    new Car(new Name("pobi"), new Position(1));
                    new Car(new Name("crong"), new Position(1));
                    new Car(new Name("honux"), new Position(1));
                }});
    }

    @Test
    @DisplayName("cars의 이동거리 비교 후 우승자 결과 test")
    void getWinnerCars() {
        Cars cars = Cars.createFromName("pobi,crong,honux".split(","));
        cars.getList().get(0).move(() -> true);   // pobi 이동
        cars.getList().get(1).move(() -> true);   // crong 이동

        assertThat(cars.getWinnerCars().getList())
                .extracting(it -> it.getName())
                .containsExactly(new Name("pobi"), new Name("crong"));
    }
}
