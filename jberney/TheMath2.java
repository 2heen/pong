 package jberney;
 

import edu.berkeley.atdp.java.game.GameObject;
import edu.berkeley.atdp.java.game.pong.logic.PaddleLogic;
import edu.berkeley.atdp.java.game.character.NPC;
import edu.berkeley.atdp.java.game.character.PC;
import edu.berkeley.atdp.java.game.pong.character.*;

public class TheMath2 extends PaddleLogic{
	int goingThrough = 2;
	double ballY1 = 0;
	double ballY2 = 0;
	double ballX1 = 0;
	double ballX2 = 0;

 	public TheMath2(int playerIndex) {
        super(playerIndex);
    }
	public void evaluate(GameObject game) {
		goingThrough++;
		//System.out.println("This is goingThrough: " + goingThrough);
		NPC[] npcs = game.getNPCs();
		NPC ball = npcs[0];
		double[] ballPosition = ball.getPosition();
		double ballY = ballPosition[1];
		double ballX = ballPosition[0];
		PC[] pcs = game.getPCs();
		PC player = pcs[playerIndex];
		double y8 = 0;
		double y7 = 0;
		double slope; //m
		double yIntercept; //b
		double x = 0;
		double estimatedy;
		boolean goingAway = false;

		if (ball.getVelocity()[0] < 0) {
			goingAway = true;
		}
		if (ball.getVelocity()[0] > 0) {
			goingAway = false;
		}

		if (goingAway) {
			this.target = 0.5;
		}

		if (!(goingAway)) { 
			if (goingThrough % 2 == 1) {
				ballY1 = ball.getPosition()[1];
				ballX1 = ball.getPosition()[0];
			}
			if (goingThrough % 2 == 0) {
				ballY2 = ball.getPosition()[1];
				ballX2 = ball.getPosition()[0];

				slope = (ballY2 - ballY1) / (ballX2 - ballX1);
				//System.out.println("this is slope: " + slope);
				yIntercept = ballY2 - (slope * ballX2);
				estimatedy = (slope * 0.8) + yIntercept;
				//if it hits the top
				if ((estimatedy > 1) || (estimatedy == 1)) {
					//slope = -slope;
					//estimatedy = (slope * 0.8) + yIntercept;
					//estimatedy -= 1;
				}
				//if it hits te bottom
				if ((estimatedy < 0) || (estimatedy == 0)) {
					//slope = -slope;
					//estimatedy = (slope * 0.8) + yIntercept;
					//estimatedy += 1; 
				}
				//System.out.println("this is estimatedy: " + estimatedy);
				this.target = estimatedy;

				
			}
		} 

		System.out.println();
		System.out.println();

	}
}