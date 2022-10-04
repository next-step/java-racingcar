package racing_car_with_winner.view;

public class GameAttemptCountInputInterface {
    private String question;
    private UserInputInterface userInterface;

    public GameAttemptCountInputInterface(String question, UserInputInterface userInterface) {
        this.question = question;
        this.userInterface = userInterface;
    }

    public int getInput() {
        userInterface.show(question);
        userInterface.show("\n");
        return Integer.parseInt(userInterface.getStringInput());
    }
}
