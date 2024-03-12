package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    @Nested
    @DisplayName("InputView")
    class inputViewTest {
        @Test
        @DisplayName("(1)사용자에게 자동차 갯수를 입력 받음")
        public void 갯수() {

        }

        @Test
        @DisplayName("(2)사용자에게 자동차 횟수를 입력 받음")
        public void 횟수() {

        }
    }

    @Nested
    @DisplayName("Car")
    class CarTest {
        @Test
        @DisplayName("(1)자동차의 위치를 전달")
        public void 위치() {

        }

        @Test
        @DisplayName("(2)자동차의 위치를 업데이트")
        public void 위치업뎃() {

        }
    }

    @Nested
    @DisplayName("CarArray")
    class CarArrayTest {
        @Test
        @DisplayName("(1)자동차 배열에 입력받은 갯수만큼 자동차 생성")
        public void 자동차배열() {

        }

        @Test
        @DisplayName("(2)자동차 배열 내의 모든 자동차 위치를 업데이트")
        public void 자동차배열위치업데이트() {

        }

        @Test
        @DisplayName("(3)자동차 배열 내의 자동차 위치 전달")
        public void 자동차배열내자동차위치전달() {

        }
    }

    @Test
    @DisplayName("Racing")
    public void 경주() {

    }



    @Nested
    @DisplayName("OutputView")
    class OutputView {
        @Test
        @DisplayName("(1)자동차 하나의 위치를 출력 ")
        public void 자동차하나의위치를출력()
        {

        }

        @Test
        @DisplayName("(2)모든 자동차의 위치를 출력")
        public void 모든자동차위치를출력()
        {

        }

    }


}
