package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingTest {

    @Test
    @DisplayName("자동차는 4 이상의 랜덤 값일 경우 한 칸 전진한다.")
    void game() {
        // given
        Car car = new Car();
        int randomNumber = 4;

        // when
        car.move(randomNumber);

        // then
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차는 4 미만의 랜덤 값일 경우 이동하지 않는다.")
    void game_stop() {
        // given
        Car car = new Car();
        int randomNumber = 3;

        // when
        car.move(randomNumber);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("사용자가 자동차 게임 실행 후 음수를 입력하면 RuntimeException이 발생한다.")
    public void negative_validate() throws Exception {
        assertThatThrownBy(() -> new RacingGame(-1, -4))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("0부터 9 사이의 random 숫자 생성")
    public void createRandomNumber() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        for (int i = 0; i < 50; i++) {
            int randomNumber = randomNumberGenerator.getRandomNumber();
            assertThat(randomNumber).isBetween(0, 9);
        }

    }
}
