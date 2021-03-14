package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @Test
    @DisplayName("자동차 전진 테스트")
    void move() {
        //given
        Car one = new Car("one");
        Car two = new Car("two");
        Car three = new Car("three");
        Car four = new Car("four");

        //when
        one.move(5);
        one.move(9);
        two.move(3);
        two.move(2);
        int movementRangeOfFirstCar = one.getMovementRange();
        int movementRangeOfSecondCar = two.getMovementRange();

        //then
        assertEquals(2, movementRangeOfFirstCar, "4이상의 값이 2번 들어갔기 때문에 2번 이동해야 한다.");
        assertEquals(0, movementRangeOfSecondCar, "4미만의 값이 2번 들어갔기 때문에 이동하지 않아야 한다.");
        assertThatIllegalArgumentException().isThrownBy(() -> three.move(-10)).withMessageContaining("이동 범위의 조건은 0 ~ 9");
        assertThatIllegalArgumentException().isThrownBy(() -> four.move(10)).withMessageContaining("이동 범위의 조건은 0 ~ 9");
    }

    @Test
    @DisplayName("자동차 이동범위 확인 테스트")
    public void getMovementRange() throws Exception {
        //given
        Car one = new Car("one");
        Car two = new Car("two");
        Car three = new Car("three");

        //when
        one.move(5);
        one.move(9);
        two.move(3);
        two.move(2);
        three.move(4);
        three.move(0);
        int movementRangeOfFirstCar = one.getMovementRange();
        int movementRangeOfSecondCar = two.getMovementRange();
        int movementRangeOfThirdCar = three.getMovementRange();

        //then
        assertEquals(2, movementRangeOfFirstCar, "4이상의 값이 2번 들어갔기 때문에 2번 이동해야 한다.");
        assertEquals(0, movementRangeOfSecondCar, "4미만의 값이 2번 들어갔기 때문에 이동하지 않아야 한다.");
        assertEquals(1, movementRangeOfThirdCar, "4미만의 값이 1번, 4이상의 값이 1번 들어갔기 때문에 1번 이동해야 한다.");
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트")
    public void carName() throws Exception {
        //given
        String oneName = "sean";
        String twoName = "pobi";
        Car one = new Car(oneName);
        Car two = new Car(twoName);

        //when
        String nameFromOne = one.getName();
        String nameFromTwo = two.getName();

        //then
        assertEquals(oneName, nameFromOne, "자동차 객체에서 가져온 이름이 입력한 이름과 같아야 한다.");
        assertEquals(twoName, nameFromTwo, "자동차 객체에서 가져온 이름이 입력한 이름과 같아야 한다.");
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(null)).withMessage("이름 값이 null인지 확인해주세요.");
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("")).withMessage("이름 값이 공백인지 확인해주세요.");
    }

    @Test
    @DisplayName("자동차 이동 범위 초기화 테스트")
    public void initializeMovementRange() throws Exception {
        //given
        Car one = new Car("one");
        Car two = new Car("two");
        one.move(5);
        two.move(7);
        two.move(6);

        //when
        one.initializeMovementRange();
        two.initializeMovementRange();
        int movementRangeOfFirstCar = one.getMovementRange();
        int movementRangeOfSecondCar = two.getMovementRange();

        //then
        assertEquals(0, movementRangeOfFirstCar, "one의 이동범위는 1 -> 0으로 초기화되야 한다.");
        assertEquals(0, movementRangeOfSecondCar, "two의 이동범위는 2 -> 0으로 초기화되야 한다.");
    }

    @Test
    @DisplayName("자동차 전진 조건 0 ~ 9 검증 테스트")
    public void validateRandomNumber() throws Exception {
        //given
        Car one = new Car("one");
        Car two = new Car("two");

        //when

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> one.move(-10)).withMessageContaining("이동 범위의 조건은 0 ~ 9");
        assertThatIllegalArgumentException().isThrownBy(() -> two.move(10)).withMessageContaining("이동 범위의 조건은 0 ~ 9");
    }
}