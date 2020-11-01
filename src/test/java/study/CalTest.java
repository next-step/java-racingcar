package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalTest {


    @Test
    @DisplayName("덧셈")
    void addTest(){
        Cal cal = new Cal();
        assertThat(cal.add(1,2)).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈")
    void subTest(){
        Cal cal = new Cal();
        assertThat(cal.sub(5,1)).isEqualTo(4);
    }

    @Test
    @DisplayName("곱셈")
    void multiTest(){
        Cal cal = new Cal();
        assertThat(cal.mul(2,3)).isEqualTo(6);

    }

    @Test
    @DisplayName("나눗셈")
    void divTest(){
        Cal cal = new Cal();
        assertThat(cal.div(6,2)).isEqualTo(3);

    }

    @Test
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
    void argTest(){
        String input = "";
        Cal cal = new Cal();
        assertThatIllegalArgumentException().isThrownBy(()->{
            cal.calculate(input);
        });
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌경우")
    void operatorTest(){
        String input = "1 @ 3";
        Cal cal = new Cal();
        assertThatIllegalArgumentException().isThrownBy(()->{
            cal.calculate(input);
        });

    }

    @Test
    @DisplayName("정상 테스트")
    void successTest(){
        String input = "2 + 3 * 4 / 2";
        Cal cal = new Cal();

        assertThat(cal.calculate(input)).isEqualTo(10);



    }


}
