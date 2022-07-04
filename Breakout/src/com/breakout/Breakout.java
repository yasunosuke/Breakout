package com.breakout;

import java.util.Scanner;

public class Breakout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Velocity v = new Velocity(1,1);
		Board b = new Board();
		Scanner sc = new Scanner(System.in);
		
		long time1 = System.currentTimeMillis();
		
		while(true) {
			long time2 = System.currentTimeMillis();
			if(time2 > 1000/10 + time1) {
				DrawnItem ball = b.getBall();
//				ball.setPositionX(ball.getPositionX() + v.getVelocityX());
//				ball.setPositionY(ball.getPositionY() + v.getVelocityY());
				updateBallPosition(ball, v);
				time1 = time2;
				b.draw();
			}
		}
	}
	
	private static void updateBallPosition(DrawnItem ball, Velocity v) {
		ball.setPositionX(ball.getPositionX() + v.getVelocityX());
		ball.setPositionY(ball.getPositionY() + v.getVelocityY());
		
		int ballPositionX = ball.getPositionX();
		int ballPositionY = ball.getPositionY();
		
		if(ballPositionX >= Board.BOARD_WIDTH - 1) {
			v.setVelocityX(-1);
		}
		if(ballPositionX <= 0) {
			v.setVelocityX(1);
		}
		if(ballPositionY >= Board.BOARD_HEIGHT - 1) {
			v.setVelocityY(-1);
		}
		if(ballPositionY <= 0) {
			v.setVelocityY(1);
		}
		
//	　　　　跳ね返る時に２フレーム描画する
//		int nextPositionX = ball.getPositionX() + v.getVelocityX();
//		int nextPositionY = ball.getPositionY() + v.getVelocityY();
//		
//		if()
//		
//		if(nextPositionX >= Board.BOARD_WIDTH || nextPositionX < 0) {
//			v.setVelocityX(v.getVelocityX() * -1);
//		} else if(nextPositionY >= Board.BOARD_HEIGHT || nextPositionY < 0) {
//			v.setVelocityY(v.getVelocityY() * -1);
//		} else {
//			ball.setPositionX(nextPositionX);
//			ball.setPositionY(nextPositionY);
//		}
		
	}
	
}
			
