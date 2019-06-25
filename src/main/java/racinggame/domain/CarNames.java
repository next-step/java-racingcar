package racinggame.domain;

import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarNames {
    private final List<String> carNameList;

    public CarNames(String carNameString) {
        List<String> carNameList = Arrays.asList(carNameString.split(","));

        Preconditions.checkArgument(!carNameList.contains(""), "자동차 이름은 빈값이 될 수 없습니다.");

        this.carNameList = carNameList;
    }

    public List<String> getCarNameList() {
        return Collections.unmodifiableList(carNameList);
    }

    public int getSize() {
        return carNameList.size();
    }
}
