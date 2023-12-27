import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Player {
    String name;
    Queue<Card> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new LinkedList<>();
    }

    public void receiveCard(Card card) {
        cards.offer(card);
    }

    public void sortCardsByRank() {
        List<Card> sortedCards = new ArrayList<>(cards);
        sortedCards.sort(Comparator.comparingInt(this::getRankValue));
        cards.clear();
        cards.addAll(sortedCards);
    }

    private int getRankValue(Card card) {
        String[] ranksOrder = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
        return Arrays.asList(ranksOrder).indexOf(card.rank);
    }

    public String getName() {
        return name;
    }

    public Queue<Card> getCards() {
        return cards;
    }
}
