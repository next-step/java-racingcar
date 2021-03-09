package racing.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    private RacingGame racingGame;


    List<RacingCar> init() {
        String[] participationList = "SingS,Boom,SM3".split(",");
        racingGame = new RacingGame(participationList);
        return racingGame.getCarList();
    }

    @DisplayName("레이싱 게임 초기화 테스트")
    @Test
    void setUp() {
        List<RacingCar> racingCar = init();

        //then
        assertEquals(3, racingCar.size());
        assertEquals("SingS", racingCar.get(0).getRacingCarName());
    }

    @DisplayName("랜덤값이 자동차 갯수 만큼 생성되는지 테스트")
    @Test
    void createRandomValue() {
        //given
        init();

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
        assertThat(racingCar).allSatisfy(car -> assertThat(car.getPosition()).isEqualTo(1));
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
        assertThat(racingCar).allSatisfy(car -> assertThat(car.getPosition()).isEqualTo(0));
    }

    @DisplayName("우승자 가리는 메서드 테스트")
    @Test
    void setWinner() {
        //given
        init();
        List<Integer> moveValue = createMoveValue(3, 5, 2);
        racingGame.moveAndStop(moveValue);

        //when
        List<String> winner = racingGame.setWinner();

        //then
        assertEquals("Boom", winner.get(0));
    }

    @DisplayName("공동 우승일 경우 테스트")
    @Test
    void setCoWinner() {
        //given
        init();
        List<Integer> moveValue = createMoveValue(5, 5, 2);
        racingGame.moveAndStop(moveValue);

        //when
        List<String> winner = racingGame.setWinner();

        //then
        assertEquals(2, winner.size());
        assertEquals("SingS", winner.get(0));
        assertEquals("Boom", winner.get(1));
    }


    private List<Integer> createMoveValue(int firstCarMovePosition, int secondCarMovePosition,
                                          int thirdCarMovePosition) {
        return List.of(firstCarMovePosition, secondCarMovePosition, thirdCarMovePosition);
    }


}