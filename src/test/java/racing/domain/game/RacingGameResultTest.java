package racing.domain.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.car.RacingCars;
import racing.domain.car.TestCarForwardBehavior;
import racing.domain.car.TestCarStopBehavior;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameResultTest {
    private RacingCars racingCars;
    private List<String> winnerList;

    @BeforeEach
    void setup() {
        winnerList = new ArrayList<>();

        RacingCars racingCars = new RacingCars("pobi,crong,honux");

        racingCars.getCars().get(0).move(new TestCarForwardBehavior());
        racingCars.getCars().get(0).move(new TestCarForwardBehavior());

        racingCars.getCars().get(1).move(new TestCarForwardBehavior());
        racingCars.getCars().get(1).move(new TestCarStopBehavior());

        racingCars.getCars().get(2).move(new TestCarForwardBehavior());
        racingCars.getCars().get(2).move(new TestCarForwardBehavior());

        winnerList.add(racingCars.getCars().get(0).getCarName());
        winnerList.add(racingCars.getCars().get(2).getCarName());
    }

    @Test
    void getWinners() {
        List<String> winner = new ArrayList<>();
        RacingGameResult racingGameResult = new RacingGameResult(racingCars, winner);

        assertThat(racingGameResult.getWinnerList()).isEqualTo(winnerList);
    }
}
