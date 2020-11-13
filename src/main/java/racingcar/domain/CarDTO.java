package racingcar.domain;

public class CarDTO {
    private Name name;
    private int position;

    public CarDTO(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public CarDTO(Name name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name.getName();
    }

    public String getPosition() {
        StringBuilder sb = new StringBuilder();
        for (int index=0; index<this.position; index++) {
            sb.append('-');
        }
        return sb.toString();
    }
}
