package blackJack.function;

import blackJack.card.Denomination;
import blackJack.person.Dealer;
import blackJack.person.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Function {
    static final int BLACKJACK = 21;
    static final int SIXTEEN = 16;
    public List<Player> splitName(String players) {
        List<Player> playerList = new ArrayList<>();
        for (String player : players.split(",")) {
            playerList.add(new Player(player.trim()));
        }
        return playerList;
    }

    public int addNumber(List<String> cards) {
        int sum = 0;
        boolean hasAce = false;

        for (String card : cards) {
            String firstWord = card.substring(0, 1);
            if (firstWord.equals(Denomination.ACE.getViewNumber())) {
                hasAce = true;
            }
            if(firstWord.equals("1")){
                firstWord = "10";
            }
            sum += wordToNumber(firstWord);
        }

        if (hasAce && sum > 21) {
            sum -= 10;
        }

        return sum;
    }

    private int wordToNumber(String firstWord) {
        String pattern = "^[0-9]*$";

        if (Pattern.matches(pattern, firstWord)) {
            return Integer.parseInt(firstWord);
        }

        return changeTheAlphabet(firstWord);
    }

    private int changeTheAlphabet(String firstWord) {
        if (firstWord.equals(Denomination.ACE.getViewNumber())) {
            return Denomination.ACE.getNumber();
        }

        return 10;
    }

    public List<String> isLessThanBlackJack(Player player, List<String> cardList) {
        while (true) {
            if (player.getSum() < BLACKJACK) {
                System.out.println(player.getName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
                Scanner scanner = new Scanner(System.in);
                String agreement = scanner.nextLine();
                if (agreement.equals("n")) {
                    break;
                }
                receiveMoreCard(player, cardList.get(0));
                cardList.remove(cardList.get(0));
                System.out.println(player.getName() + "카드 : " + player.getCards());
                player.updateSum(addNumber(player.getCards()));

                if(player.getSum() > BLACKJACK){
                    break;
                }
            }
        }

        return cardList;
    }

    public void receiveMoreCard(Player player, String card) {
        player.received(card);
    }

    public void isLessThanSIXTEEN(Dealer dealer, String card) {
        if(dealer.getSum() <= SIXTEEN){
            System.out.println("딜러는 카드 한장을 더 받습니다.");
            dealer.received(card);
        }
    }

    public void compareSum(Dealer dealer, Player player){
        if(!dealer.isBurst() && (player.isBurst() || dealer.getSum() >= player.getSum())){
            dealer.addWinCount();
        }
        if(dealer.isBurst() || (!player.isBurst() && dealer.getSum() < player.getSum())){
            dealer.addLoseCount();
            player.setWin(true);
        }
    }


    public void Burst(Player player) {
        if (player.isBurst() ==true){
            player.setWin(false);
        }
    }

    public void compareDealer(Player player, Dealer dealer) {
        if (player.getSum() > dealer.getSum()){
            player.setWin(true);
        }
    }
}
