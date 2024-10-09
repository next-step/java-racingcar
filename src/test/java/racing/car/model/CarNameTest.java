package racing.car.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.car.model.CarName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {
    @Test
    @DisplayName("자동차_이름이_5글자_미만_성공")
    void 자동차_이름_5글자_미만_성공() {
        String name = "leo";
        CarName carName = new CarName(name);

        assertThat(carName).isEqualTo(new CarName("leo"));
    }

    @Test
    @DisplayName("자동차_이름이_5글자_초과_에러")
    void 자동차_이름_5글자_초과_에러() {

        assertThatThrownBy(() -> {
            new CarName("hanseounggyun");
        }).isInstanceOf(RuntimeException.class).hasMessageMatching("자동차 이름이 5자글자를 초과하였습니다.");
    }

}