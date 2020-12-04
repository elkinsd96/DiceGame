//
//Daniel Elkins
//CSC 160 Computer Science 
//December 11, 2020
//Dice Game: 30 or Bust!
//

package Project;

import java.util.Scanner; 

public class DiceGame {
	
	public static void main (String[] args) {
	
		
		//Creates Scanner variable named "scanner" 
		final Scanner scanner = new Scanner(System.in);
		
		//Explains rules of the game
		System.out.println("Welcome to 30 or Bust! Here are the rules: Two players will face off against each other with each player taking turns rolling two dice.");
		
		System.out.println("When rolled, the players can either keep the value of one of their dice or keep the total of both dice which will be added to their total score.");
		
		System.out.println("The first player who accumulates a score of 30 wins! But be careful, as going over 30 will reset your score back to 0!");
		
		System.out.println("Also if a player enters any input other than the inputs instructed by the game, their turn will be skipped.");
		
		System.out.println("Without further ado, let the game begin!");
		
		System.out.println(" ");
		
		System.out.println("Hello, what is the name of the first player? ");
		
		//String variable named "player1_name" that equals scanner 
		String player1_name = scanner.nextLine();
		
		System.out.println("What is the name of the second player? ");
		
		//String variable named "player2_name" that equals scanner
		String player2_name = scanner.nextLine();
		
		//Creates new Player object named "player1" that contains player1_name parameter and scanner parameter
		final Player player1 = new Player(player1_name, scanner);
		
		//Creates new Player object named "player2" that contains player1_name parameter and scanner parameter		
		final Player player2 = new Player(player2_name, scanner);
		
		
		System.out.println("Welcome players " + player1_name + " and " + player2_name+ "!");
		
		System.out.println("Here we go!");	
	
		System.out.println("  "); 
		
		//While loop that loops while parameter is true 
		while (true) {
			
			//Checks if Player One's turn returns as specific value declared in the takeTurn method
			if (player1.takeTurn()) {
				
				System.out.println("Congratulations, Player " + player1.getName() + " wins!");
				
				break;
			}
		
			//Checks if Player Two's turn returns as specific value declared in the takeTurn method
			if (player2.takeTurn()) {
				
				System.out.println("Congratulations, Player " + player2.getName() + " wins!");
				
				break;
			}
		}	
	}
	

	//Private class named "Player" 
	private static class Player{
	
		//Private scanner named "scanner"
		private final Scanner scanner;
	
		//Private string data field named "name"
		private final String name; 
	
		//Private integer data field named "score"
		private int score;
	
		//Private method named "Player" with multiple parameters
		private Player(final String name, final Scanner scanner) {
		
			//Sets private scanner equal to Player parameter scanner
			this.scanner = scanner;
		
			//Sets private string name equal to Player parameter name
			this.name = name;
		
			}
	

		//Public boolean method named "takeTurn"
		public boolean takeTurn() {
	
			//Integer variable named "current_score" that is equal to 0
			int current_score = 0;
	
			//While loop that loops as long as player's overall score plus current score is less than 30
			while(this.score + current_score < 30) {
		
			System.out.println("Player " + this.name + ", it is your turn!"); 
			
			System.out.println("Player " + this.name + "'s score: " + this.score);
			
			//Integer variable named "dice_1" that returns a random number between 1 and 6
			final int dice_1 = (int)(1 + Math.random() * 6);
			
			//Integer variable named "dice_2" that returns a random number between 1 and 6
			final int dice_2 = (int)(1 + Math.random() * 6);
			
			//Integer variable named "total" that's equal to the sum of dice_1 and dice_2
			final int total = dice_1 + dice_2;
			
			System.out.println("Player " + this.name + "'s roll:");
			
			System.out.println("Die 1: " + dice_1);
			
			System.out.println("Die 2: " + dice_2);
			
			System.out.println("Total: " + total);
			
			System.out.println("Do you wish to (1) Keep die 1, (2) Keep die 2, (3) Keep the total? (Respond with 1 or 2 or 3): ");
			
			//String variable named "v_answer" that's equal to private string answer
			String v_answer = this.answer();
			
			
			//If statement that checks if v_answer is equal to "1" 
			if(v_answer.equals("1")) {
				
				//Sets current_score equal to the sum of current_score and dice_1
				current_score += dice_1;
				
				//Sets private int score equal to the sum of score and current_score
				this.score += current_score;
				
				//If statement that checks if private int score is greater than 30 
				if (this.score > 30) {
					
					System.out.println("Player " + this.name + "'s total: " + this.score + ", your score is now reset to 0!");
					
					//Sets private int score equal to zero
					this.score = 0; 
						
					System.out.println(" ");
					
					break;
				
					}
				
				System.out.println("Player " + this.name + "'s score: " + this.score);
				
				System.out.println(" ");
				
				break;	
				
				} 
			
			//Else-If statement that checks if v_answer is equal to "2"
			else if(v_answer.equals("2")) {
				
				//Sets current_score equal to the sum of current_score and dice_2
				current_score += dice_2;
				
				//Sets private int score equal to the sum of score and current_score
				this.score += current_score;
				
				//If statement that checks if private int score is greater than 30			
				if (this.score > 30) {
					
					System.out.println("Player " + this.name + "'s total: " + this.score + ", your score is now reset to 0!");
					
					//Sets private int score equal to zero
					this.score = 0; 
					
					System.out.println(" ");
					
					break;
					
					}
				
				System.out.println("Player " + this.name + "'s score: " + this.score);
				
				System.out.println(" ");
				
				break;	
				
				}
			
			//Else-If statement that checks if v_answer is equal to "3"
			else if(v_answer.equals("3")) {
				
				//Sets current_score equal to the sum of current_score and total
				current_score += total;
				
				//Sets private int score equal to the sum of score and current_score
				this.score += current_score;
				
				//If statement that checks if private int score is greater than 30
				
				if (this.score > 30) {
					
					System.out.println("Player " + this.name + "'s total: " + this.score + ", your score is now reset to 0!");
					
					//Sets private int score equal to zero
					this.score = 0; 
					
					System.out.println(" ");
					
					break;
					
					}
				
				System.out.println("Player " + this.name + "'s score: " + this.score);
				
				System.out.println(" ");
				
				break;	
					
				} 
			
			else {
				
				//Informs user of invalid input and that their turn has been skipped to prevent cheating
				System.out.println("Invalid input. Player " + this.name + "'s turn has been skipped.");
					
				System.out.println(" ");
					
				break; 
					
				}
			
			}
		
		//Returns a true or false value to takeTurn if score equals 30
		return(this.score == 30);
		
		}
	
		//Private string method named "answer"
		private String answer() {
			
			//Returns private scanner
			return this.scanner.next();
			}
	
		//Private string method named "getName"
		public String getName() {
			
			//Returns private string name
			return this.name;
			}
	
	}
}

	


	
