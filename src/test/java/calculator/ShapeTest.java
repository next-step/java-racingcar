package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("연산 기호 테스트")
class ShapeTest {

    @Test
    @DisplayName("생성 테스트")
    public void create() {
        Shape shape = Shape.ADDITION;
        assertNotNull(shape);
    }

    @Test
    @DisplayName("\"+\" 입력 시, enum 정상 리턴")
    public void searchOfEnum() {
        Shape shape = Shape.findOf("+");
        assertEquals(Shape.ADDITION, shape);
    }

    @Test
    @DisplayName("ADDITION.'실행'(1, 2) 실행 시, 더한 결과 3 리턴")
    public void functionCheck() {
        Shape addition = Shape.ADDITION;
        int additionResult = addition.execute(1, 2);
        assertEquals(3, additionResult);
    }
}