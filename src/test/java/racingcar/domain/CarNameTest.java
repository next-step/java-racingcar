package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    private static final String POBI = "pobi";
    private static final String CRONG = "crong";

    @DisplayName("생성자 유효성 검사")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"long name"})
    void validation(String invalidName) {
        assertThatThrownBy(() -> new CarName(invalidName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void equals() {
        assertThat(new CarName(POBI)).isEqualTo(new CarName(POBI));
        assertThat(new CarName(POBI)).isNotEqualTo(new CarName(CRONG));
    }

}