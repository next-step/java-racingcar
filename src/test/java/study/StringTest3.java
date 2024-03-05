package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest3 {
    @DisplayName("특정위치 문자 가져오기")
    @Test
    void findCharOfIndex(){
        String data = "abc";

        assertThatThrownBy(() -> data.charAt(5)
        ).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");

    }
}
