package blackJack.card;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private List<String> cardList;

    public Card() {
        cardList = new ArrayList<>();
        createCard();
    }

    public List<String> getCardList() {
        return cardList;
    }

    private void createCard() {
        for (Suit suit : Suit.values()) {
            for (Denomination denomination : Denomination.values()) {
                cardList.add(denomination.getViewNumber() + suit.getSuitName());
            }
        }
    }
}
