package step4.dto;

import step4.domain.ipnut.InputNames;
import step4.domain.ipnut.InputRound;
import utils.StringUtils;

import java.util.List;

public final class RequestDto {

    private final InputNames inputNames;
    private final InputRound inputRound;

    public RequestDto(String inputNames, int round) {
        this(new InputNames(StringUtils.splitByCommaToList(inputNames)), new InputRound(round));
    }

    public RequestDto(List<String> inputNames, int round) {
        this(new InputNames(inputNames), new InputRound(round));
    }

    public RequestDto(InputNames inputNames, InputRound inputRound) {
        this.inputNames = inputNames;
        this.inputRound = inputRound;
    }

}
