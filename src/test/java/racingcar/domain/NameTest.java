package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Name;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @Test
    @DisplayName("입력한 이름을 반환한다")
    void should_return_name(){
        //Given
        String carName = "damas";

        //When
        Name name = new Name(carName);

        //Then
        assertThat(name.getValue()).isEqualTo(carName);
    }

    @Test
    @DisplayName("입력한 이름이 아니면 반환하지 않는다")
    void should_not_return_name(){
        //Given
        String carName = "damas";

        //When
        Name name = new Name(carName);

        //Then
        assertThat(name.getValue()).isNotEqualTo("bmw");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("입력된 이름이 빈 공백이면 IllegalArgumentException 던진다.")
    void should_throw_IllegalArgumentException_when_name_is_less_than_0_characters(String carName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(carName))
                .withMessage("the name must not blank.");
    }

    @ParameterizedTest
    @ValueSource(strings = "nameIsTooLong")
    @DisplayName("입력된 이름이 5글자 이상이면 IllegalArgumentException 던진다.")
    void should_throw_IllegalArgumentException_when_name_is_more_than_5_characters(String carName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(carName))
                .withMessage("the name must be less than five characters.");
    }
}