package step3.view.dto;

public class CarDTO {
    private final String name;
    private final int location;

    public CarDTO(final String name, final int location) {
        this.name = name;
        this.location = location;
    }

    public int getLocation() {
        return location;
    }
}
