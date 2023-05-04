package study.race;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("경주 자동차 객체 배열 생성")
    void carTest(){
        String[] names = {"pobi","conan"};
        assertThat(Racing.carArray(names)).hasSize(2).extracting(Car::getName).contains("pobi","conan");
    }

    @Test
    @DisplayName("만일 입력받은 이름이 5글자 초과하면 예외처리하기 ")
    void nameCheck(){
        assertThatThrownBy(() -> {
            Car car1 = new Car("pobidfd",2);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }

}
