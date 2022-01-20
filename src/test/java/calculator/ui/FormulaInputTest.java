package calculator.ui;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class FormulaInputTest {
    FormulaInput formulaInput = new FormulaInput();

    @Test
    void 사용자입력() throws IllegalArgumentException{
        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        try {
            Mockito.when(bufferedReader.readLine()).thenReturn("1 + 3 - 5");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> expected = Arrays.asList("1", "+", "3","-", "5");
        // assertThat("", expected, formulaInput.getFormula(bufferedReader));

        // formulaInput.getFormula(bufferedReader);
        // assertThat().isEqualTo(expected.get(0));
    }

    @Test
    void 사칙연산자_확인() {
        // formulaInput.getFormula();
    }
}