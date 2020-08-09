package step5.domain.collections;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step5.domain.collections.AttemptResult;
import step5.dto.CarWentResult;

import java.util.Collections;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AttemptResultTest {

    private static Stream<Arguments> provideAttemptResult() {
        AttemptResult onlyOneWinner = new AttemptResult(List.of(new CarWentResult("0",1),
                new CarWentResult("1",0),
                new CarWentResult("2",2)));

        AttemptResult severalWinners = new AttemptResult(List.of(new CarWentResult("0",2),
                new CarWentResult("1",0),
                new CarWentResult("2",2),
                new CarWentResult("3",2)));
        return Stream.of(
                Arguments.of(onlyOneWinner, "2"),
                Arguments.of(severalWinners, "0, 2, 3")
        );
    }

    @DisplayName("객체 생성 테스트 - 아래 테스트를 통과하면 자연스레 검증이 되는 셈인데" +
                    "따로 테스트 작성을 제안해 주신 이유가 있으신 걸까요??")
    @Test
    void constructTest() {
        AttemptResult given = new AttemptResult(List.of(
                                                        new CarWentResult("0",0)
                                                        )
                                                );

        assertThat(given).isInstanceOf(AttemptResult.class);

    }

    @DisplayName("경주시도 결과에 따라 우승자의 이름을 출력, 여러명이면 쉼표공백으로 구분해서 출력")
    @ParameterizedTest
    @MethodSource("provideAttemptResult")
    void getWinners(AttemptResult attemptResult, String result) {
        assertThat(attemptResult.getWinnersNames()).isEqualTo(result);
    }

    @DisplayName("경주 시도 결과가 없으면 IllegalStateException 던짐")
    @Test
    void throwExceptionOfGetWinnersNames() {
        AttemptResult attemptResult = new AttemptResult(Collections.EMPTY_LIST);
        assertThrows(IllegalStateException.class,()->attemptResult.getWinnersNames());
    }

}
