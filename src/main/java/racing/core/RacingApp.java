package racing.core;

import racing.RandomUtil;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingApp {

    public static final String CARNAME_REGEX = ",";
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final Mover mover = new Mover();
    private final Validator validator = new Validator();

    public RacingApp() {
    }

    public void start() {
        ClientInput clientInput = inputView.getClientInput();
        List<Car> carList = makeCars(clientInput.getCarNames());
        try{
            validator.validateCarNames(carList);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            return;
        }
        resultView.printStartText();
        for (int i = 0; i < clientInput.getTryCount(); i++) {
            moveCars(carList);
            resultView.printCarList(carList);
        }
    }

    private List<Car> makeCars(String carNamesFromClient) {
        String[] carNames = carNamesFromClient.split(CARNAME_REGEX);
        return makeCars(carNames);
    }

    private List<Car> makeCars(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for(String carName : carNames){
            carList.add(new Car(carName));
        }
        return carList;
    }

    private void moveCars(List<Car> carList) {
        carList.forEach(car -> {
            int randomNum = RandomUtil.getRandomNumUnder10();
            mover.decideMove(car, randomNum);
        });
    }


}
