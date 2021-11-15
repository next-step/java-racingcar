package study04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import study04.racing.car.Distance;
import study04.racing.car.Engine;
import study04.racing.car.RacingCar;
import study04.racing.RacingTrack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class RacingTrackTest {

    @Test
    @DisplayName("테스트01 - 레이싱 트랙 생성 테스트")
    void test01() {
        List<String> racingCarNames = Arrays.asList("Uzu", "Bada", "Taeyang");

        RacingTrack racingTrack = RacingTrack.createRacingTrack(racingCarNames);
        assertThat(racingTrack.toString()).isEqualTo("레이싱 트랙 - 현재 상태\n" +
                "[Uzu] 자동차 (주행거리:1)\n" +
                "[Bada] 자동차 (주행거리:1)\n" +
                "[Taeyang] 자동차 (주행거리:1)\n");
    }

    @Test
    @DisplayName("테스트02 - 레이싱 트랙 커스텀 생성 테스트")
    void test02() {
        List<String> racingCarNames = Arrays.asList("Uzu", "Bada", "Taeyang");
        List<Engine> engines = Arrays.asList(Engine.createEngine(), Engine.createEngine(), Engine.createEngine());
        List<Distance> distances = Arrays.asList(Distance.createDistance(), Distance.createDistance(3), Distance.createDistance(7));

        RacingTrack racingTrack = RacingTrack.createRacingTrack(racingCarNames, engines, distances);
        assertThat(racingTrack.toString()).isEqualTo("레이싱 트랙 - 현재 상태\n" +
                "[Uzu] 자동차 (주행거리:1)\n" +
                "[Bada] 자동차 (주행거리:3)\n" +
                "[Taeyang] 자동차 (주행거리:7)\n");
    }

    @Test
    @DisplayName("테스트03 - 자동차 트랙 주행 테스트")
    void test03() {
        List<String> racingCarNames = Arrays.asList("Uzu", "Bada", "Taeyang");
        List<Engine> engines = Arrays.asList(Engine.createEngine(), Engine.createEngine(), Engine.createEngine());
        List<Distance> distances = Arrays.asList(Distance.createDistance(), Distance.createDistance(), Distance.createDistance());
        RacingTrack racingTrack = RacingTrack.createRacingTrack(racingCarNames, engines, distances);

        int[] resultMoveDistance = new int[]{1,1,1};

        for (int i = 0; i < 100; i++) {
            racingTrack.run();

            for (int j = 0 ; j < 3 ; j++) {
                if (engines.get(j).isLastedRun()) {
                    resultMoveDistance[j]++;
                }
                assertThat(resultMoveDistance[j]).isEqualTo(racingTrack.getRacingCar(racingCarNames.get(j)).currentMoveDistance());
            }
        }

        for (int j = 0 ; j < 3 ; j++) {
            assertThat(resultMoveDistance[j]).isEqualTo(racingTrack.getRacingCar(racingCarNames.get(j)).currentMoveDistance());
        }
    }

    @Test
    @DisplayName("테스트04 - 우승자 판별 테스트")
    void test04() {
        List<String> racingCarNames = Arrays.asList("Uzu", "Bada", "Taeyang", "Hosu", "San");
        // 2번째랑 5번째가 항상 우승함
        List<Engine> engines = Arrays.asList(
                Engine.createEngine(10, 10),
                Engine.createEngine(10, 0),
                Engine.createEngine(10, 10),
                Engine.createEngine(10, 10),
                Engine.createEngine(10, 0));
        List<Distance> distances = Arrays.asList(Distance.createDistance(), Distance.createDistance(), Distance.createDistance(), Distance.createDistance(), Distance.createDistance());
        RacingTrack racingTrack = RacingTrack.createRacingTrack(racingCarNames, engines, distances);

        List<RacingCar> winnerOfRace = racingTrack.findWinnerOfRace();
        List<String> winnerCarNames = winnerOfRace.stream().map(RacingCar::getName).collect(Collectors.toList());
        assertThat(winnerCarNames).contains("Bada", "San");
    }
}
