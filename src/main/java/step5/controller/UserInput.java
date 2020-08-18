package step5.controller;

public class UserInput {

    private String userInputForCarName ;
    private int tries;

    public UserInput(String userInputForCarName , int tries) {
        this.userInputForCarName = userInputForCarName;
        this.tries = tries;
    }

    public String getUserInputForCarName() {
        return userInputForCarName;
    }

    public int getTries() {
        return tries;
    }
}
