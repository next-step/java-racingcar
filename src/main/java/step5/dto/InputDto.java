package step5.dto;

import step5.domain.InputValidator;

import java.util.List;

public class InputDto {
    private final List<String> carNameList;
    private final int tryCount;

    public InputDto(List<String> carNameList, int tryCount) {
        InputValidator.checkCarName(carNameList);
        this.carNameList = carNameList;
        InputValidator.checkTryCountIsMinus(tryCount);
        this.tryCount = tryCount;
    }

    public List<String> getCarNameList() {
        return carNameList;
    }

    public int getTryCount() {
        return tryCount;
    }
}
