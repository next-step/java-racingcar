package racingcar;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.InputCars;
import racingcar.dto.ResultCars;
import racingcar.model.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Cars 일급 컬렉션 테스트")
public class CarsTest {

    @Test
    @DisplayName("ArrayList 생성시 null 값이 들어오면 NullPointerException 이 발생한다.")
    void arrayListNullTest() {
        ArrayList<Car> emptyCars = null;
        Assertions.assertThatThrownBy(() -> new ArrayList<>(emptyCars))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("Cars 생성시 null 값이 들어오면 NullPointerException 이 발생한다.")
    void nullCarsTest() {
        Assertions.assertThatThrownBy(() -> new Cars(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("Cars is null");
    }

    @Test
    @DisplayName("Cars 생성시 빈 리스트가 들어오면 IllegalArgumentException 이 발생한다.")
    void emptyCarsTest() {
        Assertions.assertThatThrownBy(() -> new Cars(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Cars is empty");
    }

    @Test
    @DisplayName("Cars를 play했을 때 결과(이름, 상태)를 잘 반환하는지 테스트")
    void playTest() {
        // given
        Cars cars = new Cars(Lists.newArrayList(new Car(CarName.from("test"))));

        // when
        Cars result = cars.play(new RandomMovingStrategy());

        // then
        assertThat(result.states().get(0).value())
                .isGreaterThanOrEqualTo(cars.states().get(0).value());
        assertThat(result.names().get(0))
                .isEqualTo(cars.names().get(0));
    }

    @Test
    @DisplayName("Cars중에서 state값이 가장 큰 자동차들이 우승자가 되는 findWinner 테스트")
    void findWinnerTest() {
        // given
        int count = 2;
        List<CarName> names = InputCars.fromCarsInfo("test,test1").value().names();
        List<Distance> states = Lists.newArrayList(new Distance(2), new Distance(3));

        // when
        ResultCars resultCars = ResultCars.of(count, names, states);
        List<CarName> winner = resultCars.value().findWinner();

        // then
        assertThat(winner.get(0)).isEqualTo(CarName.from("test1"));
    }
}
