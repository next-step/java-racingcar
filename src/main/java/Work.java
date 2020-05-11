import java.util.Optional;

public class Work {
    public static void main(String[] args) {

        String input = "2 + 3 * 4 / 2";
        String[] strings = input.split("");

    }
    private String[] StringParser(String input) {
        return Optional.ofNullable(input)
                .filter(i -> !i.trim().isEmpty())
                .map(i -> input.split(""))
                .orElseThrow(IllegalArgumentException::new);
    }
}
