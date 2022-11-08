package racingcar.view;

import racingcar.domain.RaceInput;
import racingcar.exception.CarNameEmptyException;
import racingcar.exception.CarNameOverSizeException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static racingcar.utils.ValidateUtil.validateCarNames;

public class RaceInputView {

    private final BufferedReader reader;

    public RaceInputView() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    // 자동차 경주 정보를 사용자로 부터 입력받음
    public RaceInput generateRaceInput() {
        RaceInput raceInput = null;
        try {
            raceInput = userInput();
            validateCarNames(raceInput.getCarNames());
        } catch (CarNameEmptyException e) {
            System.out.println("자동차는 1대 이상이어야 합니다.");
            return generateRaceInput();
        } catch (CarNameOverSizeException e) {
            System.out.println("자동차 이름은 5자를 초과할 수 없다.");
            return generateRaceInput();
        } catch (Exception e) {
            return generateRaceInput();
        }
        return raceInput;
    }

    public RaceInput userInput() throws IOException {
        RaceInput raceInput = new RaceInput();
        raceInput.setCarNames(getCarNamesFromUser().split(","));
        raceInput.setTryCount(getTryCountsFromUser());
        System.out.println();
        return raceInput;
    }

    private String getCarNamesFromUser() throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        return reader.readLine().replace(" ","");
    }

    private int getTryCountsFromUser() throws IOException {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return Integer.parseInt(reader.readLine());
    }

}
