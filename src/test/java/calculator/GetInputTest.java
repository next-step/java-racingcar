package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetInputTest {

    @DisplayName("파싱이 잘 됐는지 확인")
    @Test
    public void parsingTest() {
        String[] expression = GetInput.parsing("13+5");
        for (int i = 0; i < 3; i++) {
            System.out.println(expression[i]);
        }
    }
}