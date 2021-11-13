package com.kakao.racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UserNameTest {

    @Test
    @DisplayName("입력받는 유저이름이 5자 이상이면 에러가 발생한다.")
    void name() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new UserName("helloWorld"));

    }
}
