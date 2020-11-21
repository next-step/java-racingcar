package racingcar.dto.input;

import racingcar.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNames {

    private final String value;

    public CarNames(String carNames) {
        valid(carNames);
        this.value = carNames;
    }

    public List<String> split(String splitLetter) {
        return Arrays.stream(value.split(splitLetter)).collect(Collectors.toList());
    }

    private void valid(String carNames) {
        if (StringUtils.isBlank(carNames)) {
            throw new IllegalArgumentException("racing car name is wrong");
        }
    }
}
