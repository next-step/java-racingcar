package racingcar.view;

import racingcar.dto.RacingCarGameRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String CAR_NAME_DELIMITER = ",";
    private final BufferedReader br;

    public InputView() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public RacingCarGameRequest getUserInput() throws IOException {
        List<String> carNameList = getParticipatingCarNames();
        int playCount = getPlayingCount();
        return new RacingCarGameRequest(playCount, carNameList);
    }

    private List<String> getParticipatingCarNames() throws IOException {
        System.out.println("자동차 이름을 쉼표(,)로 구분하여 입력해주세요");
        String[] carNames = br.readLine().trim().split(CAR_NAME_DELIMITER);
        return Arrays.asList(carNames);
    }

    private int getPlayingCount() throws IOException {
        while(true){
            System.out.println("시도할 회수는 몇 회 인가요?");
            String countInString = br.readLine().trim();
            try {
                return Integer.parseInt(countInString);
            } catch (NumberFormatException ex){
                System.out.println("잘못입력하셨습니다. 숫자를 입력하세요");
            }
        }
    }
}
