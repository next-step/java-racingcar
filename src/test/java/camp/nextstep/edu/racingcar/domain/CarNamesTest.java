package camp.nextstep.edu.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarNamesTest implements CarNamesHelper {

    @DisplayName("객체 생성이 잘 되는지")
    @Test
    void constructor() {
        // given
        final List<CarName> carNameList = Arrays.asList(
                CAR_NAME_FIRST,
                CAR_NAME_SECOND,
                CAR_NAME_THIRD
        );
        // when
        final CarNames carNames = CarNames.from(carNameList);
        // then
        assertThat(carNames).isNotNull();
        assertThat(carNames).hasSize(3);
        assertThat(carNames).containsExactly(
                CAR_NAME_FIRST,
                CAR_NAME_SECOND,
                CAR_NAME_THIRD
        );
    }

    @DisplayName("carNameList 가 null 이면, 객체가 생성되지 않아야함")
    @Test
    void constructorThrowsIllegalArgumentExceptionWhenCarNameListIsNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarNames.from(null))
                .withMessageContaining("must not be null");
    }
}