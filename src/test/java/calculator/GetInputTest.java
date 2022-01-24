package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetInputTest {

    @DisplayName("파싱이 잘 됐는지 확인")
    @Test
    public void parsingTest() {
        String[] array = new String[100];
        array = GetInput.parsing("13+5");
        for (int i = 0; i < 3; i++) {
            System.out.println(array[i]);
        }
    }
}