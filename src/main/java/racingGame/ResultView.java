package racingGame;

public class ResultView {
    
    public static void forwardCarPrint(int location) {
        System.out.println();
        for (int j = 0; j < location; j++) {
            System.out.print("-");
        }
    }
    
    public static void startPrint() {
        System.out.print("\n실행 결과");
    }
    
    public static void moveDonePrint() {
        System.out.println();
    }
}
