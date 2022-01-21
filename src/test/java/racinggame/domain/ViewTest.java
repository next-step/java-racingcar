package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class ViewTest {

    @Test
    void 상태를_출력할_자동차_리스트를_받아_생성한다() {

        // given
        String[] cars = {"car1", "car2"};
        List<RacingCar> racingCars = RacingCar.createRacingCarFromCarNames(cars);

        // when
        View view = new View(racingCars);

        // then
        assertThat(view.getRacingCars()).isEqualTo(racingCars);
    }

}