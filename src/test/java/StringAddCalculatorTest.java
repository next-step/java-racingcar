import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    StringAddCalculator cal = new StringAddCalculator();

    @Test
    @DisplayName(value="5. “//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\\n1;2;3” => 6)")
    void 패턴_구분자(){
        assertThat(cal.add("//;\n1;2;3")).isEqualTo(6);
        assertThat(cal.add("1,5,6")).isEqualTo(12);
    }

    @Test
    @DisplayName(value="6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)")
    void 음수_익셉션(){
        assertThatThrownBy(()-> cal.add("-1,2,3")).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName(value="1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)")
    void 빈값을_0으로_변환(){
        assertThat(cal.add("")).isEqualTo(0);
        assertThat(cal.add(null)).isEqualTo(0);
    }

    @Test
    @DisplayName(value="4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)")
    void 콤마_콜론_구분자_합계(){
        assertThat(cal.add("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName(value="3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)")
    void 콤마_합계(){
        assertThat(cal.add("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName(value="2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)")
    void 문자열_단건(){
        assertThat(cal.add("1")).isEqualTo(1);
    }
}