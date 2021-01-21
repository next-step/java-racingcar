package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @DisplayName("doRound() 호출하면 움직인 후의 위치 출력")
    @Test
    void doRound() {
        // given
        List<String> carStrings = Arrays.asList(
            "car1",
            "car2",
            "car3"
        );
        Cars cars = new Cars(carStrings, new LookLikeRandomMoveChecker());

        // when
        cars.doRound();

        // then
        assertThat(outputStreamCaptor.toString()).isEqualTo(
                "car1 : -\n" +
                        "car2 : \n" +
                        "car3 : \n\n"
        );
    }
}