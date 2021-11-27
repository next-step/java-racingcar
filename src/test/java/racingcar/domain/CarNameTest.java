package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    @DisplayName("name 초기값으로 CarName 객체를 생성한다. 이름은 1~5자")
    @ParameterizedTest
    @ValueSource(strings = {"joy", "happy", "love"})
    public void create(String name) {
        // when
        CarName carName = new CarName(name);

        // then
        assertThat(carName.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름이 blank 이거나 5자를 초과한 경우 exception을 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"happyNow", "loveYourself"})
    public void nameArgumentException(String name) {
        assertThatThrownBy(() ->
                new CarName(name)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("name length must be between 1 and 5");
    }
}
