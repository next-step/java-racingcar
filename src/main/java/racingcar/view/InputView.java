package racingcar.view;

public interface InputView {
    int getRounds();
    int getPlayers();
    String[] getNames();
    boolean askQuestions();
    void askNumberOfPlayers();
    void askNameOfPlayers();
    void askNumberOfRounds();
}
