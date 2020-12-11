package carrace.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {
    @Test
    @DisplayName("자동차 이름 출력")
    void getResultTest() {
        CarName carName = new CarName("leon");
        assertThat(carName.getResult()).isEqualTo("leon : ");
    }

    @Test
    @DisplayName("자동차 이름 길이 6자 제한 초과")
    void validationTest() {
        assertThatThrownBy(() -> {
            new CarName("leon15");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}