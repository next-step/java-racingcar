package racing.domain;

import com.racing.domain.CarName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class CarNameTest {
    @Test
    @DisplayName("CarName 객체가 생성자를 통해 정상적으로 만들어지는지 여부")
    public void positionConstructorTest() {
        CarName carName = new CarName("poby");

        assertThat(new CarName("poby")).isEqualTo(carName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    @DisplayName("빈 문자열이나 공백으로 CarName 객체 생성 시 예외 발생")
    public void createCarNameWithEmptyNameThrowsException(String invalidName) {
        assertThatThrownBy(() -> new CarName(invalidName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("null로 CarName 객체 생성 시 예외 발생")
    public void createCarNameWithNullThrowsException() {
        assertThatThrownBy(() -> new CarName(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
