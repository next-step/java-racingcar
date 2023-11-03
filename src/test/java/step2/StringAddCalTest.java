package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class StringAddCalTest {

    private  StringAddCal stringAddCal;

    @BeforeEach
    void setUp() {
        stringAddCal = new StringAddCal();
    }

    @Test
    public void stringAdd_null_또는_빈문자() {
        int result = stringAddCal.stringAdd(null);
        assertThat(result).isEqualTo(0);

        result = stringAddCal.stringAdd("");
        assertThat(result).isEqualTo(0);

        result = stringAddCal.stringAdd(" ");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void stringAdd_숫자하나() throws Exception {
        int result = stringAddCal.stringAdd("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void stringAdd_숫자두개() {
        int result = stringAddCal.stringAdd("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void stringAdd_쉼표_또는_콜론_구분자() {
        int result = stringAddCal.stringAdd("1,2,3");
        assertThat(result).isEqualTo(6);

        int result1 = stringAddCal.stringAdd("1:2:3");
        assertThat(result).isEqualTo(6);

        int result2 = stringAddCal.stringAdd("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void stringAdd_custom_구분자() {
        int result = stringAddCal.stringAdd("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void stringAdd_negative() {
        try {
            stringAddCal.stringAdd("-1,2,3");
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("음수는 입력할 수 없습니다.");
        }
    }


    @Test
    public void getDefaultStringTest() {
        assertThat(stringAddCal.getSlashString("//;\n1;2;3")).isEqualTo(new String[]{"1", "2", "3"});
        assertThat(stringAddCal.getDefaultString("1,2,3")).isEqualTo(new String[]{"1", "2", "3"});
        assertThat(stringAddCal.getDefaultString("1:2:3")).isEqualTo(new String[]{"1", "2", "3"});
        assertThat(stringAddCal.getDefaultString("1,2:3")).isEqualTo(new String[]{"1", "2", "3"});

    }

    /*    @Test
    public void getDelimiterTest() {
        StringAddCal stringAddCal = new StringAddCal();
        assertThat(stringAddCal.getDelimiter("//;\n1;2;3")).isEqualTo(";");
        assertThat(stringAddCal.getDelimiter("1,2,3")).isEqualTo(",");
        assertThat(stringAddCal.getDelimiter("1:2:3")).isEqualTo(":");
        assertThat(stringAddCal.getDelimiter("1,2:3")).isNull();
    }*/

}