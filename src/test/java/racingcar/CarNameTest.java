package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {

    @Test
    @DisplayName("자동차에 이름을 부여한다")
    void 자동차에_이름을_부여한다() {
        assertThatCode(() -> new CarName("chan")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("차 이름이 같다")
    void 차_이름이_같다() {
        CarName carName = new CarName("chan");
        CarName sameCarName = new CarName("chan");

        assertThat(carName).isEqualTo(sameCarName);
    }

    @Test
    @DisplayName("차 이름이 5 글자 이상이면 런타임 에러를 반환한다")
    void 차_이름이_5_글자_이상이면_런타임_에러를_반환한다() {
        assertThatThrownBy(() -> new CarName("failff")).isInstanceOf(RuntimeException.class);
    }
}
