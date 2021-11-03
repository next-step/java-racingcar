package step3;

public class Rule {

    private final Integer count;
    private final Integer time;

    private Rule(Integer count, Integer time) {
        this.count = count;
        this.time = time;
    }

    public static Rule from(Integer count, Integer time) {

        return new Rule(count, time);
    }

    public Integer getCount() {
        return count;
    }

    public Integer getTime() {
        return time;
    }
}
