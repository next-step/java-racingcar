package step2;

import step2.model.Input;

import java.util.List;

public class StringCalculateCalculator {

    public int executeCalculator(Input input) {
        List<String> inputList = input.getInputList();

        if (inputList.size() == 0) {
            return 0;
        }

        return inputList.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
