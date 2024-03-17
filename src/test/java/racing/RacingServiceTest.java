package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RacingValidator;
import util.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingServiceTest {

    @Test
    @DisplayName("자동차가 1칸 앞으로 전진한다.")
    void 자동차_전진_테스트() {
        Car car = new Car(0);
        RacingService.moveForward(car);
        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("0에서 9 사이의 랜덤 숫자를 얻는다.")
    void 랜덤_숫자_얻기_테스트() {
        Integer randomNumber = RandomNumberGenerator.getRandomNumber();
        assertThat(isNumberInRange(randomNumber)).isTrue();
    }

    @Test
    @DisplayName("전진할 수 있는지 여부를 확인한다.")
    void 전진_가능_여부_테스트() {
        Integer randomNumber = RandomNumberGenerator.getRandomNumber();
        if (randomNumber >= 4) {
            assertThat(RacingValidator.isMovable(randomNumber)).isTrue();
            return;
        }
        assertThat(RacingValidator.isMovable(randomNumber)).isFalse();
    }


    private boolean isNumberInRange(int number) {
        return number >= 0 && number <= 9;
    }

}
