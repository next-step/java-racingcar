import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public List<String> parse(String given) {
        if (given == null || given.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.stream(given.split("[,:]"))
                .collect(Collectors.toList());
    }
}
