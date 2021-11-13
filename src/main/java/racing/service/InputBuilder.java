package racing.service;

import racing.view.Input;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputBuilder {

    private List<String> nameList ;

    public List<String> getNameList() {
        return nameList;
    }
    public InputBuilder(String input) {
        List<String> nameList = convertInput(input);
        this.nameList = nameList;
        while(nameLengthCheck(nameList)) {
            System.out.println("이름의 길이가 5를 초과하는게 존재합니다.");
            Scanner scanner = new Scanner(System.in);
            String nameString = scanner.nextLine();
            nameList = convertInput(nameString);
            this.nameList = nameList;
        }
    }

    public List<String> convertInput(String input) {
        String[] name = input.split(",");
        List<String> nameList = Arrays.asList(name);
        return nameList;
    }

    public boolean nameLengthCheck(List<String> nameList) {
        Integer criteria = 5;
        return nameList.stream().anyMatch(i -> i.length() > criteria);
    }
}
