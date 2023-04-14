package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.*;


import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @Test
    @DisplayName("0~9사이 정수랜덤생성기")
    public void checkRandomNumber_ReturnPositiveNumberUnderNine() {
        RandomNumber randomNumber = new RandomNumber();
        int result = randomNumber.calculateRandomNumber();

        assertThat(result)
            .isGreaterThanOrEqualTo(0)
            .isLessThanOrEqualTo(9);
    }

    @Test
    @DisplayName("자동차 객체 생성 후 position = 0인지 확인")
    public void createRacingCar() {
        RacingCar racingCar = new RacingCar();
        int result = racingCar.position();

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이동")
    public void checkRacingCarMove_ReturnNumber() {
        RacingCar racingCar = new RacingCar();
//        racingCar.moveForward(RandomNumber.calculateRandomNumber());
//        racingCar.moveForward(RandomNumber.calculateRandomNumber());
//        racingCar.moveForward(RandomNumber.calculateRandomNumber());
//        racingCar.moveForward(RandomNumber.calculateRandomNumber());
        int result = racingCar.position();

        assertThat(result).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("자동차 객체 여러개 생성 후 자동차객체 carNumber비교")
    public void checkRacingCarsObject() {
        RacingCars racingCars = new RacingCars(5);

        assertThat(racingCars.getRacingCars()).hasSize(5);
    }

    @Test
    @DisplayName("5대 자동차, 4번 움직임 시도(postion max값 == 4)인 racing 확인")
    public void checkRacingClass() {
        Racing racing = new Racing(new RacingCars(5), 4);
        racing.startRacing();
        RacingCars resultRacing = racing.getRacing();

        assertThat(resultRacing.getRacingCars()).hasSize(5);
        assertThat(resultRacing.getRacingCar(1).position())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(4);

//        System.out.println("carNumber: " + resultRacing.getRacingCar(0).getNumber() + " position: " + resultRacing.getRacingCar(0).getPosition());
//        System.out.println("carNumber: " + resultRacing.getRacingCar(1).getNumber() + " position: " + resultRacing.getRacingCar(1).getPosition());
//        System.out.println("carNumber: " + resultRacing.getRacingCar(2).getNumber() + " position: " + resultRacing.getRacingCar(2).getPosition());
//        System.out.println("carNumber: " + resultRacing.getRacingCar(3).getNumber() + " position: " + resultRacing.getRacingCar(3).getPosition());
//        System.out.println("carNumber: " + resultRacing.getRacingCar(4).getNumber() + " position: " + resultRacing.getRacingCar(4).getPosition());
    }

}
