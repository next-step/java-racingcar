package new_racingcar.service;

import new_racingcar.strategy.MoveOneStrategy;
import new_racingcar.strategy.MoveStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class GrandPrixTest {
    String inputName;
    List<String> names;
    MoveStrategy moveStrategy;

    @BeforeEach
    public void setUp() {
        inputName = "povi,loop,1234";
        names = Arrays.asList(inputName.split(","));
        moveStrategy = new MoveOneStrategy();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    @DisplayName("시도할 횟수 1 이상 테스트")
    public void roundCountTest(int roundCount) throws Exception {
        //given
        GrandPrix grandPrix;

        //when, then
        new GrandPrix(names, roundCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("시도할 횟수 0 이하 일 때 예외 테스트")
    public void roundCountExceptionTest(int roundCount) throws Exception {
        //given
        GrandPrix grandPrix;

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new GrandPrix(names, roundCount);
        });
    }
}