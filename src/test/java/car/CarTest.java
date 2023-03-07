package car;

import car.domain.Car;
import car.domain.Cars;
import car.domain.Name;
import car.domain.Position;
import car.ui.View;
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

    private Cars cars;

    @BeforeEach
    void setUp() {
        List<Car> participants = new ArrayList<>();
        participants.add(new Car(new Name("씽씽카"), new Position(3)));
        participants.add(new Car(new Name("쏘카"), new Position(1)));
        participants.add(new Car(new Name("그린카"), new Position(5)));
        cars = Cars.of(participants);
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
    void 자동차_객체_생성_시_이름_길이를_검증한다(String successCase, String failCase) {
        Name name = new Name(successCase);
        assertThatThrownBy(() -> new Name(failCase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 미만만 가능 합니다. name = " + failCase);
    }

    @Test
    void 자동차의_위치상태를_출력한다() {
        // given
        Car car = new Car(new Name("씽씽카"), new Position(3));
        View view = View.from(car);
        String actual = view.printStatus();
        assertThat(actual).isEqualTo("씽씽카 : ---");
    }

    @Test
    void 자동차의_위치값을_조회한다() {
        //given
        Car car = new Car(new Name("쏘카"), new Position(5));

        //when
        int actual = car.findPosition();

        //then
        assertThat(actual).isEqualTo(5);
    }

    @Test
    void 자동차의_위치값이_최대_위치값_보다_커야한다() {
        //given
        Car car = new Car(new Name("쏘카"), new Position(5));
        int maxPosition = 4;

        //when
        boolean actual = car.isGreaterThan(maxPosition);

        //then
        assertThat(actual).isTrue();
    }

    @Test
    void 자동차의_위치값이_최대_위치값과_동일해야한다() {
        //given
        Car car = new Car(new Name("쏘카"), new Position(3));
        int maxPosition = 3;

        //when
        boolean actual = car.isEqualPosition(maxPosition);

        //then
        assertThat(actual).isTrue();
    }
}
