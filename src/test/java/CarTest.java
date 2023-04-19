import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    void 전진조건이_아니면_출력결과는_없다() {
        int random = 3;

        final Car car = new Car(random);
        car.move();

        assertEquals("", car.print());
    }

    @Test
    void 전진조건일_때_대쉬를_출력한다() {
        int random = 4;

        final Car car = new Car(random);
        car.move();

        assertEquals("-", car.print());
    }

    @Test
    void 한칸_전진한다() {
        final Car car = new Car();
        int number = 4;

        car.move(number);
        String actual = car.print();

        assertEquals("-", actual);
    }
}
