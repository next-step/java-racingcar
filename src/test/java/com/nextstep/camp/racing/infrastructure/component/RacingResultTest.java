package com.nextstep.camp.racing.infrastructure.component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.nextstep.camp.racing.infrastructure.view.ViewData;
import com.nextstep.camp.racing.infrastructure.view.component.RacingResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingResultTest {

    @ParameterizedTest
    @MethodSource("provideRaceScenarios")
    @DisplayName("RacingResult의 getDisplay()가 올바른 경기 결과를 출력하는지 테스트")
    void getDisplay_ShouldReturnCorrectRaceOutput(List<List<Boolean>> movesList, String expectedOutput) {
        // Given: 각 자동차의 ViewData 생성
        List<ViewData> carViewDataList = movesList.stream()
            .map(moves -> ViewData.of(Map.of("moves", moves)))
            .collect(Collectors.toList());

        // Given: 경기 ViewData 생성
        ViewData raceViewData = ViewData.of(Map.of("cars", carViewDataList));

        // When: RacingResult 생성
        RacingResult racingResult = RacingResult.create(raceViewData);

        // Then: 출력 결과 검증 (개행 포함)
        assertThat(racingResult.getDisplay()).isEqualTo(expectedOutput);
    }

    static Stream<Arguments> provideRaceScenarios() {
        return Stream.of(
            Arguments.of(
                List.of(
                    List.of(true, false, true, true, false),
                    List.of(false, true, false, true, true)
                ),
                "실행 결과\n" +
                    "-\n" +
                    "\n" +
                    "\n" +
                    "-\n" +
                    "-\n" +
                    "\n" +
                    "--\n" +
                    "-\n" +
                    "\n" +
                    "---\n" +
                    "--\n" +
                    "\n" +
                    "---\n" +
                    "---\n"
            ),
            Arguments.of(
                List.of(
                    List.of(true, true, false, false, true),
                    List.of(false, false, true, true, true)
                ),
                "실행 결과\n" +
                    "-\n" +
                    "\n" +
                    "\n" +
                    "--\n" +
                    "\n" +
                    "\n" +
                    "--\n" +
                    "-\n" +
                    "\n" +
                    "--\n" +
                    "--\n" +
                    "\n" +
                    "---\n" +
                    "---\n"
            )
        );
    }
}
