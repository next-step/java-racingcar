package carracing.view;

import carracing.domain.Name;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String QUESTION_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_NUMBER_OF_RACES = "시도할 회수는 몇회인가요?";
    private static final String STR_SEPARATOR = ",";
    private List<Name> names;

    private int track;

    public InputView() {
        question();
    }

    public InputView(String answer, int track) {
        this.names = seperator(answer);
        this.track = track;
    }

    public List<String> getNames() {
        return names.stream().map(Name::getName).collect(Collectors.toList());
    }

    public int getTrack() {
        return track;
    }

    public void question() {
        String answer = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println(QUESTION_CAR_NAMES);
        answer = scanner.nextLine();
        this.names = seperator(answer);
        System.out.println(QUESTION_NUMBER_OF_RACES);
        this.track = scanner.nextInt();
    }

    public List<Name> seperator(String answer) {
        List<Name> names = new ArrayList<>();
        String[] split = answer.split(STR_SEPARATOR);
        for (int i = 0; i < split.length; i++) {
            names.add(new Name(split[i]));
        }
        return names;
    }
}
