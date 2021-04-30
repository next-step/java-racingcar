import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    Computer computer;

    @Test
    void remoteControl() {
        computer = new Computer();
        Car car = new Car("AAA");
        computer.remoteControl(car);
        assertTrue(0 == car.distance || car.distance == 1);
    }
}