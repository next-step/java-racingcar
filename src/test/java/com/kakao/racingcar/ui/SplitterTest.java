package com.kakao.racingcar.ui;

import com.kakao.racingcar.util.Splitter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SplitterTest {

    @Test
    @DisplayName(",를 이용하여 유저의 이름을 구분한다.")
    void parse() {
        List<String> parse = Splitter.splitWithComma("jyami,minjeong,mj,mjung");
        assertThat(parse.size()).isEqualTo(4);
    }
}
