package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Car;
import racing.model.CarInfo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarInfoTest {

   @Test
   @DisplayName("carName Test")
   void carNameTest() {
       CarInfo carInfo = new CarInfo("name");
       assertThat(carInfo.name()).isEqualTo("name");
   }


    @Test
    @DisplayName("carName Size check")
    void carNameSizeCheck() {
        assertThatThrownBy(() -> {
            new Car("test123");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
