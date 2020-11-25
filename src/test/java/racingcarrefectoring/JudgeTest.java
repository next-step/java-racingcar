package racingcarrefectoring;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class JudgeTest {

    @Test
    @DisplayName("기준 이상의 숫자일 때 True를 반환하는가")
    public void andAbove(){
        assertTrue(Judge.andAbove(4,4));
        assertFalse(Judge.andAbove(3,4));
    }
}
