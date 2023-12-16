package racingcar.manager;

public class Manager {
    private static Manager instance;
    public static Manager getInstance(){
        if (instance == null){
            instance = new Manager();
        }
        return instance;
    }
    private UIManager uiManager = new UIManager();
    private GameManager gameManager = new GameManager();

    public UIManager uiManager() {
        return uiManager = instance.uiManager;
    }
    public GameManager gameManager() {
        return gameManager = instance.gameManager;
    }
}
