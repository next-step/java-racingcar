package step3;

public class CarRace {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.init();

        Circuit circuit = new Circuit(inputView.getNameList(), inputView.getRounds());

        System.out.println("실행 결과");
        while (circuit.lap()) {
            ResultView.printStatus(circuit.getCars().stream());
            System.out.println();
        }

        ResultView.printWinner(circuit.getWinners().stream());

    }

}
