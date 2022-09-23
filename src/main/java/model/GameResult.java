package model;


public class GameResult {

    private final String result;

    public GameResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void show() {
        System.out.println(this.result);
    }
}