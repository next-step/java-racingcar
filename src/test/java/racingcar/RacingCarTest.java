package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("자동차 생성 테스트")
    void createRacingCarTest() {
        Racingcar racingcar = createCar(0, "이름");
        assertThat(0).isEqualTo(racingcar.getCarNumber());
        assertThat("이름").isEqualTo("이름");
    }

    public Racingcar createCar(int number, String name) {
        return new Racingcar(number, name);
    }

}
