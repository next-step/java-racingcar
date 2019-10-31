package step1.racing;

import java.util.List;

public interface RandomListGenerator<T extends Number> {
    List<T> gacha(int size, int bound);
}
