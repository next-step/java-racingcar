package com.nextstep.racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MoveResultTests {
    @DisplayName("int 컬렉션을 인자로 받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        List<Integer> values = Arrays.asList(1, 2, 3);

        assertThat(new MoveResult(values)).isNotNull();
    }
}