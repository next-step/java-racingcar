package step4.domain.dto;

import step4.domain.request.Participants;
import step4.domain.request.Round;

public class RacingCarRequestDto {

    private Participants participants;
    private Round round;

    public static RacingCarRequestDto of(Participants participants, Round round) {
        return new RacingCarRequestDto(participants, round);
    }

    private RacingCarRequestDto(Participants participants, Round round) {
        this.participants = participants;
        this.round = round;
    }

    public Participants getParticipants() {
        return participants;
    }

    public Round getRound() {
        return round;
    }

}
