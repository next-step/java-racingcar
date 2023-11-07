package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static carracing.util.InputValueValidate.splitCommaInputCarName;
import static carracing.util.InputValueValidate.verifyExceedFiveCarName;
import static org.assertj.core.api.Assertions.*;

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
        String carName = "abc";
        int trialCount = -4;
        assertThatThrownBy(() -> new RacingGame(carName, trialCount))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("0부터 9 사이의 random 숫자 생성")
    public void create_random_number() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        for (int i = 0; i < 50; i++) {
            int randomNumber = randomNumberGenerator.getRandomNumber();
            assertThat(randomNumber).isBetween(0, 9);
        }
    }

    @Test
    @DisplayName("쉼표 기준으로 자동차의 이름 3개 입력 시 배열 크기 확인")
    public void split_comma_car_name() {
        String carName = "a,bb,ccc";

        String[] names = splitCommaInputCarName(carName);

        assertThat(names).hasSize(3);
    }

    @Test
    @DisplayName("자동차의 이름은 5를 초과할 수 없다.")
    public void exceed_five_car_name_validate() {
        assertThatThrownBy(() -> verifyExceedFiveCarName("abcde"))
                .isInstanceOf(RuntimeException.class);
    }

}
