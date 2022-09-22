import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Numbers {
    private List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean containsNegative() {
        return numbers.stream().anyMatch(number -> number < 0);
    }

    public int sum() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public static Numbers of(String numbers) {
        if (hasNoNumber(numbers)) {
            return new Numbers(Collections.emptyList());
        }

        return new Numbers(Arrays.stream(numbers.split("[,:]"))
                                 .mapToInt(Integer::parseInt)
                                 .boxed()
                                 .collect(Collectors.toList()));
    }

    private static boolean hasNoNumber(String numbers) {
        return numbers == null || numbers.trim().isBlank();
    }
}
