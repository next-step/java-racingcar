package racing.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    public static final int MAX_NAME_LENGTH = 5;
    List<String> names;

    public Names(String[] names) throws IllegalAccessException {
        validate(names);
        this.names = Arrays.stream(names)
                .collect(Collectors.toList());
    }

    public int size() {
        return this.names.size();
    }

    public String name(int index) {
        if (names.size() <= index) {
            throw new ArrayIndexOutOfBoundsException("인덱스 범위를 벗어납니다.");
        }
        return names.get(index);
    }

    private void validate(String[] names) throws IllegalAccessException {
        for (String name : names) {
            validateName(name);
            validateBlank(name);
        }
    }

    private void validateBlank(String name) throws IllegalAccessException {
        if (name.isBlank()) {
            throw new IllegalAccessException("공백을 입력할 수 없습니다. 5자 이하의 이름을 콜론(,) 으로 구분지어 주세요.");
        }
    }

    private void validateName(String name) throws IllegalAccessException {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalAccessException("이름은 최대 5글자 입니다.");
        }
    }

}
