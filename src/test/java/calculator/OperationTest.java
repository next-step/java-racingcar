package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("연산 기호 테스트")
class OperationTest {

    @Test
    @DisplayName("생성 테스트")
    public void create() {
        Operation operation = Operation.ADDITION;
        assertNotNull(operation);
    }

    @Nested
    @DisplayName("연산 기호 검색 테스트")
    class OperationCheck {

        @Test
        @DisplayName("\"+\" 입력 시, enum 정상 리턴")
        public void searchOfAddition() {
            Operation operation = Operation.findOf("+");
            assertEquals(Operation.ADDITION, operation);
        }

        @Test
        @DisplayName("\"-\" 입력 시, enum 정상 리턴")
        public void searchForSubtraction() {
            Operation operation = Operation.findOf("-");
            assertEquals(Operation.SUBTRACTION, operation);
        }

        @Test
        @DisplayName("\"*\" 입력 시, enum 정상 리턴")
        public void searchForMultiplication() {
            Operation operation = Operation.findOf("*");
            assertEquals(Operation.MULTIPLICATION, operation);
        }

        @Test
        @DisplayName("\"/\" 입력 시, enum 정상 리턴")
        public void searchForDivision() {
            Operation operation = Operation.findOf("/");
            assertEquals(Operation.DIVISION, operation);
        }
    }

    @Nested
    @DisplayName("연산 기호 연산 테스트")
    class OperationTestOfOperate {

        @Test
        @DisplayName("1, 2 값을 넘겨 '덧셈' 동작 시 3 리턴")
        public void addition() {
            Operation operation = Operation.ADDITION;
            int additionResult = operation.execute(1, 2);
            assertEquals(additionResult, 3);
        }

        @Test
        @DisplayName("2, 1 값을 넘겨 '뺄셈' 동작 시 1 리턴")
        public void subtraction() {
            Operation operation = Operation.SUBTRACTION;
            int subtractionResult = operation.execute(2, 1);
            assertEquals(subtractionResult, 1);
        }

        @Test
        @DisplayName("2, 2 값을 넘겨 '곱셈' 동작 시 4 리턴")
        public void multiplication() {
            Operation operation = Operation.MULTIPLICATION;
            int multiplicationResult = operation.execute(2, 2);
            assertEquals(multiplicationResult, 4);
        }

        @Test
        @DisplayName("5, 2 값을 넘겨 '나눗셈' 동작 시 2 리턴")
        public void division() {
            Operation operation = Operation.DIVISION;
            int divisionResult = operation.execute(5, 2);
            assertEquals(divisionResult, 2);
        }
    }
}