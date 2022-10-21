package nextstep.javaracingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarRacingResultTest {

    @DisplayName("자동가 경주 결과에서 우승자를 찾을 수 있다.")
    @Test
    void spec01() {
        final CarDrivingResult jayden01 = new CarDrivingResult("j01", new Distance(10));
        final CarDrivingResult jayden02 = new CarDrivingResult("j02", new Distance(3));
        final List<CarDrivingResult> cars = List.of(jayden01, jayden02);
        final CarRacingResult racingResult = new CarRacingResult(cars);
        assertAll(
                () -> assertThat(racingResult.winners()).contains(jayden01),
                () -> assertThat(racingResult.winners()).doesNotContain(jayden02)
        );
    }

    @DisplayName("우승자는 여러명이 될 수 있다.")
    @Test
    void spec02() {
        final CarDrivingResult jayden01 = new CarDrivingResult("j01", new Distance(10));
        final CarDrivingResult jayden02 = new CarDrivingResult("j02", new Distance(10));
        final CarDrivingResult jayden03 = new CarDrivingResult("j03", new Distance(5));
        final CarDrivingResult jayden04 = new CarDrivingResult("j04", new Distance(3));
        final List<CarDrivingResult> cars = Arrays.asList(jayden01, jayden02, jayden03, jayden04);
        final CarRacingResult racingResult = new CarRacingResult(cars);
        final List<CarDrivingResult> winners = racingResult.winners();
        assertAll(
                () -> assertThat(winners).containsExactly(jayden01, jayden02),
                () -> assertThat(winners).doesNotContain(jayden03, jayden04)
        );
    }
}
