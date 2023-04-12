package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.*;


import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @Test
    @DisplayName("랜덤 함수 확인")
    public void checkRandomNumber_ReturnPositiveNumberUnderNine() {
        int result = RandomNumber.calculateRandomNumber();

        assertThat(result)
            .isGreaterThanOrEqualTo(0)
            .isLessThanOrEqualTo(9);
    }

    @Test
    @DisplayName("자동차 이동")
    public void checkRacingCarMove_ReturnNumber() {
        RacingCar racingCar = new RacingCar("0");
        racingCar.moveForward(RandomNumber.calculateRandomNumber());
        racingCar.moveForward(RandomNumber.calculateRandomNumber());
        racingCar.moveForward(RandomNumber.calculateRandomNumber());
        racingCar.moveForward(RandomNumber.calculateRandomNumber());
        int result = racingCar.getPosition();

        assertThat(result).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("자동차 객체 여러개 생성 후 자동차객체 carNumber비교")
    public void checkRacingCarsObject() {
        RacingCars racingCars = new RacingCars(5);

        assertThat(racingCars.getRacingCars()).hasSize(5);
        assertThat(racingCars.getRacingCars()[4].getNumber()).isEqualTo("4");
        assertThat(racingCars.getRacingCar(2).getNumber()).isEqualTo("2");
    }

    @Test
    @DisplayName("5대 자동차, 4번 움직임 시도(postion max값 == 4)인 racing 확인")
    public void checkRacingClass() {
        Racing racing = new Racing(new RacingCars(5), 4);
        racing.startRacing();
        RacingCars resultRacing = racing.getRacing();

        assertThat(resultRacing.getRacingCars()).hasSize(5);
        assertThat(resultRacing.getRacingCar(1).getPosition())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(4);

//        System.out.println("carNumber: " + resultRacing.getRacingCar(0).getNumber() + " position: " + resultRacing.getRacingCar(0).getPosition());
//        System.out.println("carNumber: " + resultRacing.getRacingCar(1).getNumber() + " position: " + resultRacing.getRacingCar(1).getPosition());
//        System.out.println("carNumber: " + resultRacing.getRacingCar(2).getNumber() + " position: " + resultRacing.getRacingCar(2).getPosition());
//        System.out.println("carNumber: " + resultRacing.getRacingCar(3).getNumber() + " position: " + resultRacing.getRacingCar(3).getPosition());
//        System.out.println("carNumber: " + resultRacing.getRacingCar(4).getNumber() + " position: " + resultRacing.getRacingCar(4).getPosition());
    }

}
