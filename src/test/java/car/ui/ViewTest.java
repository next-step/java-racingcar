package car.ui;

import car.domain.Car;
import car.domain.Name;
import car.domain.Position;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ViewTest {

    @Test
    void 자동차의_위치상태를_출력한다() {
        // given
        Car car = new Car(new Name("씽씽카"), new Position(3));
        View view = View.from(car);
        String actual = view.printStatus();
        assertThat(actual).isEqualTo("씽씽카 : ---");
    }
}
