package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RandomMoveStrategyTest {

    MoveStrategy moveStrategy = new RandomMoveStrategy();

    @ParameterizedTest
    @DisplayName("랜덤 전진 조건을 경계 테스트를 한다. ")
    @CsvSource(value = {"3:false", "4:true"}, delimiter = ':')
    void 경계테스트(int randomNumber , boolean expected ){
        Assertions.assertThat(moveStrategy.isMoved(randomNumber)).isEqualTo(expected);
    }


}