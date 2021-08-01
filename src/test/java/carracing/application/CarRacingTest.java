package carracing.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import carracing.domain.Car;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRacingTest {

    @Test
    @DisplayName("게임을 시작할 자동차를 원하는 갯수만큼 생성할 수 있다.")
    void makeCarTest() {

        // given
        int count = 5;
        CarRacing carRacing = new CarRacing();

        // when
        List<Car> result = carRacing.makeCars(count);

        // then
        assertThat(result.size()).isEqualTo(count);
    }

}