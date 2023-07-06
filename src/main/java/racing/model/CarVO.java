package racing.model;

import java.util.Objects;

public class CarVO {
    private String name;
    private int position;

    public CarVO(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarVO carVO = (CarVO) o;
        return position == carVO.position && Objects.equals(name, carVO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
