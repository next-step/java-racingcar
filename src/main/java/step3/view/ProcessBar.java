package step3.view;

import java.util.List;

public class ProcessBar {
    private final List<String> bars;
    public ProcessBar(List<String> bars) {
        this.bars =bars;
    }

    public List<String> getBars() {
        return bars;
    }
}
