package com.cspark.nextstep.step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MotorRaceTest {

  private MotorRace motorRace;
  private final String[] names = {"pobi", "crong", "honux"};

  @BeforeEach
  void setUp() {
    this.motorRace = new MotorRace(names, 5);
  }

  @DisplayName("자동차명 수와 드라이버 수 비교")
  @Test
  void given3CarNames_whenGame_thenNumberOfDriversIsEqualsToNumberOfCar() {
    List<Driver> drivers = motorRace.game();

    assertThat(drivers.size())
        .as("입력된 자동차명과 드라이버 명수 비교")
        .isEqualTo(names.length);
  }

  @DisplayName("자동차명 수와 드라이버 수 비교")
  @Test
  void givenNumberOfRepeats_whenGame_thenRecordCountIsEqualsToNumberOfRepeats() {
    List<Driver> drivers = motorRace.game();

    drivers.stream()
        .map(d -> d.getRecords().size())
        .forEach(recordCount -> assertThat(recordCount)
            .as("입력된 이동 횟수와 이동한 이력 카운트와 비교")
            .isEqualTo(5));
  }

}