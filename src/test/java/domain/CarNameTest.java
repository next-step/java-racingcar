package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import view.InputView;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {

    @Test
    void 자동차_이름_생성() {
        CarName carName = new CarName("hong");
        assertThat(carName).isEqualTo(new CarName("hong"));
    }

    @Test
    void 자동차_이름_5글자_초과_생성() {
        assertThatThrownBy(() -> new CarName("hong car"))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 자동차_이름_null_또는_공백_생성() {
        assertThatThrownBy(() -> new CarName(""))
                .isInstanceOf(IllegalStateException.class);

        assertThatThrownBy(() -> new CarName(null))
                .isInstanceOf(IllegalStateException.class);
    }

    // TODO
/*    @Test
    void 자동차_이름은_쉼표_기준으로_생성한다(int input, String expected) {

    }*/
}