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
        assertThat(myCar).isEqualTo(new Car("myCar", new Location()));
    }

    @Test
    public void isMoveTrueCarMoveTest() {
        MovableStrategy trueMovableStrategy = () -> true;

        myCar.move(trueMovableStrategy);
        assertThat(myCar).isEqualTo(new Car("myCar", new Location(1)));
    }

    @Test
    public void toStringForPrintTest() {
        MovableStrategy trueMovableStrategy = () -> true;
        myCar.move(trueMovableStrategy);
        myCar.move(trueMovableStrategy);
        myCar.move(trueMovableStrategy);
        assertThat(myCar.toStringForPrint()).isEqualTo("myCar : ---");
    }

    @Test
    public void equalTest() {
        assertThat(new Car("myCar")).isEqualTo(new Car("myCar"));
        assertThat(new Car("myCar")).isEqualTo(new Car("myCar", new Location()));
        assertThat(new Car("myCar")).isEqualTo(new Car("myCar", new Location(0)));
    }

}
