import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class StringLearning {
    String arg;

    StringLearning(String arg) {
        this.arg = arg;
    }

    String[] split(){
        return arg.split(",");
    }

    String subString(){
        if (!(arg.startsWith("(") || arg.endsWith(")"))) {
            return "";
        }
        return arg.substring(1, arg.length() - 1);
    }

    char charAt(int index){
        return arg.charAt(index);
    }
}

class StringLearningTest {

    @Test
    void split1(){
        String[] result = new StringLearning("1,2").split();
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split2(){
        String[] result = new StringLearning("1").split();
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    @Test
    void testSubString(){
        String result = new StringLearning("(1,2)").subString();
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("Exception")
    void testCharAtException(){
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    new StringLearning("abc").charAt(3);
                }).withMessageMatching("String index out of range: \\d+");
    }


}