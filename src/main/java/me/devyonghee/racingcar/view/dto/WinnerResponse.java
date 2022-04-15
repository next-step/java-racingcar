package me.devyonghee.racingcar.view.dto;

import me.devyonghee.racingcar.model.CarName;
import me.devyonghee.racingcar.model.RacingCar;
import me.devyonghee.racingcar.model.Track;
import me.devyonghee.racingcar.model.Tracks;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerResponse {

    private final List<String> names;

    private WinnerResponse(List<String> names) {
        this.names = names;
    }

    public static WinnerResponse from(Tracks tracks) {
        return new WinnerResponse(tracks.list()
                .stream()
                .map(Track::car)
                .map(RacingCar::name)
                .map(CarName::value)
                .collect(Collectors.toList()));
    }

    public List<String> getNames() {
        return names;
    }
}
