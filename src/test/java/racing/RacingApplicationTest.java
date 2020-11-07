package racing;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingApplicationTest {
    private static final String DRIVERS = "Lewis Hamilton,Valtteri Bottas,Max Verstappen";
    private static final int MAX_ROUND = 5;

    @Test
    void testApplication() {
        String sample = DRIVERS + "\n" + MAX_ROUND;

        ByteArrayInputStream in = new ByteArrayInputStream(sample.getBytes());
        System.setIn(in);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        RacingApplication.main(null);
        assertThat(outContent.toString()).contains("Lewis Hamilton : -");
    }
}
