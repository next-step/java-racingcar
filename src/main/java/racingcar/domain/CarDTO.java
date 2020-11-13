package racingcar.domain;

public class CarDTO {
    private String name;
    private int position;

    public CarDTO(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        StringBuilder sb = new StringBuilder();
        for (int index=0; index<position; index++) {
            sb.append('-');
        }
        return sb.toString();
    }
}
