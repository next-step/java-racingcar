package racing.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.FixedRandomForwardStrategy;
import racing.domain.move.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    @DisplayName("자동차 생성")
    void create() {
        MoveStrategy moveStrategy = new FixedRandomForwardStrategy(5);
        String name = "test";
        RacingCar actual = new RacingCar(name, moveStrategy);
        assertThat(actual).isNotNull();
    }

    @Test
    @DisplayName("자동차 이름이 5자 이하인지 확인 (정상)")
    void nameOk() {
        MoveStrategy moveStrategy = new FixedRandomForwardStrategy(5);
        String name = "test";
        RacingCar car = new RacingCar(name, moveStrategy);
        assertThat(car.name()).isEqualTo(new Name("test"));
    }

    @Test
    @DisplayName("자동차 이름이 5자 이하인지 확인 (예외)")
    void nameNot() {
        MoveStrategy moveStrategy = new FixedRandomForwardStrategy(5);
        String name = "test123";
        assertThatThrownBy(() -> new RacingCar(name, moveStrategy))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @ParameterizedTest(name = "{displayName} - 값: {0}")
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName(("자동차 전진 테스트 (전진X)"))
    void ongoingNot(int randomValue) {
        MoveStrategy moveStrategy = new FixedRandomForwardStrategy(randomValue);
        String name = "test";
        RacingCar car = new RacingCar(name, moveStrategy);
        car.move();

        Position actual = car.position();
        assertThat(actual).isEqualTo(new Position(0));
    }

    @ParameterizedTest(name = "{displayName} - 값: {0}")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName(("자동차 전진 테스트 (전진O)"))
    void ongoingOk(int randomValue) {
        MoveStrategy moveStrategy = new FixedRandomForwardStrategy(randomValue);
        String name = "test";
        RacingCar car = new RacingCar(name, moveStrategy);
        car.move();

        Position actual = car.position();
        assertThat(actual).isEqualTo(new Position(1));
    }
}

