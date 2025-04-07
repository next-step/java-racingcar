import domain.Car;
import domain.Cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeEach
    void setUp() {
        car1 = new Car("ohgyu");
        car2 = new Car("kwon");
        car3 = new Car("sewon");

        // 각 자동차의 position 조작 (예: '-' 하나당 1칸 이동한 것으로 가정)
        car1.move(); // position: "-"
        car1.move(); // position: "--"

        car2.move(); // position: "-"

        car3.move(); // position: "-"
        car3.move(); // position: "--"
        car3.move(); // position: "---"
    }

    @Test
    void 가장_멀리_간_자동차_이름_반환() {
        Cars cars = new Cars(List.of(car1, car2, car3));

        List<String> winners = cars.getWinners();

        assertThat(winners).containsExactly("sewon");
    }

    @Test
    void 동일한_위치에_있는_자동차가_여러명이면_모두_우승자() {
        car1.move(); // position: "---"

        Cars cars = new Cars(List.of(car1, car2, car3));

        List<String> winners = cars.getWinners();

        assertThat(winners).containsExactlyInAnyOrder("ohgyu", "sewon");
    }

    @Test
    void 자동차_목록이_비어있을_경우_우승자는_없음() {
        Cars cars = new Cars(List.of());

        List<String> winners = cars.getWinners();

        assertThat(winners).isEmpty();
    }
}