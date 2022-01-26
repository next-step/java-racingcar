package racing;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_이름이_5글자_이상_에러() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> {
                new Car("안녕하세요박찬우입니다.");
            });
    }

    @Test
    void 이동조건_판별_기능_확인() {
        Car car = new Car("어해림");
        car.move(3);
        car.move(5);
        Assertions.assertThat(car.getDistance()).isEqualTo(1);
    }
}
