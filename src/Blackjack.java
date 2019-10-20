import java.util.Scanner;

public class Blackjack {
	private String playerName;
	private int playerCash = 2000;
	private int playerBet;
	private int playerHand;
	private int dealerHand;
	private boolean playerStick = true;
	private boolean dealerStick = true;
	private int playerChoice;
	private Scanner playerInput = new Scanner(System.in);

	public static void main(String[] args) {
		Blackjack game = new Blackjack(); 
		
		/**
		 * Initialize game.
		 */
		System.out.println("* Welcome to the game of Simple Blackjack!");
		System.out.println("> Please enter your name:");
		game.playerName = game.playerInput.nextLine();
		System.out.println("* So your name is, " + game.playerName + ".");
		System.out.println("* Let's start!");
		System.out.println("* Game initializing ... /n");
		System.out.println("* The dealer deals you two cards.");
		System.out.println("* The dealer has now two cards as well.");
		game.playerHand = game.initCards();
		game.dealerHand = game.initCards();
		System.out.println("* The current value of your cards at hand is " + game.playerHand + ".");
		
		/**
		 * Let the player decide to hit or stick.
		 */
		while(game.playerStick) {
			System.out.println("> Hit (1) or Stick (0)?");
			
			game.playerChoice = game.playerInput.nextInt();
			if(game.playerChoice == 1 || game.playerChoice == 0) {
				
				if(game.playerChoice == 0) {
					game.playerStick = false;
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
		
		if(!game.playerStick) {
			System.out.println("* The current value of Dealer's hand is " + game.dealerHand + ".");
			if(game.dealerHand > 21) {
				System.out.println("* You won the game! Congratulations " + game.playerName + ".");
			}
			
			while(game.dealerStick) {
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
	 * Draw a card from the deck.
	 * @return randomized int
	 */
	public int hit() {
		int randomCard = (int)(Math.random() * 10 + 1);
		return randomCard;
	}
	
	/**
	 * Initial state of the game.
	 * @return cards at hand.
	 */
	public int initCards() {
		int initCards = hit() + hit();
		return initCards;
	}

}
