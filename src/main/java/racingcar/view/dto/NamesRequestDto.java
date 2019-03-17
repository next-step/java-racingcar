package racingcar.view.dto;

import java.util.Arrays;
import java.util.List;

public class NamesRequestDto {
    String names;

    public NamesRequestDto(String names) {
        this.names = names;
    }

    public List<String> toNameList() {
        return Arrays.asList(names.split(" "));
    }
}
