package step5.domain;

import java.util.*;
import java.util.stream.Collectors;

public class UsingNameCarRacingInformation {

    private final List<UsingNameRacingCar> racingCarList;
    private final Reps reps;

    private UsingNameCarRacingInformation(List<UsingNameRacingCar> racingCarList, Reps reps) {
        this.racingCarList = racingCarList;
        this.reps = reps;
    }

    public static UsingNameCarRacingInformation of(String inputCarName, int numberOfReps) {
        return new UsingNameCarRacingInformation(makeRacingCarList(inputCarName), Reps.of(numberOfReps));
    }

    private static List<UsingNameRacingCar> makeRacingCarList(String inputCarName) {
        hasCarName(inputCarName);
        List<String> carNameList = getCarNameList(inputCarName);
        hasSameName(carNameList);
        hasLength(carNameList);

        return carNameList.stream()
                .map(UsingNameRacingCar::of)
                .collect(Collectors.toList());
    }

    private static List<String> getCarNameList(String inputCarName) {
        return Arrays.asList(inputCarName.split(Separator.SPLIT_CAR_NAME_SEPARATOR.getSeparator()));
    }

    private static void hasLength(List<String> carNameList){
        if(carNameList.isEmpty()){
            throw new IllegalArgumentException("자동차 이름을 입력해주세요");
        }
    }

    private static void hasCarName(String inputCarName) {

        if(inputCarName == null){
            throw new IllegalArgumentException("자동차 이름을 입력해주세요");
        }

        if (inputCarName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요");
        }
    }

    private static void hasSameName(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);

        if (carNameSet.size() != carNameList.size()) {
            throw new IllegalArgumentException("같은 이름이 있습니다");
        }
    }

    public Reps getCurrentReps() {
        return reps;
    }

    public List<UsingNameRacingCar> getRacingCarList() {
        return racingCarList;
    }

    public boolean isContinue() {
        return reps.isOverZero();
    }

    public List<String> getWinner(){
        int winnerLocation = getWinnerLocation();

        return racingCarList.stream()
                .filter(racingCar -> racingCar.getCurrentLocation() == winnerLocation)
                .map(UsingNameRacingCar::getName)
                .collect(Collectors.toList());

    }

    public int getWinnerLocation() {
        return racingCarList.stream()
                .mapToInt(UsingNameRacingCar::getCurrentLocation)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
