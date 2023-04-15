package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import static racingcar.domain.fixture.ConstantsFixture.CAR_NAME;
import static racingcar.domain.fixture.ConstantsFixture.WEIRD_CAR_NAME_1;
import static racingcar.domain.fixture.ConstantsFixture.WEIRD_CAR_NAME_2;

@DisplayName("자동자 이름 테스트")
class NameTest {

    @Test
    @DisplayName("자동차 이름 저장 테스트")
    void testName() {
        // Given & When
        Name name = new Name(CAR_NAME);

        final String names = name.getName();

        // Then
        assertThat(names).contains(CAR_NAME);
    }

    @Test
    @DisplayName("자동차 이름 예외 테스트")
    void testNameException() {
        // Then & When
        assertAll(
                () -> assertThatThrownBy(() -> new Name(WEIRD_CAR_NAME_1))
                        .isInstanceOf(IllegalArgumentException.class),

                () -> assertThatThrownBy(() -> new Name(WEIRD_CAR_NAME_2))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}