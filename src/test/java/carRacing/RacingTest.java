package carRacing;

import car.Car;
import carRacing.view.InputView;

import carRacing.view.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @BeforeEach
    void setSystemIn(){
        systemIn("3\n5");
    }

    @DisplayName("원하는 숫자만큼 입력부 세팅시 정상적으로 값이 설정되는지 확인")
    @Test
    void inputView_Test() {

        InputView inputView = new InputView(3,5);
        assertThat(inputView.getCarCount()).isEqualTo(3);
        assertThat(inputView.getMoveCount()).isEqualTo(5);
    }


    @DisplayName("차량 3대를 5회 이동시켰을때 결과")
    @Test
    void racingTest() {

        //차량세팅
        InputView inputView = new InputView();
        inputView.setCarCount();
        inputView.setMoveCount();

        //레이싱 시작
        Racing racing = new Racing(inputView.getCarCount(), inputView.getMoveCount());
        racing.startRacingCar();

        //레이싱 결과
        List<List<Integer>> resultList = racing.getResultList();

        //레이싱 결과 표기
        new ResultView().showCardRacingResultByResultList(resultList, "~");
    }

    /**
     * System.in을 하기위한 method
     *
     * @param input
     */
    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
    }

    protected void moveCar(Car car, int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }
    }
}
