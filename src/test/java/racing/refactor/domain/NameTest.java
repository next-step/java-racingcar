package racing.refactor.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("자동차 이름 테스트")
class NameTest {

    @Test
    @DisplayName("null 을 입력하여 생성 시 IllegalArgumentException")
    public void creationOfNull() {
        assertThrows(IllegalArgumentException.class
                ,() -> new Name(null)
        );
    }

    @Test
    @DisplayName("\"123456\"(5자 초과) 을 입력하여 생성 시 IllegalArgumentException")
    public void creationOfBlank() {
        assertThrows(IllegalArgumentException.class
                ,()-> new Name("123456")
        );
    }

    @Test
    @DisplayName("\"12345\" (5자 이하) 를 입력하여 생성 시 정상 수행")
    public void creationOfNormal() {
        assertDoesNotThrow(()-> new Name("12345"));
    }

    @Test
    @DisplayName("같은 값으로 생성 후 비교 시 같음")
    public void equals() {
        Name name1 = new Name("test");
        Name name2 = new Name("test");
        assertEquals(name1, name2);
    }
}