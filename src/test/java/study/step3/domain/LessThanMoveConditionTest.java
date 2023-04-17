package study.step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LessThanMoveConditionTest {

//    private LessThanMoveCondition lessThanMoveCondition;
//
//    @BeforeEach
//    void init() {
//        lessThanMoveCondition = new LessThanMoveCondition(4, new RandomMove());
//    }
//
//    @ParameterizedTest(name = "[{index}] {0}라는 숫자가 4이하 인지 : {1}")
//    @CsvSource(value = {"1:false", "5:true"}, delimiter = ':')
//    void isPossible(int distance, boolean expected) {
//        //given
//
//        //when
//        boolean condition = lessThanMoveCondition.isPossible();
//
//        //then
//        assertThat(condition).isEqualTo(expected);
//    }
}