package step2;

import java.util.List;

public interface Parser<T> {

    List<T> parse(List<String> elements);
}
