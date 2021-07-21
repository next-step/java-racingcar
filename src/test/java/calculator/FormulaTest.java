package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormulaTest {
    @DisplayName("Number 이후에 Operator가 와야 정상 CalculatorSequence 이다")
    @Test
    void isValidCalculatorSequenceNumberOperator(){
        //given
        Formula.ConfigurationType prevType = Formula.ConfigurationType.NUMBER;
        Formula.ConfigurationType currentType = Formula.ConfigurationType.OPERATOR;

        //when
        boolean isValid = Formula.ConfigurationType.isValidCalculatorSequence(prevType, currentType);

        //then
        assertTrue(isValid);
    }

    @DisplayName("None(처음) 이후에 Number 와야 정상 CalculatorSequence 이다")
    @Test
    void isValidCalculatorSequenceNoneNumber(){
        //given
        Formula.ConfigurationType prevType = Formula.ConfigurationType.NONE;
        Formula.ConfigurationType currentType = Formula.ConfigurationType.NUMBER;

        //when
        boolean isValid = Formula.ConfigurationType.isValidCalculatorSequence(prevType, currentType);

        //then
        assertTrue(isValid);
    }

    @DisplayName("Operator 이후에 Number 와야 정상 CalculatorSequence 이다")
    @Test
    void isValidCalculatorSequenceOperatorNumber(){
        //given
        Formula.ConfigurationType prevType = Formula.ConfigurationType.OPERATOR;
        Formula.ConfigurationType currentType = Formula.ConfigurationType.NUMBER;

        //when
        boolean isValid = Formula.ConfigurationType.isValidCalculatorSequence(prevType, currentType);

        //then
        assertTrue(isValid);
    }

    @DisplayName("Operator 이후에 Operator가 오면 비정상이다")
    @Test
    void isValidCalculatorSequenceOperatorOperator(){
        //given
        Formula.ConfigurationType prevType = Formula.ConfigurationType.OPERATOR;
        Formula.ConfigurationType currentType = Formula.ConfigurationType.OPERATOR;

        //when
        boolean isValid = Formula.ConfigurationType.isValidCalculatorSequence(prevType, currentType);

        //then
        assertFalse(isValid);
    }

    @DisplayName("Operator 이후에 None이 오면 비정상이다")
    @Test
    void isValidCalculatorSequenceOperatorNone(){
        //given
        Formula.ConfigurationType prevType = Formula.ConfigurationType.OPERATOR;
        Formula.ConfigurationType currentType = Formula.ConfigurationType.OPERATOR;

        //when
        boolean isValid = Formula.ConfigurationType.isValidCalculatorSequence(prevType, currentType);

        //then
        assertFalse(isValid);
    }

    @DisplayName("Number 이후에 Number가 오면 비정상이다")
    @Test
    void isValidCalculatorSequenceNumberNumber(){
        //given
        Formula.ConfigurationType prevType = Formula.ConfigurationType.NUMBER;
        Formula.ConfigurationType currentType = Formula.ConfigurationType.NUMBER;

        //when
        boolean isValid = Formula.ConfigurationType.isValidCalculatorSequence(prevType, currentType);

        //then
        assertFalse(isValid);
    }

    @DisplayName("Number 이후에 Number가 오면 비정상이다")
    @Test
    void isValidCalculatorSequenceNumberNone(){
        //given
        Formula.ConfigurationType prevType = Formula.ConfigurationType.NUMBER;
        Formula.ConfigurationType currentType = Formula.ConfigurationType.NONE;

        //when
        boolean isValid = Formula.ConfigurationType.isValidCalculatorSequence(prevType, currentType);

        //then
        assertFalse(isValid);
    }

    @DisplayName("None 이후에 Operator가 오면 비정상이다")
    @Test
    void isValidCalculatorSequenceNoneOperator(){
        //given
        Formula.ConfigurationType prevType = Formula.ConfigurationType.NONE;
        Formula.ConfigurationType currentType = Formula.ConfigurationType.OPERATOR;

        //when
        boolean isValid = Formula.ConfigurationType.isValidCalculatorSequence(prevType, currentType);

        //then
        assertFalse(isValid);
    }

    @DisplayName("None 이후에 None이 오면 비정상이다")
    @Test
    void isValidCalculatorSequenceNoneNone(){
        //given
        Formula.ConfigurationType prevType = Formula.ConfigurationType.NONE;
        Formula.ConfigurationType currentType = Formula.ConfigurationType.NONE;

        //when
        boolean isValid = Formula.ConfigurationType.isValidCalculatorSequence(prevType, currentType);

        //then
        assertFalse(isValid);
    }
}