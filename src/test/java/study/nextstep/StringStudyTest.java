package study.nextstep;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringStudyTest {
    @Test
    public void Req1_testStringSplitByComma(){
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @Test
    public void Req1_testStringSplitWithNoComma(){
        assertThat("1".split(",")).containsExactly("1");
    }
}
