package cc.oakk.racing;

import cc.oakk.racing.controller.GameManager;

public class RacingApplication {
    public static void main(String[] args) {
        GameManager manager = new GameManager();
        manager.start();
    }
}
