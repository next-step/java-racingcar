package racingcarwinnerrefactor;

import org.junit.jupiter.api.Test;
import racingcarwinnerrefactor.domain.Car;
import racingcarwinnerrefactor.domain.Name;
import racingcarwinnerrefactor.exception.NameSizeException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void 자동차이름_글자수초과_예외() {
        assertThatThrownBy(() -> {
            Car car = new Car(new Name("abcdef"));
        }).isInstanceOf(NameSizeException.class);
    }
}
