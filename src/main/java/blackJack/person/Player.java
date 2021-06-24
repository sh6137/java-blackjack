package blackJack.person;

import java.util.ArrayList;
import java.util.List;

public class Player extends Person {
    String name;
    List<String> cards;
    int sum;
    //    boolean isBurst = false;
    boolean isWin = false;

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

    public int getSum() {
        return sum;
    }

    public void updateSum(int sum) {
        this.sum = sum;
    }

    public void received(String card) {
        cards.add(card);
    }

    public boolean isBurst() {
        if (sum > 21) {
            return true;
        }
        return false;
    }

    public String getWin() {
        if (isWin) {
            return "승";
        }
        return "패";
    }

    public void setWin(boolean win) {
        isWin = win;
    }
//
//    public boolean isWin() {
//        return isWin;
//    }
}
