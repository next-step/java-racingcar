package racing.refactor.dto;

import java.util.Objects;

public class ResponseCar {

    private String name;
    private int distanceDriven;

    public ResponseCar(String name, int distanceDriven) {
        this.name = name;
        this.distanceDriven = distanceDriven;
    }

    public String getName() {
        return this.name;
    }

    public int getDistanceDriven() {
        return this.distanceDriven;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof ResponseCar)) return false;
        ResponseCar that=(ResponseCar) o;
        return distanceDriven == that.distanceDriven && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distanceDriven);
    }
}
