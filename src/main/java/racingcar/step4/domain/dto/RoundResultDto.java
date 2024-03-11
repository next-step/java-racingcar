package racingcar.step4.domain.dto;

import java.util.List;

public class RoundResultDto {

    List<ParticipantResultDto> participantResults;

    public RoundResultDto(List<ParticipantResultDto> participantResults) {
        this.participantResults = participantResults;
    }

    public List<ParticipantResultDto> getParticipantResults() {
        return participantResults;
    }
}
