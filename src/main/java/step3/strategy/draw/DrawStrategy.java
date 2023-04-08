package step3.strategy.draw;

import step3.domain.Position;

public interface DrawStrategy {
    String draw(Position position);
    void clear();
}
