package step3_bak1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static step3_bak1.ResultView.printRaceStep;

public class RacingCarTest {
    RacingCar rc = new RacingCar();

    int car = 3;
    int count = 5;
    String[][] race = new String[car][count];

    @Test
    void racingTest() {
        rc.racingCar(race);
        printRaceStep(race);
    }

    @ParameterizedTest(name = "{0} : add {1}")
    @MethodSource("parameter_hyphen")
    void 입력값에_따른_하이픈_리턴(boolean input, String result) {
        assertThat(rc.hyphenOrNot(input)).isEqualTo(result);
    }

    static Stream<Arguments> parameter_hyphen(){
        return Stream.of(
                arguments(true, "-")
                ,arguments(false, "")
        );
    }

    @ParameterizedTest(name = "{0} is more than 4 : {1}")
    @MethodSource("parameter")
    void 입력값에_따른_논리결과값(int value, boolean result) {
        assertThat(rc.isValueMoreThan(value)).isEqualTo(result);
    }

    static Stream<Arguments> parameter(){
        return Stream.of(
                arguments(1, false)
                ,arguments(2, false)
                ,arguments(4, true)
                ,arguments(6, true)
        );
    }
}
