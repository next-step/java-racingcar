package racinggame.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.Utils;
import racinggame.domain.RacingCars;

class CarResultViewTest {

    @Test
    void 팩토리_메서드_테스트() {
        final RacingCars racingCars = new RacingCars("car1,car2");
        final List<CarResultView> carResultViews = CarResultView.racingCarOf(racingCars);

        assertThat(carResultViews.size()).isEqualTo(2);
    }

    @ValueSource(ints = {1, 2, 3, 4, 5})
    @ParameterizedTest
    void drawCurrPosition(final int position) {
        final RacingCars racingCars = new RacingCars("car1");
        final CarResultView carResultView = CarResultView.racingCarOf(racingCars).get(0);

        final String currPositionView = carResultView.drawCurrResult();

        final StringBuilder sb = new StringBuilder();
        sb.append("car1 : ")
                .append(Utils.repeat("-", position));

        assertThat(currPositionView.equals(sb.toString()));
    }
}
