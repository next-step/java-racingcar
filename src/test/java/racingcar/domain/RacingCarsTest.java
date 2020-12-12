package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.InputView;
import racingcar.RacingCar;
import racingcar.RacingCarDriver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class RacingCarsTest {

    @Test
    @DisplayName("자동차를 입력한 만큼 생성되었는지 테스트")
    public void newRacingCars() {
        // given
        List<RacingCar> sourceRacingCars
                = Arrays.asList(new RacingCar("test1", 0)
                , new RacingCar("test2", 0)
                , new RacingCar("test3", 0));

        // when
        RacingCars racingCars = new RacingCars(sourceRacingCars);
        List<RacingCar> targetRacingCars = racingCars.getRacingCars();

        // then
        assertThat(targetRacingCars.size()).isEqualTo(3);
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
        RacingCars racingCars = new RacingCars(sourceRacingCars);

        // when
        List<String> winners = racingCars.findWinner();

        // then
        assertThat(winners).contains(expected.split(","));
    }
}