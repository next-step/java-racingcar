package racingcar.controller;

import racingcar.domain.dto.RacingCarRequestDto;
import racingcar.domain.dto.RacingCarResponseDto;
import racingcar.domain.racing.RacingCars;
import racingcar.domain.racing.RacingRound;

public class RacingCarGameController {

    private RacingCars racingCars;
    private RacingRound racingRound;

    public static RacingCarGameController from(RacingCarRequestDto requestDto) {
        return new RacingCarGameController(requestDto);
    }

    private RacingCarGameController(RacingCarRequestDto requestDto) {
        this.racingCars = RacingCars.from(requestDto.getAmountValue());
        this.racingRound = RacingRound.from(requestDto.getRoundValue());
    }

    public RacingCarResponseDto startRacing() {
        RacingCarResponseDto responseDto = createRacingCarResponseDto();
        while (racingRound.hasNext()) {
            responseDto.add(racingCars.move());
            racingRound.nextRound();
        }
        return responseDto;
    }

    private RacingCarResponseDto createRacingCarResponseDto() {
        return RacingCarResponseDto.newInstance();
    }


}
