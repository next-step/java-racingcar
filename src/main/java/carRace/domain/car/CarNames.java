package carRace.domain.car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNames {

    private final List<CarName> carNames;

    public CarNames(List<CarName> carNames) {
        this.carNames = carNames;
    }

    public CarNames(String[] carNames) {
         this.carNames = Arrays.stream(carNames)
                 .map(carName -> new CarName(carName))
                 .collect(Collectors.toList());
    }

    public boolean hasCarName(CarName carName){
        return carNames.contains(carName);

    }
    public List<CarName> getCarNames() {
        return carNames;
    }
}
