package FinalProject;

import java.awt.event.KeyEvent;

public class Stage4 extends GameMap {
	public Stage4() {
		super(4);
	}
	public void keyPressed(KeyEvent e) {
//		music("move");
		int currentX = you.getX()/SIZE;
		int currentY = you.getY()/SIZE;
		//set move
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && currentX < mapWidth-1) {
			//detect the key is_push or not
			if( currentX+2<mapWidth && mapId[currentY][currentX+2]=="door_p" && openList.contains(mapId[currentY][currentX+1]) && pushList.contains(mapId[currentY][currentX+1])) {
				cancelFlag = 0;
				mapId[currentY][currentX+2] = "black";
				mapIdTrans[currentY][currentX+2] = "black";
				moveItem(currentX,currentY,"right");
				mapLabel[currentY][currentX+2].setIcon(null);
				mapId[currentY][currentX+2] = "black";
				mapIdTrans[currentY][currentX+2] = "black";
			}
			else if( currentX+1<mapWidth && mapId[currentY][currentX+1]=="door_p" && pushList.contains(mapId[currentY][currentX+1]) ) {
		        for(String stop : stopList){
		            if(stop.equalsIgnoreCase("door_p"))
		                stopList.remove(stop);
		        }
			    moveItem(currentX,currentY,"right");
			}
			else
				moveItem(currentX,currentY,"right");
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT && currentX > 0) {			
			if( currentX-1>=0 && mapId[currentY][currentX-1]=="door_p" && pushList.contains(mapId[currentY][currentX-1]) ) {
				//delete the door_p in stoplist
		        for(String stop : stopList){
		            if(stop.equalsIgnoreCase("door_p"))
		                stopList.remove(stop);
		        }
			    moveItem(currentX,currentY,"left");
			}
			else {
				moveItem(currentX,currentY,"left");
			}			
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN && currentY < mapHeight-1) {
			if( currentY+1<mapHeight && mapId[currentY+1][currentX]=="door_p" && pushList.contains(mapId[currentY+1][currentX]) ) {
				//delete the door_p in stoplist
		        for(String stop : stopList){
		            if(stop.equalsIgnoreCase("door_p"))
		                stopList.remove(stop);
		        }
			    moveItem(currentX,currentY,"down");
			}
			else
				moveItem(currentX,currentY,"down");
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP && currentY > 0) {
			if( currentY-1>=0 &&  mapId[currentY-1][currentX]=="door_p" && pushList.contains(mapId[currentY-1][currentX]) ) {
				//delete the door_p in stoplist
		        for(String stop : stopList){
		            if(stop.equalsIgnoreCase("door_p"))
		                stopList.remove(stop);
		        }
			    moveItem(currentX,currentY,"up");
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
	public boolean judgeOpenDoor(int nextX,int nextY) {
		if(openList.size() != 0)
			if(openList.contains(mapId[nextY][nextX]))
				return true;
		return false;
	}
}
