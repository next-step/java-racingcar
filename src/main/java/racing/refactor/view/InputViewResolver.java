package racing.refactor.view;

import racing.refactor.dto.RequestGameCreation;

import java.io.PrintStream;
import java.util.*;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class InputViewResolver {

    private static final int CAR_NAMES_LOCATION = 0;
    private static final int LOOP_COUNT_LOCATION = 1;
    private static final String COMMA = ",";

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final PrintStream PRINT_STREAM = System.out;

    public RequestGameCreation askQuestions(List<String> questions) {
        List<String> answers = new ArrayList<>();
        for (String question : questions) {
            PRINT_STREAM.println(question);
            String inputData = takeInput();
            answers.add(inputData);
        }
        return bindingToDto(answers);
    }

    public RequestGameCreation bindingToDto(List<String> answers) {
        String answerNames = answers.get(CAR_NAMES_LOCATION);
        List<String> carNames = Arrays.stream(answerNames.split(COMMA))
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));

        String loopCountToString = answers.get(LOOP_COUNT_LOCATION);
        int loopCount = Integer.parseInt(loopCountToString);

        return new RequestGameCreation(carNames, loopCount);
    }

    private String takeInput() {
        return SCANNER.nextLine();
    }
}
