package racingCar;

public class Application {
    public static void main(String[] args) {
    Input input = new Input();
    Ready ready = new Ready();

    // input
    String name = input.carName();
    int number = input.gameNumber();

    // ready
    String[] carName = ready.createPlayerList(name);
    String[] PlayerList = new String[carName.length];
    int index = 0;
    for (String n : carName) {
        PlayerList[index] = ready.checkNameLength(n);
        index++;
    }


    //
    }
}
