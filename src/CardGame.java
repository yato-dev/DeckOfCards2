import java.util.LinkedList;
import java.util.Queue;






public class CardGame {
    public static void main(String[] args) {
        Queue<Player> playersQueue = new LinkedList<>();
        Deck deck = new Deck();

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");
        Player player4 = new Player("Player 4");

        
        playersQueue.offer(player1);
        playersQueue.offer(player2);
        playersQueue.offer(player3);
        playersQueue.offer(player4);

        deck.shuffle();

        for (int i = 0; i < 9; i++) {
            for (Player player : playersQueue) {
                Card drawnCard = deck.drawCard();
                if (drawnCard != null) {
                    player.receiveCard(drawnCard);
                }
            }
        }


        for (Player player : playersQueue) {
            player.sortCardsByRank();
        }


        for (Player player : playersQueue) {
            System.out.println("Player: " + player.getName());
            System.out.println("Cards: " + player.getCards());
            System.out.println();
        }
    }
}
