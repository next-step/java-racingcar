package racing.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racing.domain.ReadOnlyCarProxy;
import racing.domain.ReadonlyCar;

public class RoundResult {

    private final List<ReadonlyCar> carList;

    public RoundResult(List<? extends ReadonlyCar> carList) {
        this.carList = carList.stream()
                              .map(ReadOnlyCarProxy::new)
                              .collect(Collectors.toList());
    }

    public List<ReadonlyCar> getCarList() {
        return new ArrayList<>(carList);
    }
}
