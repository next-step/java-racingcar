package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
/*
* private Judgement judgement;
    private Balls computer;

    @BeforeEach
    void setUp() {
        judgement = new Judgement();
        computer = new Balls(Arrays.asList(1,2,3));
    }
*
* */

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    void 입력값이_Null일_때() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> validator.stringCheck(null));
    }

    @Test
    void 입력값이_공백일_때() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> validator.stringCheck(""));
    }

    @Test
    void 입력값에_사칙연산이_아닌_값이_있을_때() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> validator.stringCheck("2 / 3 + 2 # 3"));
    }
}