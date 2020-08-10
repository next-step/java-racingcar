package step3;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car = new Car();

    @Test
    void advance() {
        boolean result = car.advance();
        int miles = car.getMiles();

        if(result){
            assertThat(car.getMiles()).isEqualTo(miles+1);
        } else {
            assertThat(car.getMiles()).isEqualTo(miles);
        }
    }
}
