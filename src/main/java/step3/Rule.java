package step3;

public class Rule {

    private final Long count;
    private final Long time;

    private Rule(Long count, Long time) {
        this.count = count;
        this.time = time;
    }

    public static Rule from(Long count, Long time) {

        return new Rule(count, time);
    }

    public Long getCount() {
        return count;
    }

    public Long getTime() {
        return time;
    }
}
