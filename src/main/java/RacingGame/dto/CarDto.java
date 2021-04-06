package RacingGame.dto;

public class CarDto {
    private String name;
    private int location;

    public CarDto(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public String getName(){
        return name;
    }
}
