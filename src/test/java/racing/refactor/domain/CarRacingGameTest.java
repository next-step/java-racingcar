package racing.refactor.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("자동차 게임 도메인 테스트(자동차 A, B, C)")
class CarRacingGameTest {

    private CarRacingGame carRacingGame;

    @BeforeEach
    void setUp() {
        List<Car> cars = Arrays.asList(
                 new Car("A")
                ,new Car("B")
                ,new Car("C")
        );
        carRacingGame = new CarRacingGame(cars);
    }

    @Test
    @DisplayName("전진 판단 랜덤 값이 모두 4 일 경우, 모든 자동차 전진")
    public void workCar() {
        List<Integer> desiredResult = Arrays.asList(1, 1, 1);
        List<Integer> diceNumbers = Arrays.asList(4, 4, 4);

        List<Car> resultTrack = carRacingGame.nextRound(diceNumbers);
        List<Integer> distances = resultTrack.stream()
                .map(Car::getDrivingDistance)
                .collect(Collectors.toList());

        assertEquals(desiredResult, distances);
    }

    @Test
    @DisplayName("전진 판단 랜덤 값이 모두 3 일 경우, 모든 자동차 정지")
    public void stopCar() {
        List<Integer> desiredResult = Arrays.asList(0, 0, 0);
        List<Integer> diceNumbers = Arrays.asList(3, 3, 3);

        List<Car> resultTrack = carRacingGame.nextRound(diceNumbers);
        List<Integer> distances = resultTrack.stream()
                .map(Car::getDrivingDistance)
                .collect(Collectors.toList());

        assertEquals(desiredResult, distances);
    }

    @Test
    @DisplayName("{4, 3, 9} 값 입력 시, 결과값 {1, 0, 1} 리턴")
    public void workAndStopCar() {
        List<Integer> desiredResult = Arrays.asList(1, 0, 1);
        List<Integer> diceNumbers = Arrays.asList(4, 3, 9);

        List<Car> resultTrack = carRacingGame.nextRound(diceNumbers);
        List<Integer> distances = resultTrack.stream()
                .map(Car::getDrivingDistance)
                .collect(Collectors.toList());

        assertEquals(desiredResult, distances);
    }

    @Test
    @DisplayName("{4, 3, 2} 값을 두번 입력 시, 우승자 A 출력")
    public void normalWinner() {
        List<String> desiredWinnerNames = Collections.singletonList("A");
        List<Integer> diceNumbers = Arrays.asList(4, 3, 2);

        carRacingGame.nextRound(diceNumbers);
        carRacingGame.nextRound(diceNumbers);

        List<Car> resultWinners = carRacingGame.getWinners();
        List<String> resultWinnerNames = resultWinners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        assertEquals(desiredWinnerNames, resultWinnerNames);
    }

    @Test
    @DisplayName("{4, 3, 9} 값을 두번 입력 시, 우승자 A, C 출력")
    public void normalWinners() {
        List<String> desiredWinnerNames = Arrays.asList("A", "C");
        List<Integer> diceNumbers = Arrays.asList(4, 3, 9);

        carRacingGame.nextRound(diceNumbers);
        carRacingGame.nextRound(diceNumbers);

        List<Car> resultWinners = carRacingGame.getWinners();
        List<String> resultWinnerNames = resultWinners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        assertEquals(desiredWinnerNames, resultWinnerNames);
    }

    @Test
    @DisplayName("{4, 4, 4} 값을 두번 입력 시, 우승자 A, B, C 출력")
    public void allWinners() {
        List<String> desiredWinnerNames = Arrays.asList("A", "B", "C");
        List<Integer> diceNumbers = Arrays.asList(4, 4, 4);

        carRacingGame.nextRound(diceNumbers);
        carRacingGame.nextRound(diceNumbers);

        List<Car> resultWinners = carRacingGame.getWinners();
        List<String> resultWinnerNames = resultWinners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        assertEquals(desiredWinnerNames, resultWinnerNames);
    }
}