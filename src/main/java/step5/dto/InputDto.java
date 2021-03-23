package step5.dto;

import step5.domain.InputValidator;

import java.util.List;

public class InputDto {
    private final List<String> carNameList;
    private final int tryCount;

    // 무조건 이렇게 해야 한다라는 정답이 있는건 아니겠지만,, 제가 아래와 같이 한 방법이 깔끔해보이지는 않은 느낌입니다 ㅠㅠ
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
