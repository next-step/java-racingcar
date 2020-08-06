package step3.dto;

public class Car {
    private int entryNumber;
    private int position;

    private final String NAME_TAG_SEPERATOR_SEMICOLLON = "|";
    private final String NAME_TAG_EMTPY_SPACE = "    ";

    private Car(int entryNumber, int position) {
        this.entryNumber = entryNumber;
        this.position = position;
    }

    public static Car participateRacing(int entryNumber, int position){
        return new Car(entryNumber, position);
    }

    public void movePosition(){
        position++;
    }

    public int nowPosition(){
        return position;
    }

    public String getEntryNameTag(){
        return makeNameTag();
    }

    private String makeNameTag(){
        String entryNumber = getEntryNumberToString();
        StringBuilder nameTag = new StringBuilder();
        int length = entryNumber.length();

        String newPrefix = NAME_TAG_EMTPY_SPACE.substring(length);
        nameTag.append(entryNumber).append(newPrefix);
        nameTag.append(NAME_TAG_SEPERATOR_SEMICOLLON);

        return nameTag.toString();
    }
    private String getEntryNumberToString() {
        return String.valueOf(entryNumber);
    }
}
