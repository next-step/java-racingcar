package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.logging.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringClassTest {
    private static final Logger log = Logger.getLogger("StringClassTest");

    @DisplayName("요구사항 1 - \"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    @Test
    public void splitTest1() {
        //given
        String preset = "1,2";

        //when
        String[] split = preset.split(",");

        //then
        assertEquals(split.length, 2);
        assertEquals(split[0],"1");
        assertEquals(split[1],"2");
    }

    @DisplayName("요구사항 1 - \"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    @Test
    public void splitTest2() {
        //given
        String preset = "1";

        //when
        String[] split = preset.split(",");

        //then
        assertEquals(split.length,1);
        assertEquals(split[0], "1");
    }

    @DisplayName("요구사항2 - \"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    @Test
    public void useSubString() {
        //given
        String preset = "(1,2)";
        //when
        String subString = preset.substring(1, 4);
        //then
        assertEquals(subString,"1,2");
    }

    @DisplayName("요구사항 3 - \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    @Test
    public void learnCharAt() {
        //given
        String preset = "abc";

        //when
        Map<Integer, Character> charIndexMap = Map.of(0, preset.charAt(0), 1, preset.charAt(1), 2, preset.charAt(2));

        //then
        assertEquals(charIndexMap.get(0), 'a');
        assertEquals(charIndexMap.get(1), 'b');
        assertEquals(charIndexMap.get(2), 'c');
    }


    @DisplayName("요구사항 3 - String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    @Test
    public void run2324() {
        //given
        String preset = "123";
        //when
        //then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    preset.charAt(4);
                }).withMessageMatching("String index out of range: 4");
    }

    @DisplayName("요구사항 3 - String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    @Test
    public void run23234() {
        //given
        String preset = "123";
        //when
        //then
        assertThatThrownBy(() -> {
            preset.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }


    @DisplayName("비기능 요구사항 정리")
    @Test
    public void run234() {
        log.info("JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.");
    }


}
