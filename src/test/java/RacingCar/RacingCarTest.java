package RacingCar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    private static Car car;

    @BeforeEach
    @DisplayName("자동차 인스턴스 생성")
    static void car() {
        car = new Car(1, 0);
    }

    @Test
    @DisplayName("자동차 이동 테스트")
    void move() {
        car.move();
        assertThat(car.getPosition()).isBetween(0, 1);
    }
}
