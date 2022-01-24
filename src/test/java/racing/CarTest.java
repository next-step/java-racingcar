package racing;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_이름이_5글자_이상() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> {
                new Car("안녕하세요박찬우입니다.", 4);
            });
    }

    @Test
    void 자동차_3라운드_결과() {
        Car car = new Car("박찬우", 4);
        car.move();
        car.move();
        car.move();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getDistance(); i++) {
            sb.append('-');
        }
    }
}