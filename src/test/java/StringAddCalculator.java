import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

class StringAddCalculator {
    @ParameterizedTest
    @EmptySource
    @NullSource
    @DisplayName("빈 문자열 또는 null이면 0을 반환")
    void whenGivenNullOrEmpty(String input){
        String str = input;
        int result = -1;

        if(str==null || str.equals("")){
            result = 0;
        }

        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("하나의 문자열로 입력할 경우 해당 숫자를 반환한다")
    void inputOneStringReturnToInteger(){
        String str = "1";
        int result = Integer.parseInt(str);
        Assertions.assertThat(result).isEqualTo(1);
    }

}
