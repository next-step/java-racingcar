package stringsum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringSumTest {
    StringSum strSum = new StringSum();
    // 요구사항1
    // 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
    @DisplayName("요구사항1_쉽표(,)구분자로 문자열 분리하기")
    @Test
    void splitRestTest(){
        assertThat(strSum.basicSplitStr("1,2,3")).containsExactly("1", "2", "3");
    }

    @DisplayName("요구사항1_콜론(:)구분자로 문자열 분리하기")
    @Test
    void splitColonTest(){
        assertThat(strSum.basicSplitStr("1:2:3")).containsExactly("1", "2", "3");
    }

    @DisplayName("요구사항1_쉽표(,)와 콜론(:)이 동시에 있을 경우 문자열 분리")
    @Test
    void basicSplitStrTest(){
        assertThat(strSum.basicSplitStr("1:2,3:4,5,7")).containsExactly("1","2","3","4","5","7");
    }

    @DisplayName("요구사항1_기본구분자로 분리된 숫자의 합 반환하기")
    @Test
    void basicSumTest(){
        assertThat(strSum.basicSum()).isEqualTo(24);
    }

    // 요구사항2
    // 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용
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
    void custeomSumTest(){
        assertThat(strSum.basicSum()).isEqualTo(0);
    }

    // 요구사항3
    // 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw
    @DisplayName("요구사항3_계산기 예외처리")
    @Test
    void calculatorTest(){
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    assertThat(strSum.calculator()).isEqualTo(24);
                });

    }
}
