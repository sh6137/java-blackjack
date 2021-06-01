package blackJack.person;

import blackJack.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Player extends Person{
    String name;
    List<String> cards;

    public Player(String name) {
        super(name);
        this.name = name;
        cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getCards() {
        return cards;
    }

    public void received(String card){
        cards.add(card);
    }


}
