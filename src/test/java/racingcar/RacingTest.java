package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RacingTest {

    private Racing racing;

    @BeforeEach
    void setup() {
        racing = new Racing(3, 5);
    }

    @Test
    @DisplayName("List<Car> 생성 테스트")
    void makeCarTest() {
        List<Car> carList = racing.makeCar(5);
        Assertions.assertThat(carList.size()).isEqualTo(5);
    }
    
}

