package racingcar.domain.util;

import java.util.Arrays;
import java.util.Objects;

public class Splitter {

    private final int NAME_MAX_LENGTH = 5;
    private String[] names;

    public Splitter(String nameList) {
        if (isBlack(nameList)) {
            throw new IllegalArgumentException(String.format("입력 데이터가 올바르지 않습니다. : [%s] ", nameList));
        }

        split(nameList);

        if (!isValidateName()) {
            throw new IllegalArgumentException(String.format("Name은 5글자를 초과할 수 없습니다. : [%s] ", nameList));
        }
    }

    private void split(String nameList) {
        this.names = nameList.split(",");
    }

    private boolean isBlack(String nameList) {
        return Objects.isNull(nameList) || nameList.trim().isEmpty();
    }

    private boolean isValidateName() {
        return Arrays.stream(this.names)
                .allMatch(name -> isLong(name));
    }

    private boolean isLong(String name) {
        return name.length() <= NAME_MAX_LENGTH;
    }
    public String[] getResult() {
        return this.names;
    }
}
