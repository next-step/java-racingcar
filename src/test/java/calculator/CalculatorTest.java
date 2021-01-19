package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "1+1",
            "2+2",
            "3+3"
    })
    void testWithCsvSource(String formula) {
        assertNotNull(formula);
    }

    @Test
    @DisplayName("StringToDouble 테스")
    public void stringToDoubleTest() {
        ArrayList<String> actual = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        ArrayList<Double> expected = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        assertThat(Calculator.stringToDouble(actual)).isEqualTo(expected);
    }

    @Test
    @DisplayName("calculateFormula 테스트")
    public void calculateFormula() {
        // TODO: 중복 줄일 수 있는 방법 알아보기
        ArrayList<Double> operands1 = new ArrayList<>(Arrays.asList(1.0, 2.0, 2.0));
        ArrayList<String> operators1 = new ArrayList<>(Arrays.asList("-", "/"));
        ArrayList<Double> operands2 = new ArrayList<>(Arrays.asList(2.0, 3.0, 4.0, 2.0));
        ArrayList<String> operators2 = new ArrayList<>(Arrays.asList("+", "*", "/"));
        ArrayList<Double> operands3 = new ArrayList<>(Arrays.asList(2.0, 3.0));
        ArrayList<String> operators3 = new ArrayList<>(Arrays.asList("+"));
        assertThat(Calculator.calculateFormula(operators1, operands1)).isEqualTo(-0.5);
        assertThat(Calculator.calculateFormula(operators2, operands2)).isEqualTo(10.0);
        assertThat(Calculator.calculateFormula(operators3, operands3)).isEqualTo(5.0);
    }

}
