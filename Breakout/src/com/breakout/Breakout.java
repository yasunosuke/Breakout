package com.breakout;

import java.util.Scanner;

public class Breakout {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			Velocity v = new Velocity(1,1);
			Board board = new Board();
			
			long time1 = System.currentTimeMillis();
			
			while(true) {
				
				long time2 = System.currentTimeMillis();
				
				if(time2 > 1000/10 + time1) {

					board.updateBallPosition(v);
					board.updatePaddlePosition();
					
					time1 = time2;
					
					board.draw();
					
					if(board.isFailed()) {
						System.out.println("Game Over!");
						System.out.println("You Broke " + board.countBlocks() + " Blocks!");
						break;
					}
					
					if(board.isCompleted()) {
						System.out.println("Completed!");
						break;
					}
				}
			}
			
			if (isOneMoreGame(sc)) {
				continue;
			} else {
				System.out.println("See you again!");
				break;
			}
		}
	}
			
	private static boolean isOneMoreGame(Scanner sc) {
		
		while (true) {
			System.out.println("Wanna Continue? : Yes---1 No---0");
			try {
				int input = Integer.parseInt(sc.nextLine());
				if (0 <= input && input <= 1) {
					if (input == 1) {
						return true;
					} else {
						return false;
					}
				} else {
					System.out.println("Incorrect Input! Please Enter again.");
				}
				
			} catch (NumberFormatException e) {
				System.out.println("Incorrect Input! Please Enter again.");
			}
		}
	}
	
}
			
