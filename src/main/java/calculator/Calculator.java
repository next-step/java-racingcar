package calculator;

import java.util.List;

public interface Calculator {
    List<String> input();
    void printInputInformation();
    int calculate(List<String> input);
}