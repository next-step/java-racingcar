package racing;

import org.junit.jupiter.api.Test;
import racing.service.ConvertInput;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class ConvertInputTest {
    @Test
    void convertInputTest() {
        ConvertInput convertInput = new ConvertInput();
        List<String> nameList = convertInput.convertInput("ab,abc,abcd");
        List<String> expectedList = new ArrayList<>();
        expectedList.add("ab");
        expectedList.add("abc");
        expectedList.add("abcd");
        for (int i = 0; i < 3; i++) {
            assertEquals(nameList.get(i), expectedList.get(i));
        }

    }
}
