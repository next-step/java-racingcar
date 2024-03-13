package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;
import racing.util.FixedNumberGeneratorImpl;
import racing.view.InputView;
import racing.view.ResultView;

class RacingTest {

    @DisplayName("4이상이면 전진할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"4,1", "9,1", "3,0", "2,0"}, delimiter = ',')
    void 전진_가능(int input, int expect) {
        Car car = new Car(new FixedNumberGeneratorImpl(input), "pobi");
        car.run();
        assertThat(car.getRunCount()).isEqualTo(expect);
    }

    @DisplayName("자동차에 이름을 부여할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void car_이름(String name) {
        Car car = new Car(new FixedNumberGeneratorImpl(4), name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("자동차에 이름은 5자를 초과할 수 없다.")
    @Test
    void car_이름_max_len() {
        assertThatThrownBy(
            () -> new Car(new FixedNumberGeneratorImpl(4), "pobi_zzang")).isInstanceOf(
            IllegalArgumentException.class).hasMessageContaining("5자를 초과할 수 없습니다");
        ;
    }

    @DisplayName("이름 입력받을시 ,를 기준으로 구분한다.")
    @Test
    void car_이름_split() {
        assertThat(InputView.split("pobi,crong,honux")).hasSize(3);
    }

    @DisplayName("최종 우승자 출력")
    @Test
    void 최종_우승자_출력() {
        String[] names = "pobi,crong,honux".split(",");
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            Car car = new Car(new FixedNumberGeneratorImpl(i + 2), names[i]);
            car.run();
            cars.add(car);
        }

        assertThat(ResultView.getWinner(cars)).isEqualTo("honux");
    }
}