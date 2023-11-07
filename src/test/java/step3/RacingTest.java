package step3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingTest {

    private Random random = new Random();

    @Test
    void assertRecordAndRound() {
        Racing newGame = new Racing(new int[5], 2, random);

        assertThat(newGame.record.length).isEqualTo(5);
        assertThat(newGame.round).isEqualTo(2);
    }

    @Test
    void assertStartGame() {
        Racing newGame = new Racing(new int[5], 2, random);
        assertThat(Arrays.stream(newGame.record).sum()).isEqualTo(0);

        newGame.startGame();
        assertThat(Arrays.stream(newGame.record).sum()).isGreaterThan(0);
    }



}