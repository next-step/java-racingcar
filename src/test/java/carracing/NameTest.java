package carracing;

import carracing.domain.car.Name;
import carracing.utils.exception.CarNameExceedMaxLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @ParameterizedTest(name = "CarName이 {0}이면 생성에 성공한다.")
    @CsvSource({"a", "bb", "ccc", "dddd", "eeeee"})
    @DisplayName("차의이름/5글자까지/생성 성공")
    void createCarName(String carName) {
        assertThat(Name.from(carName)).isInstanceOf(Name.class);
    }

    @Test
    @DisplayName("차의이름/5글자를 초과하면/CarNameExceedMaxLengthException")
    void createCarNameExceedMaxLengthException() {
        assertThatThrownBy(() -> Name.from("ffffff"))
                .isInstanceOf(CarNameExceedMaxLengthException.class);
    }
}
