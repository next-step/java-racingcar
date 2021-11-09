package com.kakao.racingcar.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserNameInfoTest {

    @Test
    @DisplayName(",를 이용하여 유저의 이름을 구분한다.")
    void parse() {
        List<String> parse = UserNameInfo.parse("jyami,minjeong,mj,mjung");
        assertThat(parse.size()).isEqualTo(4);
    }
}
