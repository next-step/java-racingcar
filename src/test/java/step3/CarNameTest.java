package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNameTest {

    @Test
    void 자동차이름_생성() {
        assertThat(new CarName("abcd")).isEqualTo(new CarName("abcd"));
        assertThat(new CarName("nell")).isEqualTo(new CarName("nell"));
        assertThat(new CarName("dong")).isEqualTo(new CarName("dong"));
    }

    @Test
    void 자동차이름_5자_초과_생성() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new CarName("nelldklee");
        }).withMessageMatching(CarName.VALID_MSG_CAR_NAME_EXCESS_SIZE);
    }

    @Test
    void 자동차이름_공백_생성() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new CarName("");
        }).withMessageMatching(CarName.VALID_MSG_CAR_NAME_UNDER_SIZE);
    }

}
