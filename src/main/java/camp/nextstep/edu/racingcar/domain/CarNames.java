package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.util.AssertUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    // TODO: toString
    // TODO: equal
    // TODO: hashcode
}
