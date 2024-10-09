package racing.domain.dto;

public class CarDTO {
    private String name;
    private int position;

    public CarDTO(String name, int position) {
        this.name = name;
        this.position = position;

    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

}
