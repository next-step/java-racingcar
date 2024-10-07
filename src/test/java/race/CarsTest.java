package race;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,car3"})
    void 자동차는_1대_이상_10대_이하로_제한한다(String input) {
        assertThatCode(() -> new Cars(input.split(","))).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7,8,9,10,11"})
    void 자동차는_1대_미만_10대_초과하여_설정할_수_없다(String input) {
        assertThatThrownBy(() -> new Cars(input.split(",")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 수는 1 ~ 10대 사이로 설정해야 합니다.");
    }

    @Test
    void 우승자_선발() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Cars cars = new Cars(car1, car2);

        car1.accelerate(10);

        List<Car> winners = cars.getWinners();
        assertThat(winners.get(0)).isEqualTo(car1);
    }

    @Test
    void 우승자는_한_명_이상일_수_있다() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Cars cars = new Cars(car1, car2);

        car1.accelerate(10);
        car2.accelerate(10);

        assertThat(cars.getWinners()).hasSize(2);
    }

    @Test
    void 자동차별_현재_위치를_구한다() {

        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Cars cars = new Cars(car1, car2);

        car1.accelerate(10);
        car1.accelerate(10);
        car2.accelerate(10);

        Map<String, Integer> positions = cars.getPositions();
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(positions).hasSize(2);
            softly.assertThat(positions.get("car1")).isEqualTo(2);
            softly.assertThat(positions.get("car2")).isEqualTo(1);
        });
    }
}