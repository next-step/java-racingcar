import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputDto {
    private List<String> names;
    private int numberOfAttempts;

    public InputDto(String names, String numberOfAttempts) {
        if (isBlank(names)) throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        this.names = Arrays.asList(names.split(","));
        this.numberOfAttempts = toInteger(numberOfAttempts);
    }

    public static int toInteger(String value){
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("정수만 입력이 가능합니다.");
        }
    }

    public static boolean isBlank(String x) {
        return "".equals(x) || " ".equals(x);
    }

    public List<String> getNames() {
        return this.names;
    }

    public int getNumberOfAttempts() {
        return this.numberOfAttempts;
    }
}
