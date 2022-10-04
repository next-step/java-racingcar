package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarsDto;
import racingcar.strategy.RandomValueMovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {
    private static final String CAR_NAMES = "pobi,crong,honux";
    private static final int TRY_COUNT = 5;

    private List<Car> carValues;

    @BeforeEach
    void setUp() {
        carValues = new ArrayList<>();
        carValues.add(new Car("pobi", 5));
        carValues.add(new Car("crong", 4));
        carValues.add(new Car("honux", 5));
    }

    @Test
    @DisplayName("예제외 같이 자동차 대수와 시도횟수를 넣고 자동차 경기를 진행하였을 때, DTO에 담기는 자동차 경기의 시도횟수가 일치한다.")
    void racingGameplayTest_hasSize() {
        RacingCarGame racingCarGame = new RacingCarGame(CAR_NAMES, TRY_COUNT);
        List<CarsDto> carsValues = racingCarGame.play(new RandomValueMovingStrategy());

        Assertions.assertThat(carsValues).hasSize(TRY_COUNT);
    }

    @Test
    @DisplayName("우승 자동차를 찾아낸다. 우승 자동차는 'pobi', 'honux' 이다.")
    void findWinnerTest_() {
        RacingCarGame racingCarGame = new RacingCarGame(new Cars(carValues));
        List<Car> winner = racingCarGame.findWinner();
        List<String> winnerNames = winner.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        assertThat(winnerNames).containsExactly("pobi", "honux");
    }
}
