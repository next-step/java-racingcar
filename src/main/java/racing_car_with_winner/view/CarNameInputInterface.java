package racing_car_with_winner.view;

public class CarNameInputInterface {
    private static final String QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private UserInputInterface userInterface;

    public CarNameInputInterface(UserInputInterface userInterface) {
        this.userInterface = userInterface;
    }

    public String getInput() {
        userInterface.show(QUESTION);
        userInterface.show("\n");
        return userInterface.getStringInput();
    }
}
