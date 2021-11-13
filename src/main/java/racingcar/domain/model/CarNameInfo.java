package racingcar.domain.model;

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
        checkDuplicateName(carNames);
        return Arrays.stream(carNames)
                .map(carName -> new CarNameInfo(carName))
                .collect(Collectors.toList());
    }

    private static void checkDuplicateName(String[] carNames) {
        if(Arrays.stream(carNames).distinct().count() != carNames.length) {
            throw new IllegalArgumentException("이름이 중복된 차가 있습니다.");
        }
    }

    public String get() {
        return name;
    }
}