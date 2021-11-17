package com.sryoondev.racingcar.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CircuitTest {
    @Test
    @DisplayName("사용자가 입력한 자동차 이름 수와 자동차 수가 일치한지 테스트")
    public void testGetCarCount() {
        String[] names = new String[]{ "pobi", "crong", "honux" };
        Circuit circuit = new Circuit(names);
        assertThat(circuit.getCarCount()).isEqualTo(3);
    }
}
