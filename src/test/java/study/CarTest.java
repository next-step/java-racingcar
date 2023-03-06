package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Car{
    private final String name;
    public Car(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
public class CarTest {
    @DisplayName("car has name")
    @ValueSource(strings = {"jason", "joy"})
    @ParameterizedTest
    public void name(){
        final Car car = new Car("jason");
        assertThat(car.getName()).isEqualTo("jason");
    }

}


