import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilsTest {

    @Test
    void 전진_또는_후진_여부_검증(){
        assertTrue(ValidationUtils.isRun(4));
        assertTrue(ValidationUtils.isRun(9));
        assertFalse(ValidationUtils.isRun(3));
        assertFalse(ValidationUtils.isRun(0));
    }

    @Test
    void 자동차_이름_5자_이하_검증(){
        assertTrue(ValidationUtils.isName5CharsOrLess("우테캠홧팅"));
        assertTrue(ValidationUtils.isName5CharsOrLess(""));
        assertFalse(ValidationUtils.isName5CharsOrLess("가랏!우리붕붕카"));
        assertFalse(ValidationUtils.isName5CharsOrLess("우승은내꺼지"));
    }
}