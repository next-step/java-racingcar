package com.nextstep.racinggame.domain;

import com.nextstep.racinggame.domain.exceptions.InvalidNamesException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NamesTest {
    @DisplayName("Name 컬렉션을 통해 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        assertThat(new Names(Arrays.asList(new Name("hi"), new Name("hello")))).isNotNull();
    }

    @DisplayName("빈 배열로 생성 시도 시 예외 발생")
    @Test
    void createFailTest() {
        assertThatThrownBy(() -> new Names(new ArrayList<>())).isInstanceOf(InvalidNamesException.class);
    }
}
