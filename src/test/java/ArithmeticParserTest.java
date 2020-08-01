import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticParserTest {

    @DisplayName("피연산자 추출 테스팅")
    @Test
    void extractOperandsFromStringTest() {
        // 해당 메서드는 주어진 문자열 중 숫자만을 판별하여 리스트로 반환해줍니다.
        List<Integer> ints = ArithmeticParser.extractOperandsFromString("2 + 3 / 4 * - 안녕하세요 5 987654 ");
        assertArrayEquals(ints.toArray(), new Integer[]{2, 3, 4, 5, 987654});
    }

    @DisplayName("연산자 추출 테스팅")
    @Test
    void extractOperationsFromStringTest() {
        List<Operator> ops = ArithmeticParser.extractOperationsFromString("+ - / *");
        assertArrayEquals(ops.toArray(), Operator.values());
    }
}