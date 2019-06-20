package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.util.AssertUtils;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CarNames implements Iterable<CarName> {

    private final List<CarName> carNameList;

    private CarNames(List<CarName> carNameList) {
        AssertUtils.notNull(carNameList, "'carNameList' must not be null");
        this.carNameList = new ArrayList<>(carNameList);
    }

    public static CarNames from(List<CarName> carNameList) {
        return new CarNames(carNameList);
    }

    public static CarNames emptyInstance() {
        final List<CarName> emptyList = Collections.emptyList();
        return new CarNames(emptyList);
    }

    public Stream<CarName> stream() {
        return carNameList.stream();
    }

    @Override
    public Iterator<CarName> iterator() {
        return carNameList.iterator();
    }

    @Override
    public void forEach(Consumer<? super CarName> action) {
        carNameList.forEach(action);
    }

    @Override
    public Spliterator<CarName> spliterator() {
        return carNameList.spliterator();
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
