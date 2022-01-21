package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.common.info.RacingGameErrorInfo.*;

import java.lang.reflect.Method;
import java.util.List;
import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.UserInput;
import racingcar.common.info.RacingGameErrorInfo;

public class ApplicationTest {

    private UserInput userInput;

    @DisplayName("객체 초기화")
    @BeforeEach
    void init(){
        userInput = new UserInput();
    }

    @DisplayName("유저_입력_글자길이_테스트")
    @Test
    void userInputLengthTest() {
        userInput.setCarNameInput("CarNameIsLong");
        assertTrue(userInput.parsingCarName() == true);
    }

    @DisplayName("유저_입력_중복_테스트")
    @Test
    void userInputDuplicationTest(){
        userInput.setCarNameInput("Benz,Kia,Kia");
        assertThat(userInput.parsingCarName() == true);
    }

    @DisplayName("입력_횟수_범위_테스트")
    @Test
    void userInputRacingTry() {
        userInput.setRacingTryCounter(10);
        assertThat(userInput.parsingRacingTry() == true);
    }
}
