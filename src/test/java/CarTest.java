import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 한칸_전진한다() {
        final Car car = new Car();
        int number = 4;

        car.move(number);
        String actual = car.print();

        Assertions.assertEquals("-", actual);
    }
}
