package racingcarrefectoring;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SplitterTest {

    @Test
    @DisplayName("문자열 분리가 잘 되는가")
    public void splitName(){
        Splitter splitter = new Splitter();
        String[] strings = splitter("포비,코난,베니");
        String[] splitName = "포비,코난,베니".split(",");
        assertTrue(strings.equals(splitName));

    }
}
