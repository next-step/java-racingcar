package stringCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

    // nextLine으로 값을 입력하기 전 NoSuchElementException이 나고 있어
    // 어떤 식으로 테스트 해야하는지를 잘 모르겠습니다
    @Test
    public void 문자열_계산식_받기(){
        assertThat(Main.getStringFoumula()).isEqualTo("1 + 2 + 3 + 4 + 5 + 6");
    }


}
