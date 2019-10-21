import java.util.Scanner;

public class Blackjack {
	private String playerName;
	private int playerHand;
	private int dealerHand;
	private boolean playerStand = true;
	private boolean dealerStand = true;
	private int playerChoice;
	private Scanner playerInput = new Scanner(System.in);
	private static Blackjack game = new Blackjack(); 
	
	public static void main(String[] args) {
		game.startGame();
		game.playerTurn();
		game.dealerTurn();
	}
	
	/**
	 * Initialize the Blackjack game.dealerStand
	 */
	public void startGame() {
		System.out.println("* Welcome to the game of Simple Blackjack!");
		System.out.println("> Please enter your name:");
		game.playerName = game.playerInput.nextLine();
		System.out.println("* Dealer deals you two cards.");
		game.playerHand = game.dealCards();
		game.dealerHand = game.dealCards();
		System.out.println("* The current value of your cards on hand is " + game.playerHand + ".");
	}
	
	/**
	 * Player's turn to play, to 
	 * choose between Hit or Stick.
	 */
	public void playerTurn() {
		while(game.playerStand) {
			System.out.println("> Hit (1) or Stick (0)?");
			game.playerChoice = game.playerInput.nextInt();
			if(game.playerChoice == 1 || game.playerChoice == 0) {
				
				if(game.playerChoice == 0) {
					game.playerStand = false;
				} else {
					System.out.println("* Dealer draws a card from the deck of cards and passes it to you.");
					game.playerHand = game.playerHand + game.hit();
					System.out.println("* The current value of your hand is " + game.playerHand + ".");	
					if(game.playerHand > 21) {
						System.out.println("* You just lost the game.");
						break;
					}
				}

			} else {
				System.out.println("Please only select between 1 (Hit) and 0 (Stick).");				
			}			
		}
	}
	
	/**
	 * It is now the dealer's turn
	 * to play. He'll try to win.
	 */
	public void dealerTurn() {
		if(!game.playerStand) {
			System.out.println("* The current value of Dealer's hand is " + game.dealerHand + ".");
			
			if(game.dealerHand > 21) {
				System.out.println("* You won the game! Congratulations " + game.playerName + ".");
			}
			
			while(game.dealerStand) {
				System.out.println("* Dealer draws a card from the deck.");
				game.dealerHand = game.dealerHand + game.hit();
				System.out.println("* The current value of Dealer's cards is " + game.dealerHand + ".");
				
				if(game.dealerHand > 21) {
					System.out.println("* You won the game! Congratulations " + game.playerName + ".");
					break;
				} else if (game.dealerHand > game.playerHand) {
					System.out.println("* The dealer won. You lost!");
					break;
				}
			}
		}
	}
	
	/**
	 * The dealer deals a random card.
	 * @return
	 */
	public int hit() {
		int randomCard = (int) (Math.random() * 10 + 1);
		return randomCard;
	}
	
	/**
	 * The dealer deals two cards.
	 * @return
	 */
	public int dealCards() {
		int dealCards = hit() + hit();
		return dealCards;
	}

}
