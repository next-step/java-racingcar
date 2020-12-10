package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.rule.FixedRacingRule;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NamedRacingCarDriverTest {


    @ParameterizedTest
    @CsvSource(value = {"a:1", "a,b:2", "a,b,c:3"}, delimiter = ':')
    @DisplayName("주어진 목록에 맞게 자동차가 생성되었는지 테스트")
    public void createNamedRacingCarsCount(String input, String expected) {
        // given
        NamedRacingCarDriver racingCarDriver = new NamedRacingCarDriver(input.split(","));

        // when
        List<RacingCar> racingCars = racingCarDriver.getRacingCars();

        // then
        assertThat(racingCars.size()).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"a:a", "a,b:b", "a,b,c:c"}, delimiter = ':')
    @DisplayName("주어진 목록에 맞게 자동차가 생성되었는지 테스트")
    public void createNamedRacingCarsName(String input, String expected) {
        // given
        NamedRacingCarDriver racingCarDriver = new NamedRacingCarDriver(input.split(","));

        // when
        List<RacingCar> racingCars = racingCarDriver.getRacingCars();

        // then
        assertThat(((NamedRacingCar) racingCars.get(racingCars.size() - 1)).getName())
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,0", "4,1", "9,1", "0,0"})
    @DisplayName("주어진 숫자에 맞게 자동차가 진행했는지 거리를 테스트")
    public void moveForwardAll(String input, String expected) {
        // given
        FixedRacingRule racingRule = new FixedRacingRule(Integer.parseInt(input));
        NamedRacingCarDriver racingCarDriver = new NamedRacingCarDriver(new String[]{"car1"});

        // when
        racingCarDriver.moveForwardAll(racingRule);
        Integer distance = racingCarDriver.getNowDistance().get(0);

        // then
        assertThat(distance).isEqualTo(Integer.parseInt(expected));
    }
}
