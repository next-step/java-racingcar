package racinggame.view;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;
import racinggame.domain.RacingCar;

class RacingCarViewTest {

    @Test
    void 생성자_테스트() throws NoSuchFieldException, IllegalAccessException {
        RacingCarView racingCarView = new RacingCarView(new RacingCar("car1"));

        Field racingCar = RacingCarView.class.getDeclaredField("racingCar");
        racingCar.setAccessible(true);
        assertNotNull(racingCar.get(racingCarView));
    }
}