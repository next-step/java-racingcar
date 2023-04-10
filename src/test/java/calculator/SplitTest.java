package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class SplitTest {

    @Test
    void split_multiple(){
        String text = "1,2";
        assertThat(text.split(",")).contains("1","2");
    }

    @Test
    void split_single_with_comma(){
        String text = "1,";
        assertThat(text.split(",")).contains("1");
    }

    @Test
    void split_single_without_comma(){
        String text = "1,";
        assertThat(text.split(",")).contains("1");
    }
}
