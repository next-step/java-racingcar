package racing;

import org.junit.jupiter.api.Test;
import racing.domain.InputBuilder;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class InputBuilderTest {
    @Test
    void InputBuilderTest() {
        String name = "ab,abc,abcd";
        String[] expect = name.split(",");
        InputBuilder inputBuilder = new InputBuilder(name);
        List<String> nameList = inputBuilder.getNameList();
        assertThat(inputBuilder.getNameList()).contains("ab","abc","abcd");
    }
}
