package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step2.StringValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    @DisplayName("이름 생성 테스트 - 원시값 변경")
    void 이름생성(){
        String carName = "pobi";
        Name name = new Name(carName);
        assertThat(name).isEqualTo(new Name("pobi"));
    }

    @Test
    @DisplayName("자동차 이름 길이 체크 테스트 - 길이가 5가 넘어가면 IllegalArgumentException 발생")
    void 자동차이름_길이체크(){
        String carName = "honux23";
        assertThatThrownBy(()->{
            Name name = new Name(carName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 비었는지 테스트")
    void 자동차이름_비었는지_테스트(){
        assertThatThrownBy(()->{
            Name name = new Name("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
