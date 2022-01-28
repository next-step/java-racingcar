package racinggame.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.domain.RacingCar;
import racinggame.domain.Utils;

class CarResultViewTest {

    @Test
    void 팩토리_메서드_테스트() {

        List<RacingCar> racingCars = RacingCar.racingCarOf(new String[]{"car1", "car2"});
        List<CarResultView> carResultViews = CarResultView.racingCarOf(racingCars);

        assertThat(carResultViews.size()).isEqualTo(2);
    }

    @ValueSource(ints = {1, 2, 3, 4, 5})
    @ParameterizedTest
    void drawCurrPosition(int position) {
        List<RacingCar> racingCars = RacingCar.racingCarOf(new String[]{"car1"});
        CarResultView carResultView = CarResultView.racingCarOf(racingCars).get(0);


        String currPositionView = carResultView.drawCurrResult();

        StringBuilder sb = new StringBuilder();
        sb.append("car1 : ")
                .append(Utils.repeat("-", position));

        assertThat(currPositionView.equals(sb.toString()));
    }
}
