package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    private Car car;
    private OutputView outputView;
    private final int DEFULT_POSITION = 0;

    public void setUp(int position) {
        this.car = new Car(position);
        this.outputView = new OutputView();
    }

    @DisplayName("자동차가 움직이는지 테스트")
    @Test
    public void move() {
        //given
        setUp(DEFULT_POSITION);
        int moveNumber = 4;
        //when
        car.move(moveNumber);
        //then
        assertThat(car.nowPosition()).isEqualTo(1);
    }

    @DisplayName("자동차가 멈추는지 테스트")
    @Test
    public void stop() {
        //given
        setUp(DEFULT_POSITION);
        int moveNumber = 3;
        //when
        car.move(moveNumber);
        //then
        assertThat(car.nowPosition()).isEqualTo(0);
    }

    @DisplayName("자동차의 현재위치 출력")
    @Test
    public void position() {
        //given
        setUp(DEFULT_POSITION);
        int moveNumber = 4;
        //when
        car.move(moveNumber);
        car.move(moveNumber);
        int stopMoveNumber = 3;
        car.move(stopMoveNumber);
        //then
        assertThat(outputView.printCar(car.nowPosition())).isEqualTo("--");
    }
}
