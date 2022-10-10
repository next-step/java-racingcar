package RacingCar;

import RacingCar.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingTest {
    @Test
    @DisplayName("라운드 테스트")
    void nameValidateTest() {
        Cars moveCars = new Cars("tom");
        MoveMovingStrategy moveNumber = new MoveMovingStrategy();
        StopMovingStrategy stopNumber = new StopMovingStrategy();

        moveCars.move(moveNumber);

        assertThat(moveCars.getCars().get(0).isSamePosition(2)).isTrue();

        Cars stopCars = new Cars("tom");

        stopCars.move(stopNumber);

        assertThat(stopCars.getCars().get(0).isSamePosition(1)).isTrue();
    }


}
