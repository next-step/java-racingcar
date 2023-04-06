import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    public void requirement1_whenSplitByComma() {
        //given
        String example1 = "1,2";
        String example2 = "1";

        //when
        String[] answer1 = example1.split(",");
        String[] answer2 = example2.split(",");

        //then
        assertThat(answer1).contains("1");
        assertThat(answer2).containsExactly("1");
    }
    
    @Test
    public void requirement2_whenRemovingBracketsBySubString() throws Exception {
        //given
        String example = "(1,2)";
        String expectedAnswer = "1,2";
        //when
        String answer = example.substring(1, 4);
        
        //then
        assertThat(answer).isEqualTo(expectedAnswer);
    }

    @Test
    @DisplayName("requirement3_whenGettingCharAtSpecificPosition")
    public void requirement3_whenGettingCharAtSpecificPosition() throws Exception {
        //given
        String example = "abc";
        //when
        assertThatThrownBy(() ->{
           char ans = example.charAt(5);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

    }
}
