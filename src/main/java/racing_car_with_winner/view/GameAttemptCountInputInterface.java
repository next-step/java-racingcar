package racing_car_with_winner.view;

public class GameAttemptCountInputInterface {
    private String question;
    private UserInterface userInterface;

    public GameAttemptCountInputInterface(String question, UserInterface userInterface) {
        this.question = question;
        this.userInterface = userInterface;
    }

    public int getInput() {
        userInterface.show(question);
        userInterface.show("\n");
        return Integer.parseInt(userInterface.getStringInput());
    }
}
