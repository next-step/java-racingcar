package carracing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    public void checkLengthTest() throws NoSuchMethodException {
        String testNameString = "namenamenamename";

        assertThatThrownBy(()->new Name(testNameString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자를 넘을 수 없습니다.");
    }

    @Test
    public void checkEmptyOrNullTest() throws NoSuchMethodException {
        String testNameString = "";

        assertThatThrownBy(()->new Name(testNameString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 Null 혹은 빈문자열 입니다.");
    }









    private void checkNullAndEmpth(String name){
        if(name.isEmpty()||name.equals("")||name==null){
            throw new IllegalArgumentException("이름이 Null 혹은 빈문자열 입니다.");
        }
    }
}
