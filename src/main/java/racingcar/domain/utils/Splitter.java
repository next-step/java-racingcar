package racingcar.domain.utils;

import java.util.Arrays;
import java.util.Objects;

public class Splitter {

    private String[] names;

    public Splitter() {
    }

    public String[] splitNames(String nameList) {
        if (isBlack(nameList)) {
            throw new IllegalArgumentException(String.format("입력 데이터가 올바르지 않습니다. : [%s] ", nameList));
        }

        split(nameList);

        if (!isValidateName()) {
            throw new IllegalArgumentException(String.format("Name은 5글자를 초과할 수 없습니다. : [%s] ", nameList));
        }
        return this.names;
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
        return name.length() <= Number.NAME_MAX_LENGTH;
    }

}
