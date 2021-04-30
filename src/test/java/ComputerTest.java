import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ComputerTest {

    Computer computer;
    Car car = Setup.car;

    @Test
    void remoteControl() {
        computer = new Computer();
        computer.remoteControl(car);
        assertTrue(0 == car.distance || car.distance == 1);
    }
}