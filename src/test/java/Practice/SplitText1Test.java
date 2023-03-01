package Practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SplitText1Test {
    @Test
    public void confirmSplitText() {
        SplitText1 splitText1 = new SplitText1();

        System.out.println(splitText1.originalText);
        System.out.println(Arrays.toString(splitText1.splitText1));

//        Assertions.assertThat(splitText1.splitText).containsExactly("1");
        Assertions.assertThat(splitText1.splitText1).containsExactly("1", "2");
//        Assertions.assertThat(splitText1.splitText).containsExactly("1", "2", "3");


        System.out.println(splitText1.splitText2);

        Assertions.assertThat(splitText1.splitText2).contains("1");
        Assertions.assertThat(splitText1.splitText2).isEqualTo("1");
    }
}