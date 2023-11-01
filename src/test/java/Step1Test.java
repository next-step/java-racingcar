import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class Step1Test {
    @Test
    void requirementOne(){
        assertThat("1,2".split(","))
                .contains("1", "2");

        assertThat("1".split(","))
                .containsExactly("1");
    }

    @Test
    void requirementTwo(){
        assertThat("(1,2)".substring(1,4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 발생 test")
    void requirementThree(){
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(3);
                });
    }
}
