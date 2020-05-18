package step4;

import java.util.HashSet;

public class DistinctNameSet {

    private HashSet<String> distinctNameSet;

    public DistinctNameSet() {
        this.distinctNameSet = new HashSet<>();
    }

    public void assertDistinctName(String name, String errorMessage) {
        if (false == this.distinctNameSet.add(name)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
