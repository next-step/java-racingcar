import domain.RacingCar;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomNumberGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("자동차 경주 테스트")
public class RacingCarTest {

    @Test
    @DisplayName("전진하는 값은 오직 0 ~ 9 이내의 랜덤 값만 생성되어야 한다.")
    void generateRandomNumberTest() {
        int numberOfTest = 1000;
        for (int i = 0; i < numberOfTest; i++) {
            int randomNumber = RandomNumberGenerator.generateRandomNumber();

            assertTrue(randomNumber >= 0 && randomNumber <= 9);
        }
    }

    @Test
    @DisplayName("전진 후에는 자동차의 위치가 1 증가되어야 한다.")
    void carMoveTest() {
        RacingCar racingCar = new RacingCar();
        int beforePosition = racingCar.getPosition();

        racingCar.moveForward();

        int afterPosition = racingCar.getPosition();
        Assertions.assertThat(afterPosition).isEqualTo(beforePosition + 1);
    }

}
