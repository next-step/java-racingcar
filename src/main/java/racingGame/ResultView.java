package racingGame;

public class ResultView {
    
    public static void forwardCarTrace(int location) {
        System.out.println();
        for (int j = 0; j < location; j++) {
            System.out.print("-");
        }
    }
    
    public static void moveDone() {
        System.out.println();
    }
}
