package com.nextstep.camp.racing.application.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.nextstep.camp.racing.domain.entity.Racing;

public class RacingResponse {

    private final List<LapResponse> laps;

    public RacingResponse(List<LapResponse> laps) {
        this.laps = laps;
    }

    public static RacingResponse of(Racing racing) {
        return new RacingResponse(racing.getLaps()
                .stream()
                .map(LapResponse::of)
                .collect(Collectors.toList()));
    }

    public static RacingResponse of(List<LapResponse> laps) {
        return new RacingResponse(laps);
    }

    public List<LapResponse> getLaps() {
        return laps;
    }
}
