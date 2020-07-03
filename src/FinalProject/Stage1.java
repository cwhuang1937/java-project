package FinalProject;

import java.awt.event.KeyEvent;

public class Stage1 extends GameMap {
	public Stage1() {
		super(1);
	}
	public void keyPressed(KeyEvent e) {

//		music("move");
		int currentX = you.getX()/SIZE;
		int currentY = you.getY()/SIZE;
		//set move
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && currentX < mapWidth-1) {
			    moveItem(currentX,currentY,"right");
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT && currentX > 0) {
				moveItem(currentX,currentY,"left");
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN && currentY < mapHeight-1) {
				moveItem(currentX,currentY,"down");
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP && currentY > 0) {
				moveItem(currentX,currentY,"up");
		}
		else 
			return;
		
		if(judgeWin(you.getX()/SIZE, you.getY()/SIZE)) {
			winCall();
			return;
		}
		// renew stopList and pushList
		setStopPushList();
		
		//renew transList 
		setTranList();
		judgeWho(currentX,currentY);
		judgeYouSurrounding();

	}
}
