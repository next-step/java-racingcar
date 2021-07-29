package carRacing;


public class ResultView {
    static void divideRound(int round) {
        if (round == 1) {
            System.out.println("실행결과");
        }
        System.out.println();
    }

    static void printPosition(int position) {
        StringBuilder state = new StringBuilder();

        for (int i = 0; i < position; i++) {
            state.append("-");
        }

        System.out.println(state);
    }
}
