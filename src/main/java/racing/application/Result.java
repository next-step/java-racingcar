package racing.application;

import java.util.List;

public interface Result<T> {
    List<String> judge(List<T> players);
}
