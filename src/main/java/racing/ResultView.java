package racing;


public class ResultView {

    private final CarRacing carRacing;

    public ResultView(CarRacing carRacing) {
        this.carRacing = carRacing;
    }

    public void showView(){
        System.out.println("실행결과");
        for (int i = 0; i < carRacing.getRacingCount(); i++) {
             carRacing.step().forEach(System.out::println);
        }
        System.out.println();
    }
}
