package blackJack.card;

public enum Denomination {
    ACE     (1, "A"),
    TWO     (2, "2"),
    THREE   (3, "3"),
    FOUR    (4, "4"),
    FIVE    (5, "5"),
    SIX     (6, "6"),
    SEVEN   (7, "7"),
    EIGHT   (8, "8"),
    NINE    (9, "9"),
    TEN     (10, "10"),
    JACK    (10, "j"),
    QUEEN   (10, "q"),
    KING    (10, "k");

    private int number;
    private String viewNumber;

    Denomination(int number, String viewNumber) {
        this.number = number;
        this.viewNumber = viewNumber;
    }

    public int getNumber() {
        return number;
    }

    public String getViewNumber(){
        return viewNumber;
    }

}
