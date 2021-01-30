package lotto;

import java.util.Arrays;
import java.util.List;

public class Values {

    private List<String> values;

    public Values(List<String> list) {
        boolean onlyNumber = list.stream().allMatch(StringUtil::isNumber);
        if (!onlyNumber) {
            throw new RuntimeException("Unexpected character contained");
        }
        this.values = list;
    }

    public List<String> getValues() {
        return values;
    }

}
