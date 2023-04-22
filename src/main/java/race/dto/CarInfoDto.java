package race.dto;

public class CarInfoDto {
    private final int location;
    private final String name;

    public CarInfoDto(int location, String name) {
        this.location = location;
        this.name = name;
    }

    public int location() {
        return this.location;
    }

    public String name() {
        return this.name;
    }
}
