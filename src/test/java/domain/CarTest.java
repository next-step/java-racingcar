package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import strategy.MovableStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car myCar;

    @BeforeEach
    public void setup() {
        myCar = new Car("myCar");
    }

    @Test
    public void isMoveFalseCarDoesNotMoveTest() {
        MovableStrategy falseMovableStrategy = () -> false;

        myCar.move(falseMovableStrategy);
        assertThat(myCar).isEqualTo(new Car("myCar", 0));
    }

    @Test
    public void isMoveTrueCarMoveTest() {
        MovableStrategy trueMovableStrategy = () -> true;

        myCar.move(trueMovableStrategy);
        assertThat(myCar).isEqualTo(new Car("myCar", 1));
    }

    @Test
    public void toStringTest() {
        MovableStrategy trueMovableStrategy = () -> true;
        myCar.move(trueMovableStrategy);
        myCar.move(trueMovableStrategy);
        myCar.move(trueMovableStrategy);
        assertThat(myCar.toString()).isEqualTo("myCar : ---");
    }

}
