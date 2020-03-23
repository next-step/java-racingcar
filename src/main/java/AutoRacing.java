import domain.GameRole;
import ui.InputView;

public class AutoRacing {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        GameRole gameRole = inputView.getGameRole();
        gameRole.playGame();
    }


}
