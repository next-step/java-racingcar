package com.nextstep.camp.racing.application.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.nextstep.camp.racing.domain.entity.Racing;

public class RacingResponse {

    private final List<LapResponse> laps;
    private final List<CarResponse> winners;

    public RacingResponse(List<LapResponse> laps, List<CarResponse> winners) {
        this.laps = laps;
        this.winners = winners;
    }

    public static RacingResponse of(Racing racing) {
        List<CarResponse> cars = racing.getWinners()
                .stream()
                .map(CarResponse::of)
                .collect(Collectors.toList());
        return new RacingResponse(racing.getLaps()
                .stream()
                .map(LapResponse::of)
                .collect(Collectors.toList()), cars);
    }

    public static RacingResponse of(List<LapResponse> laps, List<CarResponse> winners) {
        return new RacingResponse(laps, winners);
    }

    public List<LapResponse> getLaps() {
        return laps;
    }

    public List<CarResponse> getWinners() {
        return winners;
    }
}
