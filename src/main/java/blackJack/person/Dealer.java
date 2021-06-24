package blackJack.person;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Person{

    String name;
    List<String> cards;
    int sum;
    int winCount;
    int loseCount;

    public Dealer(String name) {
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
    public int getSum(){
        return sum;
    }
    public int getWinCount(){
        return winCount;
    }
    public int getLoseCount(){
        return loseCount;
    }

    public void addWinCount(){
        winCount++;
    }
    public void addLoseCount(){
        loseCount++;
    }

    public void updateSum(int sum){
        this.sum = sum;
    }
    public void received(String card){
        cards.add(card);
    }

    public boolean isBurst() {
        if (sum > 21) {
            return true;
        }
        return false;
    }
}
