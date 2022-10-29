package carracing.util;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class StringUtilTest {
    @Test
    public void 스트링_쉼표기준_자르기(){
        String inputString = "name1,name2,name3";
        List<String> nameList = StringUtil.split(inputString);
        List<String> expectList = Arrays.asList("name1","name2","name3");
        assertThat(nameList).isEqualTo(expectList);
    }

    @Test
    public void 단어_길이_5이하_체크(){
        String rightWord = "name5";
        String wrongWord = "name10";

        Boolean check = StringUtil.checkWordLength(rightWord);
        assertThat(check).isTrue();
        check=StringUtil.checkWordLength(wrongWord);
        assertThat(check).isFalse();
    }
}
