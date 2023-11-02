package study.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserNumbers {

    private final List<UserNumber> userNumbers;

    public UserNumbers(List<UserNumber> userNumbers) {
        this.userNumbers = userNumbers;
    }

    public static UserNumbers from(List<String> strings) {
        List<UserNumber> collect = strings.stream().map(UserNumber::from).collect(Collectors.toList());
        return new UserNumbers(collect);
    }

    public int sum() {
        return userNumbers.stream().mapToInt(UserNumber::number).sum();
    }
}
