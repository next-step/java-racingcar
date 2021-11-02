package step3;

public class RuleDto {

    private final Long count;
    private final Long time;

    public RuleDto(Long count, Long time) {
        this.count = count;
        this.time = time;
    }

    public Long getCount() {
        return count;
    }

    public Long getTime() {
        return time;
    }
}
