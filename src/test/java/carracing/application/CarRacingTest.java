package carracing.application;

import static org.assertj.core.api.Assertions.assertThat;

import carracing.domain.Car;
import carracing.domain.RaceResult;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRacingTest {

    @Test
    @DisplayName("게임을 시작할 자동차를 원하는 갯수만큼 생성할 수 있다.")
    void makeCarTest() {

        // given
        String[] names = {"1", "2", "3"};
        CarRacing carRacing = new CarRacing();

        // when
        List<Car> result = carRacing.makeCars(names);

        // then
        assertThat(result.size()).isEqualTo(names.length);
    }

    @Test
    @DisplayName("게임이 시작하면 지정된 회수만큼 게임이 진행된다.")
    void raceTest() {

        // given
        String inputName = "test1,test2,test3";
        int raceCount = 3;
        CarRacing carRacing = new CarRacing();

        // when
        List<RaceResult> results = carRacing.race(inputName, raceCount);

        // then
        assertThat(results.size()).isEqualTo(raceCount);
    }

}