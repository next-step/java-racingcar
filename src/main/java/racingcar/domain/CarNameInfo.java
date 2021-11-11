package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNameInfo {

    private static final int NAME_LENGTH_MAX = 5;
    private final String name;

    public CarNameInfo(String name){
        invalidNameCheck(name);
        this.name = name;
    }

    private void invalidNameCheck(String name) {
        if(name.isEmpty()) throw new IllegalArgumentException("차의 이름은 공백이 아니여야 합니다.");
        if(name.length() > NAME_LENGTH_MAX) throw new IllegalArgumentException("차의 이름의 최대 길이는 5입니다.");
    }

    public static List<CarNameInfo> createListFromInput(String[] carNames) {
        return Arrays.stream(carNames)
                .map(carName -> new CarNameInfo(carName))
                .collect(Collectors.toList());
    }

    public String get() {
        return name;
    }
}