package step3.view;

public class ResultView {

    public ResultView(){
        System.out.println("실행결과");
    }

    public void showPositionHistory(int moveCount){
        for(int i = 1; i <= moveCount; i++){
            System.out.print("-");
        }
        System.out.println("");
    }

}
