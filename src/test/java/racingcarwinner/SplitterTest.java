package racingcarwinner;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class SplitterTest {

    @Test
    @DisplayName("문자열 분리 테스트")
    public void split(){
        String[] splitString = Splitter.splitName("포비,코난,베니");
        assertEquals(splitString[0],"포비");
        assertEquals(splitString[1],"코난");
        assertEquals(splitString[2],"베니");
    }
}
