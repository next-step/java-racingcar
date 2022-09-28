package car;

import java.util.List;

public interface ResultView <T extends Car> {
    void print(List<T> cars, int tryNum);
}
