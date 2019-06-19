package step3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarNameList {

    private List<String> carNameList;

    public CarNameList(List<String> carNameList) {
        this.carNameList = carNameList;
    }

    public static CarNameList makeCarNameList(String[] carNameArray) {
        List<String> carNameList = new ArrayList<>(Arrays.asList(carNameArray));
        return new CarNameList(carNameList);
    }

    public List<String> getCarNameList() {
        return Collections.unmodifiableList(carNameList);
    }
}
