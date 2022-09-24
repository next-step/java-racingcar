package stringsum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringSumTest {
    StringSum strSum = new StringSum();

    @DisplayName("요구사항1_기본구분자로 분리된 숫자의 합 반환하기")
    @Test
    void basicSumTest(){
        assertThat(strSum.basicSum("1:2,3:4,5,7")).isEqualTo(22);
    }

    @DisplayName("Basic 빈문자일 때 0")
    @Test
    void basicEmptyTset(){
        assertThat(strSum.basicSum("")).isEqualTo(0);
    }

    @DisplayName("Basic null일 때 0")
    @Test
    void basicNullTset(){
        assertThat(strSum.basicSum(null)).isEqualTo(0);
    }

    @DisplayName("요구사항2_커스텀 구분자 찾기")
    @Test
    void customCharTest(){
        assertThat(strSum.customChar("//]\n1-23:5,67")).isEqualTo("]");
    }

    @DisplayName("요구사항2_커스텀 구분자 제거 후 숫자찾기")
    @Test
    void splitStrTest(){
        assertThat(strSum.splitStr("//-\n1-23:5,67")).containsExactly("1","23","5","67");
    }

    @DisplayName("요구사항2_합구하기")
    @Test
    void customSumTest(){
        assertThat(strSum.customSum("//-\n1-23:5,67")).isEqualTo(96);
    }

    @DisplayName("null값이 들어오는 경우")
    @Test
    void emptyValueTest(){
        assertThat(strSum.customSum((""))).isEqualTo(0);
    }

    @DisplayName("빈값이 들어오는 경우")
    @Test
    void nullValueTest(){
        assertThat(strSum.customSum((null))).isEqualTo(0);
    }

    @DisplayName("숫자하나만 들어가는 경우")
    @Test
    void oneNum(){
        assertThat(strSum.customSum("0")).isEqualTo(0);
    }

    @DisplayName("요구사항3_계산기 예외처리")
    @Test
    void calculatorTest(){
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    assertThat(strSum.calculator()).isEqualTo(24);
                });

    }
}
