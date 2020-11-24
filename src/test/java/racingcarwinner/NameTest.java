package racingcarwinner;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameTest {

    @Test
    @DisplayName("이름 객체 생성 테스트")
    public void create(){
        Car car = new Car("베니");
        Name name = new Name("베니");
        assertTrue(car.getName().equals(name));
    }

    @Test
    @DisplayName("이름 객체의 값 반환이 잘 되는가")
    public void getString(){
        Name name = new Name("베니베니");
        assertEquals("베니베니",name.getString());
    }

    @Test
    @DisplayName("이름이 5자가 넘어갔을 때 예외처리가 되어 있는가")
    public void isOverLimit(){
        assertThrows(IllegalArgumentException.class, () ->{
            Name name = new Name("베니베니베니베니");
        });
    }

    @Test
    @DisplayName("이름이 공백일 때 예외처리가 되어 있는가")
    public void isEmpty(){
        assertThrows(IllegalArgumentException.class, () ->{
            Name name = new Name("");
        });
    }
}
