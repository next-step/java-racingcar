package study.racing4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CarRacingTest {

    private MovingStrategy getAlwaysMoveStrategy(){
        return new MovingStrategy() {
            @Override
            public boolean moveable() {
                return true;
            }
        };
    }

    @Test
    @DisplayName("자동차 레이싱 하나의 라운드를 진행하는데 에러가 없다.")
    void 정상적인_진행_확인() {
        CarRacing racing = new CarRacing(new RacingInput("pobi,crong,honux", 3), getAlwaysMoveStrategy());
        assertDoesNotThrow(() -> racing.processRound());
    }

    @Test
    @DisplayName("자동차 레이싱 결과 사이즈 확인")
    void 라운드_결과_사이즈_확인() {
        CarRacing racing = new CarRacing(new RacingInput("pobi,crong,honux", 3), getAlwaysMoveStrategy());

        racing.processRound();
        racing.processRound();
        racing.processRound();

        List<Car> cars = racing.getCars();

        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("라운드 수를 초과하여 진행하려고하면 예외발생")
    void 라운드_수를_초과하여_진행하려고하면_예외발생() {
        CarRacing racing = new CarRacing(new RacingInput("pobi,crong,honux", 3), getAlwaysMoveStrategy());

        // 라운드 수를 3으로 지정해서 3라운드까지 진행
        racing.processRound();
        racing.processRound();
        racing.processRound();

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    racing.processRound();
                }).withMessageContaining("더 이상 라운드를 진행 할 수 없습니다.");

    }

    @Test
    @DisplayName("3개의 라운드를 지정하고 모두 진행하면 더 이상 진행할 수 없음을 확인")
    void 라운드_수를_초과하여_진행할_수_없음_확인() {
        CarRacing racing = new CarRacing(new RacingInput("pobi,crong,honux", 3), getAlwaysMoveStrategy());

        // 라운드 수를 3으로 지정해서 3라운드까지 진행
        racing.processRound();
        racing.processRound();
        racing.processRound();

        assertThat(racing.isProcessAbleRound()).isEqualTo(false);
    }

    @Test
    @DisplayName("3개의 라운드를 진행하고 우승자 확인")
    void 우승자_확인() {
        CarRacing racing = new CarRacing(new RacingInput("pobi,crong,honux", 3), getAlwaysMoveStrategy());

        // 라운드 수를 3으로 지정해서 3라운드까지 진행
        racing.processRound();
        racing.processRound();
        racing.processRound();

        assertThat(racing.getWinnerCar().size()).isEqualTo(3);
    }
}
