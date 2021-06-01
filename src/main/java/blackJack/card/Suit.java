package blackJack.card;

public enum Suit {
    CLUBS("클로버"),
    DIAMONDS("다이아몬드"),
    HEARTS("하트"),
    SPADES("스페이드");

    private String suitName;

    Suit(String suitName) {
        this.suitName = suitName;
    }

    public String getSuitName() {
        return suitName;
    }


}
