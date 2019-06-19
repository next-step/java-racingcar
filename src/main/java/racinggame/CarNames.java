package racinggame;

import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.List;

public class CarNames {
    private List<String> carNameList;

    public CarNames(String carNameString) {
        String[] carNameArray = carNameString.split(",");
        List<String> carNameList = Arrays.asList(carNameArray);

        Preconditions.checkArgument(!carNameList.contains(""), "자동차 이름은 빈값이 될 수 없습니다.");

        this.carNameList = carNameList;
    }

    public List<String> getCarNameList() {
        return carNameList;
    }
}
