package study;

import com.step3.model.InputNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class InputNumberTest {
    @Test
    @DisplayName("InputNumber class 생성자 test")
    void create() {
        InputNumber inputNumber = new InputNumber(3, 5);
        assertThat(inputNumber).isEqualTo(new InputNumber(3, 5));
    }
}
