package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CarTest {

    @Test
    @DisplayName("자동차의 이동 횟수가 랜덤한 확률로 증가한다")
    public void moveCarIncreaseMovingCountByRandom() {
        Random random = mock(Random.class);
        when(random.nextInt(10))
                .thenReturn(4);

        Car car = new Car(random);

        car.move();

        assertThat(car.getMoveCount()).isEqualTo(1);
    }
}
