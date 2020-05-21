package racingCar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameResultTest {
    private List<RacingCar> racingCarList;
    private List<RacingCar> winnerResultList;

    @BeforeEach
    void setup() {
        racingCarList = new ArrayList<>();
        winnerResultList = new ArrayList<>();

        RacingCar car1 = new RacingCar("Frodo");
        car1.move(true);
        car1.move(true);
        racingCarList.add(car1);

        RacingCar car2 = new RacingCar("Tube");
        car2.move(true);
        car2.move(true);
        racingCarList.add(car2);

        RacingCar car3 = new RacingCar("Con");
        car3.move(false);
        car3.move(true);
        racingCarList.add(car3);

        RacingCar car4 = new RacingCar("Ape");
        car4.move(false);
        car4.move(false);
        racingCarList.add(car4);

        winnerResultList.add(car1);
        winnerResultList.add(car2);
    }

    @Test
    void findWinners() {
        // Given
        RacingGameResult racingGameResult = new RacingGameResult(racingCarList);

        // When
        List<RacingCar> winnerList = racingGameResult.findWinners();

        // Then
        assertThat(winnerList).hasSize(winnerResultList.size()).hasSameElementsAs(winnerResultList);
    }
}
