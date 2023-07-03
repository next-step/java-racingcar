package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    @DisplayName("쉼표로 구분된 여러 자동자 이름을 분리한다.")
    public void 쉼표로_구분된_여러_자동자_이름을_분리한다() throws Exception {
        String str = "pobi,crong,honux";
        String[] cars = Cars.split(str);

        assertThat(cars[0]).isEqualTo("pobi");
        assertThat(cars[1]).isEqualTo("crong");
        assertThat(cars[2]).isEqualTo("honux");
    }

    @Test
    @DisplayName("각 자동차에 이름을 부여할 수 있다.")
    public void 각_자동차에_이름을_부여할_수_있다() throws Exception {
        String name = "chanu";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과이면 에러를 던진다")
    public void 자동차_이름이_5자_초과이면_에러를_던진다() throws Exception {
        String name = "failfail";
        assertThatThrownBy(()-> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }
}
