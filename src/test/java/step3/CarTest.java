package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {

    @Test
    void 자동차_이동_4이상() {
        assertThat(new Car(0).move(5)).isEqualTo(new Car(1));
        assertThat(new Car(0).move(4)).isEqualTo(new Car(1));
        assertThat(new Car(6).move(4)).isEqualTo(new Car(7));
    }
    @Test
    void 자동차_이동_4미만() {
        assertThat(new Car(3).move(3)).isEqualTo(new Car(3));
        assertThat(new Car(0).move(2)).isEqualTo(new Car());
        assertThat(new Car(5).move(1)).isEqualTo(new Car(5));
    }

    @Test
    void 자동차_생성() {
        assertThat(new Car("abcd")).isEqualTo(new Car("abcd"));
        assertThat(new Car("nell")).isEqualTo(new Car("nell"));
        assertThat(new Car("dasom")).isEqualTo(new Car("dasom"));
    }

    @Test
    void 자동차_공백포함_생성() {
        assertThat(new Car(" test ")).isEqualTo(new Car("test"));
        assertThat(new Car("test ")).isEqualTo(new Car("test"));
        assertThat(new Car(" test")).isEqualTo(new Car("test"));
    }

    @Test
    void 자동차_5자_초과_생성() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car("nelldklee");
        }).withMessageMatching(CarName.VALID_MSG_CAR_NAME_EXCESS_SIZE);
    }

}
