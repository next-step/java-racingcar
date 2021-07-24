package Car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    Car car;

    @BeforeEach
    void setUp(){
        car = new Car();
    }

    @Test
    void 자동차초기상태테스트(){
        String result = car.getStatus();
        assertThat(result).isEqualTo("-");
    }

    @ParameterizedTest
    @CsvSource({
            "1, --",
            "2, ---",
            "5, ------"
    })
    void 자동차전진테스트(int moveCount, String answer){
        for(int i=0;i<moveCount;i++){
            car.move();
        }
        String result = car.getStatus();
        assertThat(result).isEqualTo(answer);
    }

}