package study.step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ChampionTest {
    private List<Car> cars;

    @BeforeEach
    void setUp(){
        cars = new ArrayList<>();
        cars.add(new Car("자동차1", 3));
        cars.add(new Car("자동차2", 5));
        cars.add(new Car("자동차3", 6));
        cars.add(new Car("자동차4", 6));
        cars.add(new Car("자동차5", 7));
    }

    @ParameterizedTest
    @DisplayName("우승자 생성자에 빈값 입력시 예외 발생 체크 메소드")
    @NullSource
    void championValidateTest(Round round){
        assertThatThrownBy(() ->{
            new Champion(round);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("우승자 결정 메소드 테스트")
    void getChampionMethodTest(){
        assertThat(new Champion(new Round(cars)).getChampions()).containsExactly("자동차5");
    }
}
