package step3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    @DisplayName("4이상의 값을 얻으면 차는 한칸씩 전진한다.")
    void random값을_4이상을_얻은_차는_그대로_있는다(int inputValue) {

        Car 자동차_4이상을_얻은 = new Car(new CarMoving());

        System.out.println("inputValue=" + inputValue);
        자동차_4이상을_얻은.move(inputValue);

        assertThat(자동차_4이상을_얻은.getMoving().getMovingDistance()).isEqualTo(1);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("4미만을 얻은 차는 그대로 있는다.")
    void random값을_4미만을_얻은_차는_그대로_있는다(int inputValue) {

        Car 자동차_4이상을_얻은 = new Car(new CarMoving());

        System.out.println("inputValue=" + inputValue);
        자동차_4이상을_얻은.move(inputValue);

        assertThat(자동차_4이상을_얻은.getMoving().getMovingDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("기존에 한칸 이동한 차량은 4이상의 값을 얻으면 한칸 더 이동한다. ")
    void 기존에_전진한_차량은_4이상의_값을_얻으면_한칸_더_이동한다() {
        Car 한칸_움직인_차 = new Car(new CarMoving(1));

        한칸_움직인_차.move(4);
        assertThat(한칸_움직인_차.getMoving().getMovingDistance()).isEqualTo(2);
    }

}