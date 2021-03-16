package step4.domain.controller;

import step4.domain.dto.RacingCarRequestDto;
import step4.domain.dto.RacingCarResponseDto;
import step4.domain.racing.RacingDrivers;
import step4.domain.racing.RacingRound;
import step4.domain.request.Round;
import step4.domain.startegy.move.RandomMoveStrategy;
import step4.domain.startegy.name.NameLengthLessThanFive;

public class RacingCarGameController {

    private RacingDrivers racingDrivers;
    private RacingRound racingRound;

    public static RacingCarGameController from(RacingCarRequestDto requestDto) {
        return new RacingCarGameController(requestDto);
    }

    private RacingCarGameController(RacingCarRequestDto requestDto) {
        this.racingDrivers = RacingDrivers.from(requestDto.getParticipants(), NameLengthLessThanFive.getInstance());
        this.racingRound = RacingRound.from(getRoundValue(requestDto.getRound()));
    }

    private int getRoundValue(Round round) {
        return round.getValue();
    }

    public RacingCarResponseDto startRacing() {
        RacingCarResponseDto responseDto = createRacingCarResponseDto();
        while (racingRound.hasNext()) {
            responseDto.add(racingDrivers.move(RandomMoveStrategy.getInstance(), NameLengthLessThanFive.getInstance()));
            racingRound.nextRound();
        }
        return responseDto;
    }

    private RacingCarResponseDto createRacingCarResponseDto() {
        return RacingCarResponseDto.newInstance();
    }


}
