package step4.domain.ipnut;

import utils.ListStringUtils;
import utils.StringUtils;

import java.util.List;
import java.util.Objects;


public final class InputNames {

    private final List<String> inputNames;

    public InputNames(String inputNames) {
        this(StringUtils.splitByCommaToList(inputNames));
    }

    public InputNames(List<String> inputNames) {
        if (ListStringUtils.isNullOrSizeZero(inputNames)) {
            throw new IllegalArgumentException("유효하지 않은 값을 사용했습니다.");
        }
        this.inputNames = inputNames;
    }

    public final List<String> inputNames() {
        return inputNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputNames that = (InputNames) o;
        return Objects.equals(inputNames, that.inputNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputNames);
    }

}
