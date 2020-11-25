package racingcarrefectoring;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class NameTest {

    @Test
    @DisplayName("이름 객체가 잘 만들어졌는가")
    public void setName(){
        Name name = new Name("베니");
        assertEquals(name.getString(),"베니");
    }

    @Test
    @DisplayName("이름이 공백일 때 예외처리가 되어 있는가")
    public void isEmpty(){
        assertThrows(NameEmptyException.class, () -> {
            Name name = new Name("");
        } );
    }

    @Test
    @DisplayName("이름이 6자가 넘을 때 예외 처리가 되는가")
    public void overTheLimit(){
        assertThrows(OverTheLimitException.class, () -> {
            Name name = new Name("포비코난베니포비");
        });
    }

}
