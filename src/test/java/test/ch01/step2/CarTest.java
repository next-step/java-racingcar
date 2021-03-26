package test.ch01.step2;


import ch01.racinggame.domain.Car;

import ch01.racinggame.domain.RandomNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;
    private RandomNumber randomNumber;

    @BeforeEach
    void setUp() {
        car = new Car("Test");
        randomNumber = new RandomNumber() {
            @Override
            public boolean movable() {
                return true;
            }
        };
    }


    @Test
    @DisplayName("진행막대를 보여주는 막대기")
    void showProgress() {
        //then
        assertThat(car.toString().equals("-")).isTrue();
    }

    @Test
    void showProgressCnt() {
        //given
        car.move(randomNumber);
        //when
        int progressCnt = car.progressCnt();
        //then
        assertThat(progressCnt).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차가 움직였는지 테스트 ")
    void movable() {
        //when
        car.move(randomNumber);
        //then
        assertThat(car.progressCnt()).isEqualTo(2);

    }

    @Test
    @DisplayName("자동차가 안움직였는지 테스트")
    void notMovable() {
        //given
        RandomNumber randomNumberTest = new RandomNumber() {
            @Override
            public boolean movable() {
                return false;
            }
        };

        //when
        car.move(randomNumberTest);
        //then
        assertThat(car.progressCnt()).isEqualTo(1);

    }
}