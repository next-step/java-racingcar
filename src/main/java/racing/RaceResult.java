package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RaceResult {
    private final List<Integer> carLocations;

    public RaceResult() {
        this.carLocations = new ArrayList<>();
    }

    public RaceResult(List<Integer> carLocations) {
        this.carLocations = carLocations;
    }

    public void addCarLocation(final int location){
        carLocations.add(location);
    }

    public List<Integer> carLocations(){
        return carLocations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RaceResult result = (RaceResult) o;
        return Objects.equals(carLocations, result.carLocations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carLocations);
    }
}
