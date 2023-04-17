package step3;

public class Controller {


    public void main(){
        Input input = new Input();

        int raceCount = input.inputRaceCount();
        int carCount = input.inputCarCount();

        System.out.println("실행결과");
        Race.from(raceCount, carCount).race();
    }
}
