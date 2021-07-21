package step3.model;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    static Car car;
    @BeforeAll
    static void create(){
        car = new Car();
    }

    @DisplayName("자동차 초기값 확인")
    @Test
    void initPositionTest(){

    }

}