package step4.dto;

import java.util.List;

public class InputDto {
    private final List<String> carNameList;
    private final int tryCount;

    public InputDto(List<String> carNameList, int tryCount) {
        this.carNameList = carNameList;
        this.tryCount = tryCount;
    }

    public List<String> getCarNameList() {
        return carNameList;
    }

    public int getTryCount() {
        return tryCount;
    }
}
