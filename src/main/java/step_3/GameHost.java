package step_3;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class GameHost {

    private final static Scanner scanner = new Scanner(System.in);
    private final static StringBuffer stringBuffer = new StringBuffer();

    private GameHost() {
    }

    public static int howManyCars() {
        speak("자동차 대수는 몇 대 인가요?");

        return scanner.nextInt();
    }

    public static int howManyPlay() {
        speak("룰렛을 던질 횟수는 몇 회 인가요?");

        return scanner.nextInt();
    }

    public static void presentation(List<Integer> forwardHistories) {
        forwardHistories.forEach(forwardHistory -> {
            IntStream.range(0, forwardHistory).forEach(index -> stringBuffer.append("-"));
            speak(stringBuffer.toString());
            stringBuffer.delete(0, stringBuffer.length());
        });
        speak("");
    }

    public static void speak(String dialogue) {
        System.out.println(dialogue);
    }
}
