package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.util.AssertUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class CarNames {

    private final List<String> carNameList;

    private CarNames(List<String> carNameList) {
        AssertUtils.notNull(carNameList, "'carNameList' must not be null");
        this.carNameList = new ArrayList<>(carNameList);
    }

    public static CarNames from(List<String> carNameList) {
        return new CarNames(carNameList);
    }

    public static CarNames emptyInstance() {
        final List<String> emptyList = Collections.emptyList();
        return new CarNames(emptyList);
    }

    public int size() {
        return carNameList.size();
    }

    public Stream<String> stream() {
        return carNameList.stream();
    }

    @Override
    public String toString() {
        return "CarNames{" +
                "carNameList=" + carNameList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarNames carNames = (CarNames) o;
        return carNameList.equals(carNames.carNameList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNameList);
    }
}
