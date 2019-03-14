package racingcar.view.dto;

import java.util.List;

public class ResultResponseDto {
    String namesOfWinners;

    public ResultResponseDto(List<String> names) {
        this.namesOfWinners = String.join(", ", names);
    }

    public String getNamesOfWinners() {
        return namesOfWinners;
    }
}
