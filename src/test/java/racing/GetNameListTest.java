package racing;

import org.junit.jupiter.api.Test;
import racing.domain.GetNameList;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class GetNameListTest {
    @Test
    void InputBuilderTest() {
        String name = "ab,abc,abcd";
        String[] expect = name.split(",");
        GetNameList getNameList = new GetNameList(name);
        List<String> nameList = getNameList.getNameList();
        assertThat(getNameList.getNameList()).contains("ab","abc","abcd");
    }
}
