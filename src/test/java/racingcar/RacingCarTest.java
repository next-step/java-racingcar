package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RacingCar;
import racingcar.view.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private final RacingCar racingCar = new RacingCar();

    @DisplayName("자돝차의 출발 위치는 0")
    @ParameterizedTest
    @ValueSource(ints = {0})
    void startingPositionOfTheCarIsZero(int input) {

        assertThat(racingCar.getPosition()).isEqualTo(input);
    }

    @DisplayName("Random 4 이상 이면 전진")
    @ParameterizedTest
    @ValueSource(ints = {4, 7, 8})
    void random4OrHigherForward(int input) {
        racingCar.move(input);
        assertThat(racingCar.getPosition()).isEqualTo(1);
    }

    @DisplayName("Random 4 미만 이면 정지")
    @ParameterizedTest
    @ValueSource(ints = {3, 2})
    void Random4OrLessStop(int input) {
        racingCar.move(input);
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }

    @DisplayName("Random 4 이상 이면 하이픈 생성 확인")
    @ParameterizedTest
    @ValueSource(ints = {4, 7, 8})
    void confirmHyphen(int input) {
        RacingCar racingCar = new RacingCar();
        racingCar.move(input);
        String hyphen = ResultView.showMove('-', racingCar);
        assertThat(hyphen).isEqualTo("-");
    }

}
