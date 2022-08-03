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
		
//		上の壁
		for(int i = 0; i < BOARD_WIDTH + 2; i++) {
			System.out.print("□");
		}
		System.out.println("");
		
		for(int i = 0; i < BOARD_HEIGHT; i++) {
//			左の壁
			System.out.print("□");
			for(int j = 0; j < BOARD_WIDTH; j++) {
				System.out.print(screen[i][j]);
			}
//			右の壁
			System.out.println("□");
		}
//		下の壁
		for(int i = 0; i < BOARD_WIDTH + 2; i++) {
			System.out.print("□");
		}
		System.out.println("");
		
	}
	
	public void updateBallPosition(Velocity v) {
		this.ball.setPositionX(this.ball.getPositionX() + v.getVelocityX());
		this.ball.setPositionY(this.ball.getPositionY() + v.getVelocityY());
		
		int ballPositionX = this.ball.getPositionX();
		int ballPositionY = this.ball.getPositionY();
		
		int paddlePositionX = this.paddle.getPositionX();
		int paddlePositionY = this.paddle.getPositionY();
		
//		壁とのあたり判定
		if(ballPositionX >= BOARD_WIDTH - 1) {
			v.setVelocityX(-1);
		}
		if(ballPositionX <= 0) {
			v.setVelocityX(1);
		}
		if(ballPositionY >= BOARD_HEIGHT - 1) {
			v.setVelocityY(-1);
		}
		if(ballPositionY <= 0) {
			v.setVelocityY(1);
		}
		
//		パドルとの当たり判定
		if((ballPositionY <= paddlePositionY) 
				&& (ballPositionY >= paddlePositionY - 1) 
				&& (ballPositionX >= paddlePositionX) 
				&& (ballPositionX < paddlePositionX + this.paddle.getWIDTH())) {
			v.setVelocityY(-1);
		}
		
//		ブロックとの当たり判定
		for(int i = -1; i <= 1; i++) {
			int x = ballPositionX + i;
			if(x < 0 || x >= BOARD_WIDTH) {
				continue;
			}
			
			if(this.field[ballPositionY][x].equals("■")) {
			this.field[ballPositionY][x] = "　";
			v.setVelocityY(1);
		    }
		}
		
	}
	
//	ボールを追跡するためにパドルの位置を更新するメソッド
	public void updatePaddlePosition() {
//		パドルの壁との当たり判定
//		ボールとパドルの真ん中を合わせる
		int nextPaddlePositionX = this.ball.getPositionX() - 1;
		if(nextPaddlePositionX + this.paddle.getWIDTH() - 1 >= BOARD_WIDTH) {
			this.paddle.setPositionX(nextPaddlePositionX - 1);
		} else if(nextPaddlePositionX < 0) {
			this.paddle.setPositionX(0);
		} else {
			this.paddle.setPositionX(nextPaddlePositionX);
		}
		
		
	}
	
	public boolean isFailed() {
		if(this.ball.getPositionY() == BOARD_HEIGHT - 1) {
			return true;
		}
		return false;
	}
	
	public boolean isCompleted() {

		for(int i = 0; i < BLOCK_RANGE_Y; i++) {
			for(int j = 0; j < BOARD_WIDTH; j++) {
				if(this.field[i][j].equals("■")) {
					return false;
				}
			}
		}
		return true;
	}
	
	public int countBlocks() {
		
		int defaultBlocks = 0;
		for(int i = 0; i < BLOCK_RANGE_Y; i++) {
			for(int j = 0; j < BOARD_WIDTH; j++) {
				if(this.defaultField[i][j].equals("■")) {
					defaultBlocks++;
				}
			}
		}
		
		int brokenBlocks = 0;
		for(int i = 0; i < BLOCK_RANGE_Y; i++) {
			for(int j = 0; j < BOARD_WIDTH; j++) {
				if(this.field[i][j].equals("■")) {
					brokenBlocks++;
				}
			}
		}
		
		return defaultBlocks - brokenBlocks;
	}
	
	
}
