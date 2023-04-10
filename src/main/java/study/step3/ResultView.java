package study.step3;

public class ResultView {

    public static void resultMsg(){
        System.out.println("실행결과");
    }

    public static void moveResult(int moveCount){
        for(int i = 0; i < moveCount; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void endingRoundMsg(int round){
        System.out.println( "... "+round+ "st round end ...");
    }
}
