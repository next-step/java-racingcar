package com.cspark.nextstep.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MotorRaceTest {

    private MotorRace motorRace;
    private String[] names = {"pobi", "crong", "honux"};


    @BeforeEach
    void setUp() {
        this.motorRace = new MotorRace(names, 5);
    }

    @DisplayName("자동차 게임")
    @Test
    void game() {
        this.motorRace.game();
    }
}