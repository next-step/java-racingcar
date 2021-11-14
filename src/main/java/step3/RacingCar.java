package step3;

public class RacingCar {
    public static int i = 0;
    private static int j = 0;

    public static void CarCount() {
        for(i=0;i<InputView.input1;i++){
            CarForward();
            ResultView.Result();
        }
    }

    public static void CarForward() {
        for(j=0;j<InputView.input2;j++){
            if((int)(Math.random() * 100) + 1>4){
                InputView.go[i] +="-";
            }
        }
    }
}
