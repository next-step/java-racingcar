package racing.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    private RacingGame racingGame;


    List<RacingCar> init() {
        racingGame = new RacingGame();
        String participationList = "SingSing,Boom,SM3";
        return racingGame.setUp(participationList);
    }

    @DisplayName("레이싱 게임 초기화 테스트")
    @Test
    void setUp() {
        List<RacingCar> racingCar = init();

        //then
        assertEquals(3, racingCar.size());
        assertEquals("SingSing", racingCar.get(0).getRacingCarName());
        assertEquals(2L, racingCar.get(1).getRacingCarId());
        assertThat(racingCar).allSatisfy(car -> assertEquals(0, car.getPosition()));
    }

    @DisplayName("랜덤값이 자동차 갯수 만큼 생성되는지 테스트")
    @Test
    void createRandomValue() {
        //given
        List<RacingCar> racingCar = init();

        //when
        List<Integer> randomValue = racingGame.createRandomValue();

        //then
        assertEquals(3, randomValue.size());
    }


    @DisplayName("이동거리가 4이상일때 자동차 이동 테스트")
    @Test
    void move() {
        //given
        List<RacingCar> racingCar = init();
        List<Integer> randomValue = createMoveValue(5, 7, 8);

        //when
        racingGame.moveAndStop(randomValue);

        //then
        assertEquals(5,
                racingCar.stream()
                        .filter(car -> "SingSing".equals(car.getRacingCarName()))
                        .map(RacingCar::getPosition)
                        .collect(toList()).get(0));
        assertEquals(7,
                racingCar.stream()
                        .filter(car -> 2L == car.getRacingCarId())
                        .map(RacingCar::getPosition)
                        .collect(toList()).get(0));
        assertEquals(8, racingCar.get(2).getPosition());
    }

    @DisplayName("이동거리가 4미만일때 자동차 정지 테스트")
    @Test
    void stop() {
        //given
        List<RacingCar> racingCar = init();
        List<Integer> randomValue = createMoveValue(2, 3, 1);

        //when
        racingGame.moveAndStop(randomValue);

        //then
        assertThat(racingCar).allSatisfy(car -> assertEquals(car.getPosition(), 0));
    }

    @DisplayName("우승자 가리는 메서드 테스트")
    @Test
    void setWinner() {
        //given
        init();
        List<Integer> moveValue = createMoveValue(3, 5, 2);
        List<RacingCar> racingCars = racingGame.moveAndStop(moveValue);

        //when
        List<RacingCar> winner = racingGame.setWinner();

        //then
        assertEquals(2L, winner.get(0).getRacingCarId());
    }

    @DisplayName("공동 우승일 경우 테스트")
    @Test
    void setCoWinner() {
        //given
        init();
        List<Integer> moveValue = createMoveValue(5, 5, 2);
        List<RacingCar> racingCars = racingGame.moveAndStop(moveValue);

        //when
        List<RacingCar> winner = racingGame.setWinner();

        //then
        assertEquals(2, winner.size());
        assertEquals(1L, winner.get(0).getRacingCarId());
        assertEquals(2L, winner.get(1).getRacingCarId());
    }


    private List<Integer> createMoveValue(int firstCarMovePosition, int secondCarMovePosition,
                                          int thirdCarMovePosition) {
        return List.of(firstCarMovePosition, secondCarMovePosition, thirdCarMovePosition);
    }


}