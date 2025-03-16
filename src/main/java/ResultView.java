import java.util.List;

public class ResultView {

    public static void printRace(Racing racing) {
        System.out.println("실행 결과");

        for (List<String> score : racing.getScore()) {
            priceScore(score);
            System.out.println("\n");
        }


    }

    private static void priceScore(List<String> score) {
        for (String s : score) {
            System.out.println(s);
        }
    }
}
