package racingcar.model.wrapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.CarNameException;

import java.util.List;

import static racingcar.model.fixture.CarFixture.carName;
import static racingcar.model.fixture.CarsFixture.*;

public class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void 자동차_이름을_생성한다(String name) {
        Assertions.assertThatNoException().isThrownBy(() -> {
            CarName carName = new CarName(name);
        });
    }

    @Test
    void 동등_비교() {
        // given
        String name = "name";
        // when
        CarName actual = new CarName(name);
        // then
        Assertions.assertThat(actual).isEqualTo(carName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobiii", "crongg", "honuxx", "123456"})
    void 자동차_이름은_5자를_초과할_수_없다(String name) {
        Assertions.assertThatThrownBy(() -> {
            CarName carName = new CarName(name);
        }).isInstanceOf(CarNameException.class).hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 자동차_이름이_빈값일수_없다(String name) {
        Assertions.assertThatThrownBy(() -> {
            CarName carName = new CarName(name);
        }).isInstanceOf(CarNameException.class).hasMessage("자동차 이름은 빈값일 수 없습니다.");
    }

    @Test
    void 자동차_이름을_출력한다() {
        // given
        // when
        String actual = carName.name();
        // then
        Assertions.assertThat(actual).isEqualTo("name");
    }

    @Test
    void 입력받은_자동차_이름_문자열을_쉼표_기준으로_구분한다() {
        // given
        List<CarName> expected = List.of(carName1, carName2, carName3);

        // when
        List<CarName> actual = CarName.convertStringToCarNames(carNames);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
