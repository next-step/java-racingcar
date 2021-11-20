package racing.basic.resolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputViewResolver {

    private static final Scanner SCANNER = new Scanner(System.in);

    public List<Integer> askQuestions(List<String> questions) {
        List<Integer> answer = new ArrayList<>();
        for (String question : questions) {
            System.out.println(question);
            int inputData = takeInput();
            answer.add(inputData);
        }
        return answer;
    }

    private int takeInput() {
        return SCANNER.nextInt();
    }
}
