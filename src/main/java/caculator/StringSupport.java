package caculator;

public class StringSupport {

    private final String target;

    public static final String EMPTY = "";

    public static StringSupport of(final String target) {
        if(target == null) {
            throw new IllegalArgumentException("target is required.");
        }
        return new StringSupport(target);
    }

    private StringSupport(final String target) {
        this.target = target;
    }

    public String[] split(final String splitter) {
        return target.split(splitter);
    }
}
