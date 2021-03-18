package step4.dto;

import step4.domain.ipnut.InputNames;
import step4.domain.ipnut.InputRound;

public final class RequestDto {

    private final InputNames inputNames;
    private final InputRound inputRound;

    public RequestDto(InputNames inputNames, InputRound inputRound) {
        this.inputNames = inputNames;
        this.inputRound = inputRound;
    }

}
