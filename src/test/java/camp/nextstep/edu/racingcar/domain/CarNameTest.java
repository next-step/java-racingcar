package camp.nextstep.edu.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarNameTest {
    @DisplayName("객체가 잘 생성되는지")
    @Test
    void constructor() {
        // given
        final String name = "name";
        // when
        final CarName carName = CarName.from(name);
        // then
        assertThat(carName).isNotNull();
        assertThat(carName.value()).isEqualTo("name");
    }

    @DisplayName("빈 문자열로 CarName 을 생성하려하면, IllegalArgumentException 이 발생해야함")
    @Test
    void constructorShouldThrowsIllegalArgumentExceptionWhenGivenNameIsEmpty() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarName.from(""))
                .withMessageContaining("must not be null or empty");
    }

    @DisplayName("null 로 CarName 을 생성하려하면, IllegalArgumentException 이 발생해야함")
    @Test
    void constructorShouldThrowsIllegalArgumentExceptionWhenGivenNameIsNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarName.from(null))
                .withMessageContaining("must not be null or empty");
    }
}

