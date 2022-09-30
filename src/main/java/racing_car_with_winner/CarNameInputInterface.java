package racing_car_with_winner;

public class CarNameInputInterface {
    private String question;
    private UserInterface userInterface;

    public CarNameInputInterface(String question, UserInterface userInterface) {
        this.question = question;
        this.userInterface = userInterface;
    }

    public String getInput() {
        userInterface.show(question);
        userInterface.show("\n");
        return userInterface.getStringInput();
    }
}
