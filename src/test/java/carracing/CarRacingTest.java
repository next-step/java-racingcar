package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarRacingTest {

    @Test
    @DisplayName("사용자가 전진하는 조건의 수(4)를 입력하면 자동차는 전진한다.")
    void game() {
        // given
        Car car = new Car();
        RandomCreate random = new RandomCreate();

        // when
        car.move(random.randomNumber());

        // then
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("사용자가 자동차 게임 실행 후 음수를 입력하면 RuntimeException이 발생한다.")
    public void negative_validate() throws Exception {
        assertThatThrownBy(() -> new RacingGame(-1,-4))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("0부터 9 사이의 random 숫자 생성")
    public void createRandomNumber() {
        RandomCreate randomCreate = new RandomCreate();

        int randomNumber = randomCreate.randomNumber();

        assertThat(randomNumber).isLessThan(10);
    }
}
