package step3.dto;

public class CarStatusDto {

    private String name;
    private int position;

    public CarStatusDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public CarStatusDto(int position) {
        this.position = position;
    }


    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
