package racinggame.domain.vo;

import java.util.List;

public class WinnersVo {
    private final List<String> winners;

    public WinnersVo(final List<String> winners) {
        this.winners = winners;
    }

    public List<String> get() {
        return this.winners;
    }
}
