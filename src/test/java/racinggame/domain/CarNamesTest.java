package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarNamesTest {
    private String carNameString = "pobi,crong,honux";

    @Test
    void 생성자_정상() {
        CarNames carNames = new CarNames(carNameString);
        assertThat(carNames.getCarNameList()).containsExactly("pobi", "crong", "honux");
    }

    @Test
    void 생성자_비정상() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarNames(""));
    }
}
