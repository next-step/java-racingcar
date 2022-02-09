package racinggame.dto;

import racinggame.domain.Car;

public class RacingDTO {

    private String name;
    private int location;

    public RacingDTO(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public static RacingDTO from(Car car) {
        return new RacingDTO(car.getName(), car.getLocation());
    }
}
