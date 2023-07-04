package inputtest;

import input.InputForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
public class InputTest {

    @Test
    @DisplayName("input")
    void 사용자_이름_테스트_정상 () {
        String carNames = "pobi,crong,honux";
        assertThatCode(()-> InputForm.enterCarName(carNames)).doesNotThrowAnyException();
    }

    // null // blank " ,  "
    @ParameterizedTest
    @DisplayName("사용자 이름이 정상적으로 입력 되지 않음")
    
    void 사용자_이름_테스트_오류(String str) {
        assertThrows(RuntimeException.class, ()->InputForm.enterCarName(""));
    }

}
