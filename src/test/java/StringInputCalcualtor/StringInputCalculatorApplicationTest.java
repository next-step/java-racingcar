package StringInputCalcualtor;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class StringInputCalculatorApplicationTest {

    @Test
    void testApplication(){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String sample = "2 + 3 * 4 / 2";
        StringInputCalculatorApplication.main(sample.split(" "));
        assertThat(outContent.toString()).isEqualTo("10\n");
    }
}