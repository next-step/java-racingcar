package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("자동자 이름 테스트")
class NameTest {

    @Test
    @DisplayName("자동차 이름을 입력받아")
    void testName() {
        // Given & When
        String userInputNames = "pobi,crong,honux";
        Name name = new Name(userInputNames);

        final String[] names = name.getNames();

        // Then
        assertThat(names).contains("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("자동차 이름을 입력받을 때 null, '' 입력시 예외처리")
    void testNameException() {
        // Given
        String userInputNames1 = null;
        String userInputNames2 = "";
        
        // Then & When
        assertAll(
                () -> assertThatThrownBy(() -> new Name(userInputNames1))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Name(userInputNames2))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

}