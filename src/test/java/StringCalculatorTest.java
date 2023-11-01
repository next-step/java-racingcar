import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;

public class StringCalculatorTest {

//    쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
//    앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
//    예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
//    문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

// 스탭 정의
// 1. 디폴트로 , 와 :는 있고 더 필요하면 구분자들을 사용해서 커스텀 구분자도 지정할 수 있다.


    @ParameterizedTest
    @ValueSource(strings = {"//,\n1,2,3", "//:\n1:2:3","1,2:3"})
    @DisplayName("설명 입력하기")
    void writingMethodName(String target) throws Exception {
        // 구분자 구하기
        String delimeter = ",|:";
        int slashNIndex = 0;
        if (target.contains("//") && target.contains("\n")) {
            slashNIndex = target.indexOf("\n");
            String addDelimeter = target.substring(slashNIndex - 1, slashNIndex);
            if (!delimeter.contains(addDelimeter)) {
                delimeter += addDelimeter;
            }
        }
        // 구분자로 배열 만들기
        if(slashNIndex != 0 ) {
            target = target.substring(slashNIndex+1);
        }
        String[] split = target.split(delimeter);

        // 배열의 합 구하기
        int sum = List.of(split).stream().mapToInt(Integer::parseInt).sum();

        Assertions.assertThat(sum).isEqualTo(6);
    }
}
