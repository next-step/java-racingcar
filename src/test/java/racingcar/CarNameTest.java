package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNameTest {

    @Test
    @DisplayName("자동차 이름 객체 생성")
    void createCarName() {
        CarName carName = new CarName("pobi");
        assertThat(carName).isEqualTo(new CarName("pobi"));
    }

    @Test
    @DisplayName("자동차 이름 공백 체크")
    void validateCarNamesBlankThrows() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(""))
                .withMessageMatching("이름은 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름 길이 체크")
    void validateCarNamesMaxLengthGrateThenThrows() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName("pobipobi"))
                .withMessageMatching("이름은 5자를 초과할 수 없습니다.");
    }
}
