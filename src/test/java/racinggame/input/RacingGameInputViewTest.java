package racinggame.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.RacingCar;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameInputViewTest {
    @Test
    @DisplayName("입력받은 자동차의 대수만큼 리스트의 요소가 생성된다.")
    void testCarList() {
        final RacingGameInputView racingGameInputView =
            new RacingGameInputView(RacingCarInput.from(3), RacingTryCountInput.from(2));
        final List<RacingCar> racingCars = racingGameInputView.createRacingCars();
        assertThat(racingCars).hasSize(3);
    }

}