package racingcar;

public class ResultView {
    private static final String START_RESULT_MESSAGE = "실행 결과";

    public static void drawResult(Cars cars){
        cars.stream().forEach(car -> {
            System.out.println(drawEachCar(car.getStatusLine()));
        });
        System.out.println("");
    }

    private static String drawEachCar(int statusLine) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<statusLine; i++){
            sb.append("-");
        }
        return sb.toString();
    }

    public static String startResultMessage(){
        return START_RESULT_MESSAGE;
    }
}
