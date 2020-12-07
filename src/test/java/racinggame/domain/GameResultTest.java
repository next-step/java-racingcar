package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.car.CarName;
import racinggame.domain.car.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {
    private GameResult gameResult;

    @BeforeEach
    void setUp() {
        List<RacingCar> racingCars = new ArrayList<>();
        racingCars.add(new RacingCar(new CarName("koko"), 4));
        racingCars.add(new RacingCar(new CarName("soso"), 8));
        racingCars.add(new RacingCar(new CarName("prodo"), 2));
        racingCars.add(new RacingCar(new CarName("momo"), 8));

        gameResult = new GameResult(racingCars);
    }

    @DisplayName("가장 멀리간 우승자들을 골라낸다.")
    @Test
    void pickWinners() {
        List<String> carNames = gameResult.pickWinners().stream()
                .map(CarName::getName)
                .collect(Collectors.toList());

        assertThat(carNames.size()).isEqualTo(2);
        assertThat(carNames).isEqualTo(Arrays.asList("soso", "momo"));
    }
}