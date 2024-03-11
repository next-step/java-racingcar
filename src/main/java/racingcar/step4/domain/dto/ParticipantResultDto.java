package racingcar.step4.domain.dto;

public class ParticipantResultDto {
    private final String name;
    private final int location;

    public ParticipantResultDto(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
