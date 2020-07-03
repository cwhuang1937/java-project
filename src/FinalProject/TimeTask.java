package FinalProject;
import java.util.*;

public class TimeTask extends TimerTask {
	public void run() {
	    System.out.println(++Main.howLong);
	    if(Main.isWin)
	    	System.out.println("GG");
	    
	}
	public TimeTask() {
		Main.howLong = 0;
	}
}
