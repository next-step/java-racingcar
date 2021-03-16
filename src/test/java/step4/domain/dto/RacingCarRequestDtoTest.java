package step4.domain.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.domain.request.Participants;
import step4.domain.request.Round;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingCarRequestDtoTest {

    @DisplayName("RacingCarRequestDto 가 알맞은 값을 가지고 반환하는지에 대한 테스트")
    @CsvSource(value = {"a:3", "a,b:4", "a,b,c:5"}, delimiter = ':')
    @ParameterizedTest(name = "현재 반복 : {index} / 들어가는 값 : {arguments}")
    void getMethodTest(String sentence, int roundValue) {

        // given
        Participants participants = Participants.from(sentence.split(","));
        Round round = Round.from(roundValue);
        RacingCarRequestDto requestDto = RacingCarRequestDto.of(participants, round);

        // when
        Participants participantsActual = requestDto.getParticipants();
        Round roundActual = requestDto.getRound();

        // then
        assertAll(
                () -> assertThat(participantsActual).isEqualTo(participants),
                () -> assertThat(roundActual).isEqualTo(round)
        );

    }
}