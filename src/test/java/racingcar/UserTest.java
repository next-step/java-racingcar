package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    private User user;

    @BeforeEach
    void setUp() {
        user = User.createUser(UserArguments.createUserArgs(3, 4));
    }

    @Test
    void createUserTest() {
        assertAll("Car",
                () -> assertEquals(3, this.user.getCars().size()),
                () -> assertEquals(true, this.user.hasNext())
        );
    }

    @Test
    void userIterationTest() {
        int count = 0;

        while (this.user.hasNext()) {
            count ++;
            this.user.nextStep();
        }

        assertThat(count).isEqualTo(4);
    }

    @Test
    void createCarsTest() {
        int sum = 0;
        List<Car> cars = this.user.getCars();

        for (Car car : cars) {
            sum += car.getPosition();
        }

        assertThat(sum).isEqualTo(3);
    }
}
