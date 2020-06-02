package racing.util;

import java.util.ArrayList;
import java.util.List;

public class ListCopier {

    public static List<Integer> copyList(List<Integer> input) {
        return new ArrayList<>(input);
    }
}
