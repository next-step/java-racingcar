package carracing;

public class ResultView {

    private static ResultView instance;

    public void showResultComment(int position){
        System.out.println("-".repeat(position));
    }

    public static ResultView getInstance(){
        if(instance == null){
            instance = new ResultView();
        }
        return instance;
    }

}
