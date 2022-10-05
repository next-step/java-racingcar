package racing_car_with_winner.view;

public class GameAttemptCountInputInterface {
    private static final String QUESTION = "시도할 회수는 몇회인가요?";
    private UserInputInterface userInterface;

    public GameAttemptCountInputInterface(UserInputInterface userInterface) {
        this.userInterface = userInterface;
    }

    public int getInput() {
        userInterface.show(QUESTION);
        userInterface.show("\n");
        return Integer.parseInt(userInterface.getStringInput());
    }
}
