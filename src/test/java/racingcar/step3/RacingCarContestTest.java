package racingcar.step3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step3.common.RandomToSpecificInt;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarContestTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("~~")
    @Test
    void printRacingResult() {
        // given
        RandomToSpecificInt random = new RandomToSpecificInt(5);
        RacingCarContest racingCarContest = new RacingCarContest(3, 3, random);

        // when
        racingCarContest.startRacingContest();

        // then
        assertThat(output.toString().trim()).isEqualTo("-\n" + "-\n" + "-\n\n" + "--\n" + "--\n" + "--\n\n" + "---\n" + "---\n" + "---");
    }
}