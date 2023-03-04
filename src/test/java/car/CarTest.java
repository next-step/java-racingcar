package car;

import car.utils.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {

    List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("씽씽카", 3));
        cars.add(new Car("쏘카", 1));
        cars.add(new Car("그린카", 5));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun"})
    void 자동차_이름은_쉼표구분자로_구분한다(String carName) {
        //when
        String[] carNames = carName.split(",");

        //then
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,woni,jun:5"}, delimiter = ':')
    void 자동차_이름과_이동횟수를_입력한다(String carName, int moveCount) {
        String[] carNames = carName.split(",");
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
        assertThat(moveCount).isEqualTo(5);
    }

    @ParameterizedTest
    @CsvSource(value = {"씽씽카,현대자동차"}, delimiter = ',')
    void 이름을_기진_자동차_객체를_생성한다(String successCase, String failCase) {
        Car car = new Car(successCase);
        assertThatThrownBy(() -> new Car(failCase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 미만만 가능 합니다. name = " + failCase);
    }

    @Test
    void 전진하는_자동차의_이름을_같이_출력한다() {
        cars.forEach(car -> {
            int randomValue = RandomUtils.generateRandomValue();
            car.move(randomValue);
        });
    }

    @Test
    void 자동차의_상태를_출력한다() {
        cars.forEach(Car::printPositionStatus);
    }
}
