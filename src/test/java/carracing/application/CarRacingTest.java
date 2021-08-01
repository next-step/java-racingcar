package carracing.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import carracing.domain.Car;
import carracing.view.ResultView;
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

    @Test
    @DisplayName("게임이 시작하면 지정된 회수만큼 게임이 진행된다.")
    void raceTest() {

        // given
        int carCount = 5;
        int raceCount = 3;
        CarRacing carRacing = new CarRacing();

        // when
        Object view = carRacing.race(carCount, raceCount);

        // then
        assertThat(view).isInstanceOf(ResultView.class);
    }

}