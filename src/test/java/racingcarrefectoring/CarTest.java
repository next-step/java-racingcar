package racingcarrefectoring;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class CarTest {

    @Test
    @DisplayName("자동차가 이동을 잘 하는가")
    public void move(){
        Car car = new Car("베니");
        Position position = new Position(0);
        assertTrue(car.getPosition().equals(position));
        car.move();
        position = new Position(position.increase());
        assertTrue(car.getPosition().equals(position));
    }

    @Test
    @DisplayName("이름이 제대로 만들어졌는가")
    public void setName(){
        Car car = new Car("베니");
        Name name = new Name("베니");
        assertTrue(car.getName.Equals(name));
    }
}
