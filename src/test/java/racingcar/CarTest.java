package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @DisplayName("Car 객체의 name을 잘 들고오는지 확인")
    @Test
    public void getName() {
        Car car = new Car("name", 0);

        String name = car.getName();

        assertThat(name).isEqualTo("name");
    }

    @DisplayName("Car 객체의 location 을 잘 들고오는지 확인")
    @Test
    public void getLocation() {
        Car car = new Car("name", 2);

        int location = car.getLocation();

        assertThat(location).isEqualTo(2);
    }

    @DisplayName("Car가 잘 움직였는가를 확인")
    @Test
    public void playWithMove() {
        Car car = new Car("name", 0);
        MovementCondition movementCondition = new AllForwardMovementCondition();

        car.moveOrStay(movementCondition);
        int location = car.getLocation();

        assertThat(location).isEqualTo(1);
    }

    @DisplayName("Car가 움직이지 않았는가를 확인")
    @Test
    public void playWithoutMove() {
        Car car = new Car("name", 0);
        MovementCondition movementCondition = new AllStayMovementCondition();

        car.moveOrStay(movementCondition);
        int location = car.getLocation();

        assertThat(location).isEqualTo(0);
    }

    @DisplayName("Car의 정보를 잘 출력하는지를 확")
    @Test
    public void printNameAndCurrentPosition() {
        Car car = new Car("name", 3);

        car.printNameAndCurrentPosition();
        assertThat(outputStreamCaptor.toString()).isEqualTo("name : ---\n");
    }
}

