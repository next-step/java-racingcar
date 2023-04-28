package racing.domain;

import calculate.StringAddCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racing.controller.RacingController.winners;

public class CarTest {

    @Test
    @DisplayName("0~8 랜덤 int 생성 ")
    void randomInt() {

        GameRule gameRule = new RandomGameRule();
        int randomNumber = gameRule.getPossibleInt();
        assertThat(randomNumber).isLessThan(9);
    }

    @Test
    @DisplayName("입력 값 만큼 이동 가능")
    void move() {

        Car initialCar = new Car(0, "a");
        Car movedResultCar = new Car(5, "b");

        Car movedCar = initialCar.move(5);

        assertThat(movedCar.location()).isEqualTo(movedResultCar.location());
    }

    @Test
    @DisplayName("이름 유효성 검사")
    void nameValidation() {

        Car car = new Car(0);
        assertThatThrownBy(() -> car.nameValidation("hellooo"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(car.nameValidation("std")).isEqualTo("std");
    }

}
