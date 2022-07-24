package com.breakout;

import java.io.IOException;

public class Board {
	static final int BOARD_HEIGHT = 32;
	static final int BOARD_WIDTH = 16;
	static final int BLOCK_RANGE_Y = 8;
	private DrawnItem ball = new Ball("●", 8, 16, 1, 1);
	private DrawnItem paddle = new Paddle("□", 7, BOARD_HEIGHT - 2, 1, 3);
	private String[][] defaultField = {
			{ "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■" },
			{ "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■" },
			{ "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■" },
			{ "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■" },
			{ "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■" },
			{ "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■" },
			{ "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■" },
			{ "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■", "■" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" },
			{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" } };

	private String[][] field = new String[BOARD_HEIGHT][BOARD_WIDTH];
	private String[][] screen = new String[BOARD_HEIGHT][BOARD_WIDTH];
	
	{
		for(int i = 0; i < defaultField.length; i++) {
			field[i] = defaultField[i].clone();
		}
	}

	public void draw() {
		
		//fieldをscreenにコピー。前のscreenの捨てるなぜならボールやパドルを再描画しないといけないため
		for(int i = 0; i < field.length; i++) {
			screen[i] = field[i].clone();
		}
		
		screen[ball.getPositionY()][ball.getPositionX()] = ball.getCharacter();
		
		for(int i = 0; i < paddle.getWIDTH(); i++) {
			screen[paddle.getPositionY()][paddle.getPositionX() + i] = paddle.getCharacter();
		}
		
//		codes for clear-screen
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < BOARD_HEIGHT; i++) {
			for(int j = 0; j < BOARD_WIDTH; j++) {
//				switch(defaultField[i][j]) {
//				case "B": System.out.print("■"); break;
//				case "Ball": System.out.print("●"); break;
//				default: System.out.print(" "); break;
//				}
				System.out.print(screen[i][j]);
			}
			System.out.println("");
		}
		
	}
	
	public DrawnItem getBall() {
		return ball;
	}

	public DrawnItem getPaddle() {
		return paddle;
	}

	public void drawBlock() {
		for(int i = 0; i < BLOCK_RANGE_Y; i++) {
			for(int j = 0; j < BOARD_WIDTH; j++) {
				defaultField[i][j] = "B";
			}
		}
	}
	
	private void moveBall() {
		
	}
}
