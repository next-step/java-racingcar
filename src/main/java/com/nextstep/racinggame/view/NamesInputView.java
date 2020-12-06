package com.nextstep.racinggame.view;

import com.nextstep.racinggame.domain.Name;
import com.nextstep.racinggame.view.exceptions.InvalidUserInputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NamesInputView {
    private static final String SEPARATOR = ",";

    private final String userInput;

    NamesInputView(final String userInput) {
        validate(userInput);

        this.userInput = userInput;
    }

    List<Name> parseToNames() {
        return Arrays.stream(userInput.split(SEPARATOR))
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private void validate(final String userInput) {
        if (userInput == null) {
            throw new InvalidUserInputException("Null로 객체를 생성할 수 없습니다.");
        }

        if (userInput.isEmpty()) {
            throw new InvalidUserInputException("빈 문자열은 입력할 수 없습니다.");
        }
    }
}
