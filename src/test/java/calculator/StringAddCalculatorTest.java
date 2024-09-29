package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static calculator.StringAddCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {


    @ParameterizedTest
    @NullSource
    @EmptySource
    void 빈문자열_또는_null(String value) {

        assertThat(splitAndSum(value)).isZero();
        assertThat(splitAndSum(value)).isEqualTo(0);
    }

    @Test
   void 컴마_구분자_합_반환(){
       assertThat(splitAndSum("1,2")).isEqualTo(3);
   }

}
