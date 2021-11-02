package step3;

public class RuleDto {

    private final Long count;
    private final Long time;

    private RuleDto(Long count, Long time) {
        this.count = count;
        this.time = time;
    }

    public static RuleDto from(Long count, Long time) {

        return new RuleDto(count, time);
    }

    public Long getCount() {
        return count;
    }

    public Long getTime() {
        return time;
    }
}
