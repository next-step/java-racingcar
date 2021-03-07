package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step2.StringValidator;
import study.step3.Car;
import study.step3.NumberChecker;

import static org.assertj.core.api.Assertions.*;

public class CarRaceTest {

    @Test
    @DisplayName("UI Input Test")
    void UI_입력_실패테스트(){
        String number = "5a";
        assertThatThrownBy(()->{
            StringValidator.checkNumberSyntax(number);
        }).isInstanceOf(NumberFormatException.class)
        .hasMessageContaining("숫자를 정확히 입력해주세요");
    }

    @Test
    @DisplayName("랜덤 값 생성 및 4 이상의 경우 전진 테스트")
    void 전진테스트(){
        Car car = new Car();
        if(NumberChecker.checkCondition()){
            car.move();
        }
    }

    @Test
    @DisplayName("전진하는 조건 테스트, 4 이상일 경우 성공")
    void 전진조건테스트(){
        assertThat(NumberChecker.checkCondition()).isTrue();
    }
}
