package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("라운드가 끝나면 매치가 줄어들고, 0 이하면 실행하지 않는다.")
    void 매치_라운드_감소() {
        RacingCar racingCar = new RacingCar();
        racingCar.setMatch(5);
        racingCar.startMatch();
        assertThat(racingCar.getMatch()).isEqualTo(4);
        racingCar.setMatch(0);
        racingCar.startMatch();
        assertThat(racingCar.getMatch()).isEqualTo(0);
    }

    @Test
    @DisplayName("랜덤 값이 4 이상일 경우 전진한다.")
    void 랜덤값_4_이상_전진() {
        RacingCar racingCar = new RacingCar();
        String result = racingCar.moveForward("-", 4);
        assertThat(result).isEqualTo("--");
        result = racingCar.moveForward("--", 1);
        assertThat(result).isEqualTo("--");
    }

    @Test
    @DisplayName("사용자 입력에 맞춰 매치 수를 세팅한다.")
    void initialize_match() {
        RacingCar racingCar = new RacingCar();
        racingCar.setMatch(5);
        assertThat(racingCar.getMatch()).isEqualTo(5);
    }

    @Test
    @DisplayName("사용자 입력에 맞춰 자동차를 세팅한다.")
    void initialize_car() {
        RacingCar racingCar = new RacingCar();
        racingCar.initializeCar(5);
        assertThat(racingCar.getCars()).hasSize(5);
    }

    @Test
    @DisplayName("0~9 사이의 랜덤 값을 추출한다.")
    void 랜덤값_추출() {
        int random = RacingCar.getRandomValue();
        assertThat(random).isBetween(0, 9);
    }
}
