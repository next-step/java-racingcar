package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.RacingCarGameLogic;
import racingcar.RacingCarGameRule;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {
    private static final String TEST_CAR_NAMES = "pobi,crong,honux";

    @ParameterizedTest
    @DisplayName("4이상일 경우 전진하는 조건인지 테스트")
    @CsvSource({"3,false", "5,true", "8,true"})
    public void testIsMoving(int input, boolean output) {
        boolean isMoving = RacingCarGameRule.getInstance().isMovingForward(input);
        assertThat(isMoving).isEqualTo(output);
    }

    @Test
    @DisplayName("자동차 이름 초기화 확인 테스트")
    public void testSaveCarName() {
        String[] names = TEST_CAR_NAMES.split(",");
        List<Car> cars = RacingCarGameLogic.getInstance().initCars(TEST_CAR_NAMES);
        IntStream.range(0, names.length).forEach(i -> assertThat(cars.get(i).getName()).isEqualTo(names[i]));
    }

    @Test
    @DisplayName("3명인 경우 우승자 거리가 0인 경우 3명 공동 우승 확인 테스트")
    public void testGetZeroDistanceWinner() {
        List<Car> cars = Arrays.asList(new Car("test0", 0), new Car("test1", 0), new Car("test2", 0));
        List<Car> winners = RacingCarGameRule.getInstance().getWinnerCars(cars);
        assertThat(winners.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("3명인 경우 1명의 우승자 구하는 확인 테스트")
    public void testGetWinner() {
        List<Car> cars = IntStream.range(0, 3).mapToObj(index -> new Car("test" + index, index)).collect(Collectors.toList());
        List<Car> winners = RacingCarGameRule.getInstance().getWinnerCars(cars);
        assertThat(winners.get(0).getName()).isEqualTo("test2");
    }

    @Test
    @DisplayName("3명 중 2명이 같은 거리 간 경우 공동 우승자 확인 테스트")
    public void testGetSameDistanceWinner() {
        List<Car> cars = Arrays.asList(new Car("test0", 1), new Car("test1", 3), new Car("test2", 3));
        List<Car> winners = RacingCarGameRule.getInstance().getWinnerCars(cars);
        assertThat(winners.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("게임 로직 정상실행 통합 테스트")
    public void testGameLogic() {
        RacingCarGameLogic.getInstance().gameLogic(TEST_CAR_NAMES, 5);
    }

}
