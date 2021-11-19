package step4.dto;

import step4.dto.count.Count;

public interface RunStrategy {
    public boolean runnable(Count count);
}
