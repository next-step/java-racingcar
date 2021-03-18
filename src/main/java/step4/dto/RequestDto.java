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
        if (isInputNamesOrInputRoundNull(inputNames, inputRound)) {
            throw new IllegalArgumentException("유효하지 않은 값을 사용했습니다.");
        }
        this.inputNames = inputNames;
        this.inputRound = inputRound;
    }

    private final boolean isInputNamesOrInputRoundNull(InputNames inputNames, InputRound inputRound) {
        return (isInputNamesNull(inputNames) || isInputRoundNull(inputRound));
    }

    private final boolean isInputNamesNull(InputNames inputNames) {
        return inputNames == null;
    }

    private final boolean isInputRoundNull(InputRound inputRound) {
        return inputRound == null;
    }

    public final InputNames inputNames() {
        return inputNames;
    }

    public final InputRound inputRound() {
        return inputRound;
    }
}
