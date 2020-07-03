package FinalProject;

import java.awt.event.KeyEvent;

public class Stage2 extends GameMap {
	public Stage2() {
		super(2);
	}
	public void keyPressed(KeyEvent e) {

//		music("move");
		int currentX = you.getX()/SIZE;
		int currentY = you.getY()/SIZE;
		//set move
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && currentX < mapWidth-1) {
			// detect water
			if( currentX+1<mapWidth && mapId[currentY][currentX+1]=="water_p" ) {
				failCall();
				return;
			}
			else if( currentX+2<mapWidth && mapId[currentY][currentX+2]=="water_p"  && pushList.contains(mapId[currentY][currentX+1])) {
				cancelFlag = 0;
				mapId[currentY][currentX+2] = "black";
				mapIdTrans[currentY][currentX+2] = "black";
				moveItem(currentX,currentY,"right");
				mapLabel[currentY][currentX+2].setIcon(null);
				mapId[currentY][currentX+2] = "black";
				mapIdTrans[currentY][currentX+2] = "black";
			}
			else
				moveItem(currentX,currentY,"right");
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT && currentX > 0) {
			if( currentX-1>=0 && mapId[currentY][currentX-1]=="water_p" ) {
				failCall();
				return;
			}
			else if( currentX-2>=0 && mapId[currentY][currentX-2]=="water_p"  && pushList.contains(mapId[currentY][currentX-1])) {
				cancelFlag = 0;
				mapId[currentY][currentX-2] = "black";
				mapIdTrans[currentY][currentX-2] = "black";
				moveItem(currentX,currentY,"left");
				mapLabel[currentY][currentX-2].setIcon(null);
				mapId[currentY][currentX-2] = "black";
				mapIdTrans[currentY][currentX-2] = "black";
			}
			else {
				moveItem(currentX,currentY,"left");
			}			
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN && currentY < mapHeight-1) {
			if( currentY+1<mapHeight && mapId[currentY+1][currentX]=="water_p" ) {
				failCall();
				return;
			}
			else if( currentY+2<mapHeight && mapId[currentY+2][currentX]=="water_p"  && pushList.contains(mapId[currentY+1][currentX])) {
				cancelFlag = 0;
				mapId[currentY+2][currentX] = "black";
				mapIdTrans[currentY+2][currentX] = "black";
				moveItem(currentX,currentY,"down");
				mapLabel[currentY+2][currentX].setIcon(null);
				mapId[currentY+2][currentX] = "black";
				mapIdTrans[currentY+2][currentX] = "black";
			}			
			else
				moveItem(currentX,currentY,"down");
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP && currentY > 0) {
			if( currentY-1>=0 && mapId[currentY-1][currentX]=="water_p" ) {
				failCall();
				return;
			}
			else if( currentY-2>=0 &&  mapId[currentY-2][currentX]=="water_p"  && pushList.contains(mapId[currentY-1][currentX])) {
				cancelFlag = 0;
				mapId[currentY-2][currentX] = "black";
				mapIdTrans[currentY-2][currentX] = "black";
				moveItem(currentX,currentY,"up");
				mapLabel[currentY-2][currentX].setIcon(null);
				mapId[currentY-2][currentX] = "black";
			}
			else
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
