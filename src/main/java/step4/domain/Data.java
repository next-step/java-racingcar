package step4.domain;

public class Data {
    final static int defaultCount = 5;
    final String names;
    final int count;

    public Data(String names) {
        this(names, defaultCount);
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

    public String[] spliteName(String separator) {
        return names.split(separator);
    }
}
