package racingcar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidCarSettingException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void init() {
        this.cars = new Cars();
    }


    @Test
    @DisplayName("Car 추가 성공 테스트")
    void setCars_성공() {

        InputStream in = new ByteArrayInputStream("a,b,c".getBytes());
        System.setIn(in);

        cars.setCarsByUserInputNames();

        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Car 추가 실패(공백 입력)테스트")
    void setCars_실패_공백입력() {

        InputStream in = new ByteArrayInputStream(" ,b,c".getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> cars.setCarsByUserInputNames())
                .isInstanceOf(InvalidCarSettingException.class)
                .hasMessage("자동차 이름은 공백이 불가합니다.");
    }

    @Test
    @DisplayName("Car 추가 실패(자동차 이름 5자 초과)테스트")
    void setCars_실패_이름5자초과() {

        InputStream in = new ByteArrayInputStream("abcdefg,h,i".getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> cars.setCarsByUserInputNames())
                .isInstanceOf(InvalidCarSettingException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("Car 추가 실패(자동차 1대 입력)테스트")
    void setCars_실패_1대입력() {

        InputStream in = new ByteArrayInputStream("a".getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> cars.setCarsByUserInputNames())
                .isInstanceOf(InvalidCarSettingException.class)
                .hasMessage("2개 이상의 자동차를 입력해야 시작 가능합니다.");
    }
}
