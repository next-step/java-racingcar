package racing_car_with_winner.view;

public class CarNameInputInterface {
    private String question;
    private UserInputInterface userInterface;

    public CarNameInputInterface(String question, UserInputInterface userInterface) {
        this.question = question;
        this.userInterface = userInterface;
    }

    public String getInput() {
        userInterface.show(question);
        userInterface.show("\n");
        return userInterface.getStringInput();
    }
}
