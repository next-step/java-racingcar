package racingcar.domain.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.request.Amount;
import racingcar.domain.request.Round;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarRequestDtoTest {

    @DisplayName("RacingCarRequestDto 가 알맞은 값을 가지고 반환하는지에 대한 테스트")
    @CsvSource(value = {"2:3", "1:4", "2:5"}, delimiter = ':')
    @ParameterizedTest(name = "현재 반복 : {index} / 들어가는 값 : {arguments}")
    void test(int amountExpected, int roundExpected){

        // given
        Amount amount = Amount.getInstance(amountExpected);
        Round round = Round.getInstance(roundExpected);
        RacingCarRequestDto requestDto = RacingCarRequestDto.of(amount, round);

        // when
        int amountActual = requestDto.getAmountValue();
        int roundActual = requestDto.getRoundValue();

        // then
        assertAll(
                () -> assertThat(amountActual).isEqualTo(amountExpected),
                () -> assertThat(roundActual).isEqualTo(roundExpected)
        );

    }


}