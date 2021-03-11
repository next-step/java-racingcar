package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 전진 테스트")
    void move() {
        //given
        Car firstCar = new Car("firstCar");
        Car secondCar = new Car("secondCar");
        Car thirdCar = new Car("thirdCar");
        Car fourthCar = new Car("fourthCar");

        //when
        firstCar.move(5);
        firstCar.move(9);
        secondCar.move(3);
        secondCar.move(2);
        int movementRangeOfFirstCar = firstCar.getMovementRange();
        int movementRangeOfSecondCar = secondCar.getMovementRange();

        //then
        assertEquals(2, movementRangeOfFirstCar, "4이상의 값이 2번 들어갔기 때문에 2번 이동해야 한다.");
        assertEquals(0, movementRangeOfSecondCar, "4미만의 값이 2번 들어갔기 때문에 이동하지 않아야 한다.");
        assertThatIllegalArgumentException().isThrownBy(() -> thirdCar.move(-10)).withMessageContaining("이동 범위의 조건은 0 ~ 9");
        assertThatIllegalArgumentException().isThrownBy(() -> fourthCar.move(10)).withMessageContaining("이동 범위의 조건은 0 ~ 9");
    }

    @Test
    @DisplayName("자동차 이동범위 확인 테스트")
    public void getMovementRange() throws Exception {
        //given
        Car firstCar = new Car("firstCar");
        Car secondCar = new Car("secondCar");
        Car thirdCar = new Car("thirdCar");

        //when
        firstCar.move(5);
        firstCar.move(9);
        secondCar.move(3);
        secondCar.move(2);
        thirdCar.move(4);
        thirdCar.move(0);
        int movementRangeOfFirstCar = firstCar.getMovementRange();
        int movementRangeOfSecondCar = secondCar.getMovementRange();
        int movementRangeOfThirdCar = thirdCar.getMovementRange();

        //then
        assertEquals(2, movementRangeOfFirstCar, "4이상의 값이 2번 들어갔기 때문에 2번 이동해야 한다.");
        assertEquals(0, movementRangeOfSecondCar, "4미만의 값이 2번 들어갔기 때문에 이동하지 않아야 한다.");
        assertEquals(1, movementRangeOfThirdCar, "4미만의 값이 1번, 4이상의 값이 1번 들어갔기 때문에 1번 이동해야 한다.");
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트")
    public void setName() throws Exception {
        //given
        String firstCarName = "seongbeen";
        String secondCarName = "pobi";
        Car firstCar = new Car(firstCarName);
        Car secondCar = new Car(secondCarName);

        //when
        String nameFromFirstCar = firstCar.getName();
        String nameFromsecondCar = secondCar.getName();

        //then
        assertEquals(firstCarName, nameFromFirstCar, "자동차 객체에서 가져온 이름이 입력한 이름과 같아야 한다.");
        assertEquals(secondCarName, nameFromsecondCar, "자동차 객체에서 가져온 이름이 입력한 이름과 같아야 한다.");
    }

    @Test
    @DisplayName("자동차 전진 조건 0 ~ 9 검증 테스트")
    public void validateRandomNumber() throws Exception {
        //given
        Car firstCar = new Car("firstCar");
        Car secondCar = new Car("secondCar");

        //when

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> firstCar.move(-10)).withMessageContaining("이동 범위의 조건은 0 ~ 9");
        assertThatIllegalArgumentException().isThrownBy(() -> secondCar.move(10)).withMessageContaining("이동 범위의 조건은 0 ~ 9");
    }
}