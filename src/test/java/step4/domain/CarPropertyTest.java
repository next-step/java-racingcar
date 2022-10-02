package step4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarPropertyTest {

    CarProperty mockCarProperty;

    @BeforeEach
    void setUp() {
        mockCarProperty = new CarProperty("aaa");
    }

    @Test
    @DisplayName("자동차 이름이 5자 이상으로 검증 로직 실패")
    void validateNameLengthFail() {
        assertThatThrownBy(() -> mockCarProperty.validateNameLength("mustfail"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
