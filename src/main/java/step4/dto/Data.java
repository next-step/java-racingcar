package step4.dto;

public class Data {
    private static final int DEFAULT_COUNT = 5;
    private final String names;
    private final int count;

    public Data(String names) {
        this(names, DEFAULT_COUNT);
    }

    public Data(String names, int count) {
        this.names = names;
        this.count = count;
    }


    public String getNames() {
        return names;
    }

    public int getCount() {
        return count;
    }
}
