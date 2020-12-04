package com.nextstep.racinggame.view;

import com.nextstep.racinggame.view.exceptions.InvalidUserInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.nextstep.racinggame.domain.NameFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    @DisplayName("문자열을 인자로 받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        String userInput = "test1,test2,test3";

        assertThat(new InputView(userInput)).isNotNull();
    }

    @DisplayName("잘못된 문자열을 인자로 전달한 경우 예외 발생")
    @Test
    void createFailTest() {
        String emptyString = "";

        assertThatThrownBy(() -> new InputView(null)).isInstanceOf(InvalidUserInputException.class);
        assertThatThrownBy(() -> new InputView(emptyString)).isInstanceOf(InvalidUserInputException.class);
    }

    @DisplayName("Name 컬렉션으로 파싱 가능")
    @Test
    void parseToNamesTest() {
        String userInput = "test1,test2,test3";
        InputView inputView = new InputView(userInput);

        assertThat(inputView.parseToNames()).contains(TEST1);
        assertThat(inputView.parseToNames()).contains(TEST2);
        assertThat(inputView.parseToNames()).contains(TEST3);
    }
}
