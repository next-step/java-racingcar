package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class GameProcessTest {

    int count;
    int time;
    Car[] cars;

    String[] carNames;

    RacingStadium racingStadium;

    @BeforeEach
    void setUp() {

        time = 5;

        carNames = new String[3];
        carNames[0] = "pobi";
        carNames[1] = "crong";
        carNames[2] = "hox";

        racingStadium = new RacingStadium(carNames, 5);

        racingStadium.getCar(0).moveForward(4);
        racingStadium.getCar(1).moveForward(1);
        racingStadium.getCar(2).moveForward(1);
    }


    @Test
    void decisionWinnerTest() {
        assertThat(new GameProgress().decisionWinner(racingStadium)).isEqualTo("pobi");
    }

}
