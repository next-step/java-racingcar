package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.rule.FixedRacingRule;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class RacingCarDriverTest {
    @ParameterizedTest
    @CsvSource(value = {"a:1", "a,b:2", "a,b,c:3"}, delimiter = ':')
    @DisplayName("주어진 목록에 맞게 자동차가 생성되었는지 테스트")
    public void createNamedRacingCarsCount(String input, String expected) {
        // given
        RacingCarDriver racingCarDriver = new RacingCarDriver(new InputView().makeParticipantsList(input));

        // when
        List<RacingCar> targetRacingCars = racingCarDriver.getRacingCars();

        // then
        assertThat(targetRacingCars.size()).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"a:a", "a,b:b", "a,b,c:c"}, delimiter = ':')
    @DisplayName("주어진 목록에 맞게 자동차가 생성되었는지 테스트")
    public void createNamedRacingCarsName(String input, String expected) {
        // given
        RacingCarDriver racingCarDriver = new RacingCarDriver(new InputView().makeParticipantsList(input));

        // when
        List<RacingCar> targetRacingCars = racingCarDriver.getRacingCars();

        // then
        assertThat(targetRacingCars.get(targetRacingCars.size() - 1).getName())
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,0", "4,1", "9,1", "0,0"})
    @DisplayName("주어진 숫자에 맞게 자동차가 진행했는지 거리를 테스트")
    public void moveForwardAll(String input, String expected) {
        // given
        FixedRacingRule racingRule = new FixedRacingRule(Integer.parseInt(input));
        RacingCarDriver racingCarDriver = new RacingCarDriver(Arrays.asList("test1"));

        // when
        racingCarDriver.moveForwardAll(racingRule);
        Integer distance = racingCarDriver.getNowDistance().get(0);

        // then
        assertThat(distance).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"3,2,2:test1", "3,2,3:test1,test3"}, delimiter = ':')
    @DisplayName("우승자를 선별하는 테스트")
    public void getWinner(String input, String expected) {
        // given
        List<Integer> distances = Arrays.stream(input.split(","))
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());
        List<RacingCar> sourceRacingCars
                = Arrays.asList(new RacingCar("test1", distances.get(0))
                                , new RacingCar("test2", distances.get(1))
                                , new RacingCar("test3", distances.get(2)));
        RacingCarDriver racingCarDriver = new RacingCarDriver(new RacingCars(sourceRacingCars));

        // when
        String winner = racingCarDriver.findWinner().toString();

        // then
        assertThat(winner).contains(expected.split(","));
    }
}
