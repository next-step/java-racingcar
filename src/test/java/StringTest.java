import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    public void split01() {
        //given
        String given = "1,2";
        //when
        String[] split = given.split(",");
        //then
        assertThat(split).containsExactly("1", "2");
    }

    public void split02() {
        //given
        String given = "1";
        //when
        String[] split = given.split(",");
        //then
        assertThat(split).contains("1");

    }

}
