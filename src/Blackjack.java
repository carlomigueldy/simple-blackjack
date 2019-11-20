import java.util.Scanner;
import java.util.Random;

public class Blackjack {
	private static String playerName;
	private static int playerHand;
	private static int dealerHand;
	private static boolean playerTurn = true;
	private static boolean dealerTurn = true;
	private static int playerChoice;
	private static Scanner playerInput = new Scanner(System.in);
	private static Random hitCard = new Random();
	
	public static void main(String[] args) {
		startGame();
		playerTurn();
		dealerTurn();
	}
	
	/**
	 * Initialize the Blackjack 
	 */
	public static void startGame() {
		System.out.println("* Welcome to the game of Simple Blackjack!");
		System.out.println("> Please enter your name:");
		playerName = playerInput.nextLine();
		System.out.println("* Dealer deals you two cards.");
		playerHand = dealCards();
		dealerHand = dealCards();
		System.out.println("* The current value of your cards on hand is " + playerHand + ".");
	}
	
	/**
	 * Player's turn to play, to 
	 * choose between Hit or Stand.
	 */
	public static void playerTurn() {
		while(playerTurn) {
			System.out.println("> Hit (1) or Stand (0)?");
			playerChoice = playerInput.nextInt();
			if(playerChoice == 1 || playerChoice == 0) {
				
				if(playerChoice == 0) {
					playerTurn = false;
				} else {
					System.out.println("* Dealer draws a card from the deck of cards and passes it to you.");
					playerHand = playerHand + hit();
					System.out.println("* The current value of your hand is " + playerHand + ".");	
					if(playerHand > 21) {
						System.out.println("* You just lost the game.");
						break;
					}
				}

			} else {
				System.out.println("Please only select between 1 (Hit) and 0 (Stand).");				
			}			
		}
	}
	
	/**
	 * Dealer's turn to play.
	 */
	public static void dealerTurn() {
		if(!playerTurn) {
			System.out.println("* The current value of Dealer's hand is " + dealerHand + ".");
			
			if(dealerHand > 21) {
				System.out.println("* You won the game! Congratulations " + playerName + ".");
			}
			
			while(dealerTurn) {
				System.out.println("* Dealer draws a card from the deck.");
				dealerHand = dealerHand + hit();
				System.out.println("* The current value of Dealer's cards is " + dealerHand + ".");
				
				if(dealerHand > 21) {
					System.out.println("* You won the game! Congratulations " + playerName + ".");
					break;
				} else if (dealerHand > playerHand) {
					System.out.println("* The dealer won. You lost!");
					break;
				}
			}
		}
	}
	
	/**
	 * The dealer deals a random card.
	 * @return random int (between 1-10)
	 */
	public static int hit() {
		return hitCard.nextInt((10 - 1) + 1) + 1;
	}
	
	/**
	 * The dealer deals two cards.
	 * @return int
	 */
	public static int dealCards() {
		int dealCards = hit() + hit();
		return dealCards;
	}

}
