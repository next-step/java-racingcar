package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @Test
    @DisplayName("N대의 자동차를 생성할 수 있다.")
    public void makeCars_requiredNumbers_makeSuccess() {
        int k = new Random().nextInt(15);
        Racing racing = new Racing();

        List<Car> madeCarList = racing.makeCars(k);

        assertThat(madeCarList.size()).isEqualTo(k);
    }

}
