package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private LinkedList<Integer> numberList;
    private LinkedList<Character> operatorList;
    private StringCalculator stringCalculator;
    private String input;

    @BeforeEach
    void init(){
        numberList = new LinkedList <>();
        operatorList = new LinkedList <>();
        stringCalculator = new StringCalculator();
        input = "4+2/2*3-1";
    }

    @Test
    @DisplayName("숫자, 사직연산 기호 추출 테스트")
    void numberSymbolExtractTest(){
        stringCalculator.numberSymbolExtract(input, numberList, operatorList);
        assertThat(numberList).containsExactly(4, 2, 2, 3, 1);
        assertThat(numberList.size()).isEqualTo(5);
        assertThat(operatorList).containsExactly('+', '/', '*', '-');
        assertThat(operatorList.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("추출된 숫자와 연산기호 이용 순차 반복 계산 테스트")
    void calculationLoopTest(){
        Integer[] numberArray = new Integer[]{4,2,2,3,1};
        Character[] operatorArray = new Character[]{'+','/','*','-'};
        numberList.addAll(Arrays.asList(numberArray));
        operatorList.addAll(Arrays.asList(operatorArray));
        stringCalculator.calculationLoop(numberList, operatorList);
        assertThat(numberList.poll()).isEqualTo(8);
        assertThat(numberList.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("문자열 계산기 실행 테스트")
    void excuteCalculationTest(){
        int stringCalculationResult = stringCalculator.excuteCalculation(input);
        assertThat(stringCalculationResult).isEqualTo(8);
    }

}