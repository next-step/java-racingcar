package step5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.car.Name;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class Strep5NameTest {


    @Test
    @DisplayName("이름 객체 생성 테스트")
    void name_object_test() throws Exception {

        String name = "홍길동";


        Name nameObject = Name.of(name);


        Assertions.assertThat(nameObject).extracting("name").isEqualTo(name);
    }

    @Test
    @DisplayName("이름 길이 초과 예외 테스트")
    void name_object_test_limit_length() throws Exception {

        String name = "이름이 5자 이상 ";


        assertThrowsExactly(IllegalArgumentException.class, () -> Name.of(name));
    }
}
