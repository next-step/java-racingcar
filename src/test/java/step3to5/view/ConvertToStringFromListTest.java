package step3to5.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertToStringFromListTest {

    @Test
    @DisplayName("List를 String으로 변환하는 테스트")
    void convertToStringFromList() {
        // given
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("dev");

        String expected = "hello, world, dev";

        // when
        String actual = ResultView.convertToStringFromList(list);

        // then
        assertEquals(actual, expected);
    }
}
