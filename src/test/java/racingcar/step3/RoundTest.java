package racingcar.step3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step3.common.RandomToSpecificInt;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private Round round;
    private RandomToSpecificInt random;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("각 자동차의 현재 위치만큼 '-'를 출력한다.")
    @Test
    void printEachCarLocation() {
        // given
        round = new Round(3);
        random = new RandomToSpecificInt(4);

        // when
        round.startRound(random);
        round.startRound(random);
        round.startRound(random);
        round.printRoundResult();

        // then
        assertThat(output.toString().trim()).isEqualTo("---\n" + "---\n" + "---");
    }

    @DisplayName("랜덤값이 4~9이면 움직이고, 0~3이면 움직이지 않는다.")
    @Test
    void moveCarDependOnRandomValue() {
        // given
        round = new Round(3);
        random = new RandomToSpecificInt(4);

        // when
        round.startRound(random);
        round.startRound(random);

        random = new RandomToSpecificInt(1);
        round.startRound(random);
        round.startRound(random);
        round.printRoundResult();

        // then
        assertThat(output.toString().trim()).isEqualTo("--\n" + "--\n" + "--");
    }
}