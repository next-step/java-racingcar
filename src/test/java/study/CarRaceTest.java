package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class CarRaceTest {

    @Test
    @DisplayName("UI Input Test")
    void UI_입력_실패테스트(){
        String number = "5a";
        assertThatThrownBy(()->{
            StringValidator.checkNumberSyntax(number);
        }).isInstanceOf(NumberFormatException.class)
        .hasMessageContaining("숫자를 입력하세요");
    }

    @Test
    @DisplayName("랜덤 값 생성 및 4 이상의 경우 전진 테스트")
    void 전진테스트(){
        Car car = new Car();
        Random random = new Random();
        if(random.nextInt(10) >= 4){
            car.move();
        }
    }
}
