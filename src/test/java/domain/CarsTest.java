package domain;

import exception.CarNameTooLongException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    String carNames;

    Car mockCar1;
    Car mockCar2;
    Car mockCar3;
    List<Car> mockCars = new ArrayList<>();

    @BeforeEach
    void setUp() {
        carNames = "A,B,C";

        mockCar1 = new Car("A", new StringBuilder(), 0);
        mockCar2 = new Car("B", new StringBuilder(), 0);
        mockCar3 = new Car("C", new StringBuilder(), 0);

        mockCars.add(mockCar1);
        mockCars.add(mockCar2);
        mockCars.add(mockCar3);
    }

    @Test
    public void 자동차_이름_입력시_자동차_객체_생성() {
        List<Car> cars = Cars.create(carNames);
        assertThat(cars)
                .usingRecursiveComparison()
                .isEqualTo(mockCars);
    }

    @Test
    public void 문자열을_자동차명_리스트로_재정의() {
        List<String> nameList = Cars.splitCarNames(carNames);

        List<String> mockList = new ArrayList<>();
        mockList.add("A");
        mockList.add("B");
        mockList.add("C");

        assertThat(nameList).isEqualTo(mockList);
    }

    @Test
    public void 자동차_이름_5글자_초과이면_에러() {
        String mockName = "Thomas";
        assertThatThrownBy(() -> Cars.checkLessThanSixLetters(mockName))
                .isInstanceOf(CarNameTooLongException.class);
    }

}