package racinggame.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.domain.RacingCar;
import racinggame.domain.Utils;

class RacingCarViewTest {

    @Test
    void 생성자_테스트() throws NoSuchFieldException, IllegalAccessException {
        RacingCarView racingCarView = new RacingCarView(new RacingCar("car1"));

        Field racingCar = RacingCarView.class.getDeclaredField("racingCar");
        racingCar.setAccessible(true);
        assertNotNull(racingCar.get(racingCarView));
    }

    @ValueSource(ints = {1, 2, 3, 4, 5})
    @ParameterizedTest
    void drawCurrPosition(int position) {
        RacingCar car1 = new RacingCar("car1", position);
        RacingCarView racingCarView = new RacingCarView(car1);

        String currPositionView = racingCarView.drawCurrPosition();

        StringBuilder sb = new StringBuilder();
        sb.append("car1 : ")
                .append(Utils.repeat("-", position));

        assertThat(currPositionView.equals(sb.toString()));
    }
}
