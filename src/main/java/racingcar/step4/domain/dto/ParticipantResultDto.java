package racingcar.step4.domain.dto;

import racingcar.step4.domain.Location;

public class ParticipantResultDto {
    private final String name;
    private final Location location;

    public ParticipantResultDto(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getCurrentLocation() {
        return location.currentLocation();
    }
}
