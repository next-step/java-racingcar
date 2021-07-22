package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {

    private Utils utils;

    @BeforeEach
    void setup(){
        utils = new Utils();
    }

    @Test
    @DisplayName("문자열을 입력하면 문자열의 길이를 반환한다.")
    public void stringToStringLength(){
        int result1 = utils.stringLength("nextstep");

        assertThat(result1).isEqualTo(8);
    }

    @Test
    @DisplayName(",를 포함한 문자열을 입력하면 ,예따라 배열로 변경된다.")
    public void stringToStringArray(){
        String[] resultArray = utils.stringToStringArray("car1,car2,car3");

        assertThat(resultArray.length).isEqualTo(3);
        assertThat(resultArray[0]).isEqualTo("car1");
        assertThat(resultArray[2]).isEqualTo("car3");
    }

    @Test
    @DisplayName("필요없는 공백을 입력하면 공백을 제거한다.")
    public void stringByTrim(){
        String result = utils.stringByTrim("12      ");

        assertThat(result).isEqualTo("12");
    }

    @Test
    @DisplayName("문자열을 입력하면 숫자형태로 변환한다.")
    public void StringToInt(){
        int result = utils.stringToInt("1");

        assertThat(result).isEqualTo(1);
    }

}
