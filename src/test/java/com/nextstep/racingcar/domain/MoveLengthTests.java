package com.nextstep.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveLengthTests {
    @DisplayName("최초 생성 시 0인 상태로 생성할 수 있어야 한다.(패키지 외부 사용 용도)")
    @Test
    void newMoveLengthTest() {
        assertThat(MoveLength.createZero().toInt()).isEqualTo(0);
    }
}
