package step5.dto;

import java.util.List;

/**
 * created by jg 2021/03/21
 */
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
