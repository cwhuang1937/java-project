package FinalProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//import sun.audio.AudioData;
//import sun.audio.AudioPlayer;
//import sun.audio.AudioStream;
//import sun.audio.ContinuousAudioDataStream;

public class Main implements ActionListener{
	public static GameMap map;
	public static int stage = 1;
	public static Timer timer;
	public static int howLong = 0;
	public static boolean isWin = false;
	public static void main(String[] args) {
		new Main(0);
//		music();
		timer = new Timer();
		timer.schedule(new TimeTask(), 0, 1000);
		System.out.println("???");
	}
	
	public Main(int temp) {
		isWin = false;
		stage = temp;
//		map = new GameMap(stage);
//		map.setExtendedState(JFrame.NORMAL);
		if(stage==0) {
			map = new Stage0();
			map.setSize(860,810);	
		}
		else if(stage==1) {
			map = new Stage1();
			map.setSize(738,610);	
		}
		else if(stage==2) {
			map = new Stage2();
			map.setSize(678,550);
		}
		else if(stage==3) {
			map = new Stage3();
			map.setSize(738,490);
		}
		else if(stage==4) {
			map = new Stage4();
			map.setSize(738,550);
		}
		
		
		
		URL iURL = getClass().getResource("/resources/icons/laba.png");
		ImageIcon icon = new ImageIcon(iURL);
		map.setIconImage(icon.getImage());
		map.setTitle("Baba is You");
		map.setLocationRelativeTo(null);
		map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuItem re, one, two, three, four;
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenu subMenu = new JMenu("Choose Stage");
		re = new JMenuItem("Restart");
		one = new JMenuItem("One");
		two = new JMenuItem("Two");
		three = new JMenuItem("Three");
		four = new JMenuItem("Four");
//		menu.setSize(300, 500);
		menu.add(re);
		subMenu.add(one);
		subMenu.add(two);
		subMenu.add(three);
		subMenu.add(four);
		re.addActionListener(this);
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this);
		bar.add(menu);
		menu.add(subMenu);
//		bar.setSize(300, 200);
		map.setJMenuBar(bar);
		map.setVisible(true);
		
		Thread t = new MyThread();
		t.start();
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Restart")) {
//			System.out.println("Restart");
			map.dispose();
			new Main(stage);
		}
		if(e.getActionCommand().equals("One")) {
//			System.out.println("111");
			map.dispose();
			new Main(1);
		}
		if(e.getActionCommand().equals("Two")) {
//			System.out.println("222");
			map.dispose();
			new Main(2);
			howLong = 0;
		}
		if(e.getActionCommand().equals("Three")) {
//			System.out.println("333");
			map.dispose();
			new Main(3);
			howLong = 0;
		}
		if(e.getActionCommand().equals("Four")) {
//			System.out.println("444");
			map.dispose();
			new Main(4);
			howLong = 0;
		}
		
		
	}

//	public static void music() 
//    {       
//        AudioPlayer MGP = AudioPlayer.player;
//        AudioStream BGM;
//        AudioData MD;
//        ContinuousAudioDataStream loop = null;
//
//        try
//        {
//            InputStream test = new FileInputStream("./bin/resources/musics/bgm.wav");
//            BGM = new AudioStream(test);
//            AudioPlayer.player.start(BGM);
////            MD = BGM.getData();
////            loop = new ContinuousAudioDataStream(MD);
//
//        }
//        catch(FileNotFoundException e){
//            System.out.print(e.toString());
//        }
//        catch(IOException error)
//        {
//            System.out.print(error.toString());
//        }
//        MGP.start(loop);
//
//    }
}
