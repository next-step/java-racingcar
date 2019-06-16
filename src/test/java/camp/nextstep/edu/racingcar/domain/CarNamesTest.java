package camp.nextstep.edu.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarNamesTest {

    @DisplayName("객체 생성이 잘 되는지")
    @Test
    void constructor() {
        // given
        final List<String> carNameList = Arrays.asList("pobi", "crong", "honux");
        // when
        final CarNames carNames = CarNames.from(carNameList);
        // then
        assertThat(carNames).isNotNull();
        assertThat(carNames.size()).isEqualTo(3);
        assertThat(carNames.stream().anyMatch(name -> name.equals("pobi"))).isTrue();
        assertThat(carNames.stream().anyMatch(name -> name.equals("crong"))).isTrue();
        assertThat(carNames.stream().anyMatch(name -> name.equals("honux"))).isTrue();
    }

    @DisplayName("carNameList 가 null 이면, 객체가 생성되지 않아야함")
    @Test
    void constructorThrowsIllegalArgumentExceptionWhenCarNameListIsNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarNames.from(null))
                .withMessageContaining("must not be null");
    }

    @DisplayName("개수를 잘 돌려주는지")
    @Test
    void size() {
        // given
        final List<String> carNameList = Arrays.asList("pobi", "crong", "honux");
        final CarNames carNames = CarNames.from(carNameList);
        // when
        final int size = carNames.size();
        // then
        assertThat(size).isEqualTo(3);
    }
}