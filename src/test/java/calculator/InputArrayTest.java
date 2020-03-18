package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputArrayTest {
    @DisplayName("split된 input의 짝수번째 자리에 지정된 연산자가 아닌 문자열이 오면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings ="&, @, =, 3" )
    void validateInputArrayTest(String operator){
        //given
        String[] inputArr = {"1", operator, "3"};

        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
           new InputArray(inputArr);
        });



    }
}
