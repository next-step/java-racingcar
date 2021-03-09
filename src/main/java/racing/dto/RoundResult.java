package racing.dto;

import racing.car.ReadOnlyCarProxy;
import racing.car.ReadonlyCar;

import java.util.List;
import java.util.stream.Collectors;

public class RoundResult {

    private final List<ReadonlyCar> carList;

    public RoundResult(List<? extends ReadonlyCar> carList) {
        this.carList = carList.stream()
                              .map(ReadOnlyCarProxy::new)
                              .collect(Collectors.toList());
    }

    public List<ReadonlyCar> getCarList() {
        return carList;
    }
}
