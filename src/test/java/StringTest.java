import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    public void split01() {
        //given
        String given = "1,2";
        //when
        String[] split = given.split(",");
        //then
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    public void split02() {
        //given
        String given = "1";
        //when
        String[] split = given.split(",");
        //then
        assertThat(split).contains("1");
    }

    @Test
    public void substring() {
        //given
        String given = "(1,2)";
        //when
        String substring = given.substring(1, 4);

        //then
        assertThat(substring).isEqualTo("1,2");

    }

}
