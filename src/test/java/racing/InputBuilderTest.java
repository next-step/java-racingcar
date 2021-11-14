package racing;

import org.junit.jupiter.api.Test;
import racing.service.InputBuilder;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class InputBuilderTest {
    @Test
    void InputBuilderTest() {
        String name = "ab,abc,abcd";
        String[] expect = name.split(",");
        InputBuilder inputBuilder = new InputBuilder(name);
        List<String> nameList = inputBuilder.getNameList();
        for (int i = 0; i < 3; i++) {
            assertEquals(nameList.get(i), expect[i]);
        }
    }
}
