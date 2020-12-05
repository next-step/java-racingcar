package com.nextstep.racinggame.view;

import com.nextstep.racinggame.domain.Name;
import com.nextstep.racinggame.domain.exceptions.InvalidNameException;
import com.nextstep.racinggame.view.exceptions.InvalidUserInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NamesInputViewTest {
    @DisplayName("문자열을 인자로 받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        String userInput = "test1,test2,test3";

        assertThat(new NamesInputView(userInput)).isNotNull();
    }

    @DisplayName("잘못된 문자열을 인자로 전달한 경우 예외 발생")
    @Test
    void createFailTest() {
        String emptyString = "";

        assertThatThrownBy(() -> new NamesInputView(null)).isInstanceOf(InvalidUserInputException.class);
        assertThatThrownBy(() -> new NamesInputView(emptyString)).isInstanceOf(InvalidUserInputException.class);
    }

    @DisplayName("Name 컬렉션으로 파싱 가능")
    @Test
    void parseToNamesTest() {
        String name1 = "test1";
        String name2 = "test2";
        String name3 = "test3";
        String userInput = name1 + "," + name2 + "," + name3;

        NamesInputView namesInputView = new NamesInputView(userInput);

        assertThat(namesInputView.parseToNames()).contains(new Name(name1));
        assertThat(namesInputView.parseToNames()).contains(new Name(name2));
        assertThat(namesInputView.parseToNames()).contains(new Name(name3));
    }

    @DisplayName("적합하지 않은 이름이 포함된 채로 객체 생성 시도 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"test1 ,test2,test3 ", ",test2,test3"})
    void parseToNamesFailTest(String invalidValue) {
        NamesInputView namesInputView = new NamesInputView(invalidValue);

        assertThatThrownBy(namesInputView::parseToNames).isInstanceOf(InvalidNameException.class);
    }
}
