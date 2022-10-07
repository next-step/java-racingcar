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
    @DisplayName("한 라운드 테스트")
    void nameValidateTest() {
        Racing racing = new Racing(3);
        List<Car> list = new ArrayList<>();
        MoveNumber moveNumber = new MoveNumber();
        StopNumber stopNumber = new StopNumber();

        list.add(new Car("tom"));

        racing.round(moveNumber, list);

        assertThat(list.get(0).isSamePosition(2)).isTrue();

        list.add(new Car("jenny"));

        racing.round(stopNumber, list);

        assertThat(list.get(1).isSamePosition(1)).isTrue();
    }


}
