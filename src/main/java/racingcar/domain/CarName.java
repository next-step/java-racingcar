package racingcar.domain;

class CarName {
    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    CarName(String name){
        checkNameValidation(name);
        this.name = name;
    }

    String getName(){
        return name;
    }

    private void checkNameValidation(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

}
