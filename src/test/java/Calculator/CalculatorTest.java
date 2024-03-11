package Calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {
    @Test
    void IsEmpty_or_NULL() {
        assertThat(StringAddCal.AddNumbers(null)).isEqualTo(0);
        assertThat(StringAddCal.AddNumbers("")).isEqualTo(0);
    }
    @Test
    void IsOneNum(){
        assertThat(StringAddCal.AddNumbers("1")).isEqualTo(1);
    }
    @Test
    void Is콤마문자열(){
        assertThat(StringAddCal.AddNumbers("1,2,3")).isEqualTo(6);
    }
    @Test
    void Is콜론문자열(){
        assertThat(StringAddCal.AddNumbers("1:2:3")).isEqualTo(6);
    }
    @Test
    void Is콤마_콜론_문자열(){
        assertThat(StringAddCal.AddNumbers("1,2:3")).isEqualTo(6);
        assertThat(StringAddCal.AddNumbers("1:2,3")).isEqualTo(6);
    }
    @Test
    void IsCutom구분자(){
        assertThat(StringAddCal.AddNumbers("//;\n1;2;3")).isEqualTo(6);
        assertThat(StringAddCal.AddNumbers("//-\n1-2-3")).isEqualTo(6);
    }
    @Test
    void Is음수_포함_문자열(){
        assertThatThrownBy(() -> StringAddCal.AddNumbers("-1,2,3")).isInstanceOf(RuntimeException.class);
    }
    @Test
    void Is숫자가_아닌_문자_포함_문자열(){
        assertThatThrownBy(() -> StringAddCal.AddNumbers("a,2,3")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> StringAddCal.AddNumbers("a,2,3")).isInstanceOf(NumberFormatException.class);
    }
}
