package racing.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.utils.ParserUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParserUtilsTest {



    @DisplayName("3개의 이름이 넘어왓을때 3개의 이름리스트 반환")
    @Test
    public void stringToArraySuccess(){
        String nameString = "HO,SOO,RAM";
        String[] names = ParserUtils.stringToArray(nameString);

        assertThat(names).contains("HO","SOO","RAM");
    }

    @DisplayName("이름이 공백으로 넘어왔을때 에러 발생")
    @Test
    public void stringToArrayFailWithEmpty(){
        String nameString = "";
        assertThatIllegalArgumentException()
                .isThrownBy(() ->ParserUtils.stringToArray(nameString));

    }

    @DisplayName("이름 문자열이 null일때 에러 발생")
    @Test
    public void stringToArrayFailWithNull(){
        String nameString = null;
        assertThatIllegalArgumentException()
                .isThrownBy(() ->ParserUtils.stringToArray(nameString));

    }

}