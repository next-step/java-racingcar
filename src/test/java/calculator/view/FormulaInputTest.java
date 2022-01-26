package calculator.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class FormulaInputTest {

    @Test
    void 사용자입력() throws IllegalArgumentException{
        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        try {
            Mockito.when(bufferedReader.readLine()).thenReturn("1 + 3 - 5");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> expected = Arrays.asList("1", "+", "3","-", "5");
    }
}