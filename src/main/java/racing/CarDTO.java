package racing;

import java.util.Objects;

public class CarDTO {

    private final String name;
    private final Integer position;

    public CarDTO(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarDTO carDTO = (CarDTO) o;
        return Objects.equals(name, carDTO.name) && Objects.equals(position,
            carDTO.position);
    }

}
