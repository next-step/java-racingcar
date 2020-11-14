package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OperandListTest {

    @DisplayName("OperandList 합 테스트")
    @Test
    public void test(){

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("7");
        list.add("9");
        list.add("13");

        OperandList operandList = new OperandList(list);

        assertThat(operandList.sum()).isEqualTo(30);
    }

}
