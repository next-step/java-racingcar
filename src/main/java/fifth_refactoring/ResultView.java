package fifth_refactoring;

public class ResultView {
    private static final String SIGN = "-";
    private static final String TITLE = "실행 결과";

    public ResultView() {
    }

    public void draw(Car car) {
        String sign = makeSign(car.getCarPosition());
        System.out.println(car.getCarName() + ":\t" + sign);
    }

    public String makeSign(int carPosition){
        String finalSign = "";
        for (int i = 0; i < carPosition; i++) {
            finalSign = finalSign.concat(SIGN);
        }
        return finalSign;
    }

    public void getTitle() {
        System.out.println(TITLE);
        return;
    }

    public void getDivideLine() {
        System.out.println("");
        return;
    }
}
