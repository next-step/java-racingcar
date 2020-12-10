package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        List<String> carNames = Arrays.asList(
                "pobi",
                "crong",
                "honux",
                "YKJ"
        );

        racingCars = new RacingCars(carNames);
    }

    @Test
    @DisplayName("자동차 경주 참가 테스트")
    void participate_racing_test() {
        assertThat(racingCars.getParticipatingCars()).hasSize(4);
    }

    @Test
    @DisplayName("참가한 자동차 레이싱 테스트")
    void racing_test() {
        // when
        racingCars.racing(() -> true);

        // then
        assertThat(racingCars.getParticipatingCars())
                .containsExactly(
                        new RacingCar.RacingCarBuilder("pobi")
                                .carPosition(1)
                                .build(),
                        new RacingCar.RacingCarBuilder("crong")
                                .carPosition(1)
                                .build(),
                        new RacingCar.RacingCarBuilder("honux")
                                .carPosition(1)
                                .build(),
                        new RacingCar.RacingCarBuilder("YKJ")
                                .carPosition(1)
                                .build());
    }

}
