package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnerChooserTest {
    private final String RACER_ONE = "tomo";
    private final String RACER_TWO = "poby";
    private final String RACER_THREE = "yong";
    private final String RACER_FOUR = "crong";

    private int DISTANCE_OF_RACER_ONE = 3;
    private int DISTANCE_OF_RACER_TWO = 5;
    private int DISTANCE_OF_RACER_THREE = 4;
    private int DISTANCE_OF_RACER_FOUR = 5;

    private int WINNER_COUNT_ONE = 1;
    private int WINNER_COUNT_TWO = 2;

    private List<CarState> carStates =  new ArrayList<>();
    @BeforeEach
    void setUp() {
        carStates.add(new CarState(RACER_ONE, DISTANCE_OF_RACER_ONE));
        carStates.add(new CarState(RACER_TWO, DISTANCE_OF_RACER_TWO));
        carStates.add(new CarState(RACER_THREE, DISTANCE_OF_RACER_THREE));
    }

    @Test
    void decideSingleWinner() {
        WinnerChooser winnerChooser = new WinnerChooser(carStates);
        List<CarState> winners = winnerChooser.chooseWinner();

        assertThat(winners.size()).isEqualTo(WINNER_COUNT_ONE);
        assertThat(winners.contains(new CarState(RACER_TWO, DISTANCE_OF_RACER_TWO))).isTrue();
    }

    @Test
    void decideMultipleWinners() {
        carStates.add(new CarState(RACER_FOUR, DISTANCE_OF_RACER_FOUR));

        WinnerChooser winnerChooser = new WinnerChooser(carStates);
        List<CarState> winners = winnerChooser.chooseWinner();

        assertThat(winners.size()).isEqualTo(WINNER_COUNT_TWO);
        assertThat(winners.contains(new CarState(RACER_TWO, DISTANCE_OF_RACER_TWO))).isTrue();
        assertThat(winners.contains(new CarState(RACER_FOUR, DISTANCE_OF_RACER_FOUR))).isTrue();
    }
}
