package study.step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LessThanMoveConditionTest {

    private LessThanMoveCondition lessThanMoveCondition;

    @BeforeEach
    void init() {
        lessThanMoveCondition = new LessThanMoveCondition(4, new StaticMove(5));
    }

    @Test
    void isPossible() {
        //given

        //when
        boolean condition = lessThanMoveCondition.isPossible();

        //then
        assertThat(condition).isEqualTo(true);
    }
}