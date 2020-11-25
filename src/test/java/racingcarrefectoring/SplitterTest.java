package racingcarrefectoring;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import racingcarrefectoring.model.Splitter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class SplitterTest {

    @Test
    @DisplayName("문자열 분리가 잘 되는가")
    public void splitName(){
        String[] strings = Splitter.splitName("포비,코난,베니");
        String[] splitName = "포비,코난,베니".split(",");
        assertArrayEquals(strings, splitName);

    }
}
