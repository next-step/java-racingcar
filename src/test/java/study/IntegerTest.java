package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class IntegerTest {
    @Test
    void IntegerParseInt(){
        String number = "a";
        assertThatThrownBy(() -> Integer.parseInt(number)).isInstanceOf(NumberFormatException.class);
    }
}
