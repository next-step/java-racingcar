package racing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.Calculator;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingTest {

    public static Racing racing = new Racing();

    private List<Car> carList1;
    private List<Car> carList2;

    @BeforeEach
    public void setUp() {
        carList1 = new ArrayList<>();
        Car car1 = new Car();
        car1.setDistance(1);
        car1.setCarName("R1");
        Car car2 = new Car();
        car2.setDistance(2);
        car2.setCarName("R2");
        Car car3 = new Car();
        car3.setDistance(3);
        car3.setCarName("R3");
        carList1.add(car1);
        carList1.add(car2);
        carList1.add(car3);

        carList2 = new ArrayList<>();
        Car car4 = new Car();
        car4.setDistance(1);
        car4.setCarName("R4");
        Car car5 = new Car();
        car5.setDistance(5);
        car5.setCarName("R5");
        Car car6 = new Car();
        car6.setDistance(5);
        car6.setCarName("R6");
        carList2.add(car4);
        carList2.add(car5);
        carList2.add(car6);
    }

    @Test
    public void isGameOverTest() {

        Integer tryNum = 5;

        Boolean result1 = racing.isGameOver(carList1, tryNum);
        Boolean result2 = racing.isGameOver(carList2, tryNum);

        assertEquals(result1,false);
        assertEquals(result2,true);

    }



    @Test
    public void isMoveTest() {

        Boolean result1 = racing.isMove(1);
        Boolean result2 = racing.isMove(5);

        assertEquals(result1,false);
        assertEquals(result2,true);
    }

    @Test
    public void makeRanNumTest() {

        Integer result1 = racing.makeRanNum();

        String regExp = "^[0-9]+$";

        assertEquals(result1.toString().matches(regExp), true);
    }
}
