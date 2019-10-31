package step1.racing;

import java.util.List;

public interface RandomListGenerator<T> {
    List<T> gacha(T size, T bound);
}
