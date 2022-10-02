package step5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step5.domain.Car;
import step5.domain.Name;
import step5.domain.Position;
import step5.domain.RacingRecord;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    Car car;
    public static final String CAR_NAME = "sakku";

    @BeforeEach
    void init(){
        car = new Car(CAR_NAME);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "      ", " ", "123456"})
    void 이름_검증_테스트(String name){
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("자동차 이름은");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void n번_이동_후_상태_테스트(int moveCount){

        for(int i = 0 ; i < moveCount ; i++){
            car.move(() -> true);
        }

        assertThat(car.racingRecord()).isEqualTo(new RacingRecord(new Name(CAR_NAME), new Position(moveCount)));
    }

}
