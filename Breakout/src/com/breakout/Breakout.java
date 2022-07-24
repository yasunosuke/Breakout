package com.breakout;

import java.util.Scanner;

public class Breakout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Velocity v = new Velocity(1,1);
		Board board = new Board();
		Scanner sc = new Scanner(System.in);
		
		long time1 = System.currentTimeMillis();
		
		while(true) {
			long time2 = System.currentTimeMillis();
			if(time2 > 1000/10 + time1) {
				DrawnItem ball = board.getBall();
				DrawnItem paddle = board.getPaddle();
//				ball.setPositionX(ball.getPositionX() + v.getVelocityX());
//				ball.setPositionY(ball.getPositionY() + v.getVelocityY());
				updateBallPosition(ball, paddle, v);
				updatePaddlePosition(ball, paddle);
				time1 = time2;
				board.draw();
			}
		}
	}
	
	private static void updateBallPosition(DrawnItem ball, DrawnItem paddle, Velocity v) {
		ball.setPositionX(ball.getPositionX() + v.getVelocityX());
		ball.setPositionY(ball.getPositionY() + v.getVelocityY());
		
		int ballPositionX = ball.getPositionX();
		int ballPositionY = ball.getPositionY();
		
		int paddlePositionX = paddle.getPositionX();
		int paddlePositionY = paddle.getPositionY();
		
//		壁とのあたり判定
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
		
//		パドルとの当たり判定
		if((ballPositionY <= paddlePositionY) 
				&& (ballPositionY >= paddlePositionY - 1) 
				&& (ballPositionX >= paddlePositionX) 
				&& (ballPositionX < paddlePositionX + paddle.getWIDTH())) {
			v.setVelocityY(-1);
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
	
//	ボールを追跡するためにパドルの位置を更新するメソッド
	private static void updatePaddlePosition(DrawnItem ball, DrawnItem paddle) {
//		パドルの壁との当たり判定
//		ボールとパドルの真ん中を合わせる
		int nextPaddlePositionX = ball.getPositionX() - 1;
		if(nextPaddlePositionX + paddle.getWIDTH() - 1 >= Board.BOARD_WIDTH) {
			paddle.setPositionX(nextPaddlePositionX - 1);
		} else if(nextPaddlePositionX < 0) {
			paddle.setPositionX(0);
		} else {
			paddle.setPositionX(nextPaddlePositionX);
		}
		
		
	}
	
}
			
