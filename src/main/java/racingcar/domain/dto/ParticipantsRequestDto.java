package racingcar.domain.dto;

import racingcar.domain.car.Participants;

public class ParticipantsRequestDto {

    private final String[] names;

    public ParticipantsRequestDto(String[] names) {
        this.names = names;
    }

    public static Participants toEntity(ParticipantsRequestDto participantsRequestDto) {
        return Participants.createCars(participantsRequestDto.names);
    }
}
