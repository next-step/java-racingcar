package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.domain.Position;
import racingcar.dto.Board;
import racingcar.domain.Name;
import racingcar.dto.RacingInfo;
import racingcar.domain.Cars;
import racingcar.strategy.impl.RandomBoundMovingStrategy;
import racingcar.util.InputCarNameSplitUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class RacingGameTests {
    @DisplayName("경주에서 우승자를 정해줬을때 결과대로 우승자가 나오는지 테스트")
    @Test
    void findWinnerTest() {

        Car car1 = new Car(new Name("pobi"), new Position(5));
        Car car2 = new Car(new Name("crong"), new Position(3));
        Car car3 = new Car(new Name("honux"), new Position(5));

        Cars cars = Cars.of(Arrays.asList(car1, car2, car3));

        RacingInfo racingInfo = new RacingInfo(cars.getCarsCount(), 5);

        RacingGame racingGame = new RacingGame(racingInfo, cars);

        assertThat(racingGame.findWinners()).contains(new Name("pobi"), new Name("honux"));
    }




}
