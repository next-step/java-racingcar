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

    @DisplayName("요구사항2_커스텀 구분자 찾기")
    @Test
    void customCharTest(){
        assertThat(strSum.customChar("//[\n1.23:5,67")).isEqualTo("[");
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

    @DisplayName("요구사항3_계산기 예외처리")
    @Test
    void calculatorTest(){
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    assertThat(strSum.calculator()).isEqualTo(24);
                });

    }
}
