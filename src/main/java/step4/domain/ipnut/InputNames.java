package step4.domain.ipnut;

import utils.StringUtils;

import java.util.List;

public class InputNames {

    private List<String> inputNames;

    public InputNames(String inputNames) {
        this(StringUtils.splitByCommaToList(inputNames));
    }

    public InputNames(List<String> inputNames) {
        if(StringListUtils.isNullAndBlank(inputNames)) {
            throw new IllegalArgumentException("유효하지 않은 값을 사용했습니다.");
        }
        this.inputNames = inputNames;
    }

}
