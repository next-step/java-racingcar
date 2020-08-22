package step3.view;

public class ResultView {

    public void startResult(){
        System.out.println("실행결과");
    }

    public void showPosition(int moveCount){
        for(int i = 0; i < moveCount; i++){
            System.out.print("-");
        }
        System.out.println("");
    }

}