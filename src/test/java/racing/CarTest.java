package racing;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void move() {
        Car car1 = new Car();
        car1.move(true   );
        car1.move(true   );

        Car car2 = new Car();
        car2.move(false   );
        car2.move(true   );


        Car car3 = new Car();
        car3.move(false );
        car3.move(false );

    }
}