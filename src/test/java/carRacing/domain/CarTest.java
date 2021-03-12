package carRacing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp(){
        this.car = new Car();
    }

    @Test
    @DisplayName("자동차 인스턴스를 생성할 수 있다")
    public void constructorCreatesNewCar(){
        assertEquals(car.getScore(),0);
        Car updatedCar = new Car(car);
        assertEquals(updatedCar.getScore(), 0);
    }

    @Test
    @DisplayName("자동차가 지나간 거리를 구할 수 있다")
    public void toStringGetsTraces(){
        for(int iter = 0;iter<100;iter++){
            Car updatedCar = car.raceOrStay(car);
            assertTrue(updatedCar.getScore()==0|| updatedCar.getScore()==1);
        }
    }




}