import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame implements KeyListener{

	Draw myDraw = new Draw();

	public MyFrame(){
		this.myDraw = new Draw();
	}

	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP){
			myDraw.moveUp();
			System.out.println("position: " + myDraw.x + "," + myDraw.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			myDraw.moveDown();
			System.out.println("position: " + myDraw.x + "," + myDraw.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			myDraw.moveRight();
			System.out.println("position: " + myDraw.x + "," + myDraw.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			myDraw.moveLeft();
			System.out.println("position: " + myDraw.x + "," + myDraw.y);
		}
	}

	public void keyReleased(KeyEvent e){

	}
	public void keyTyped(KeyEvent e){

	}

	public static void main(String[] args) {
		MyFrame gameFrame = new MyFrame();
		
		gameFrame.setSize(600, 600);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().add(gameFrame.myDraw);
		gameFrame.addKeyListener(gameFrame);
		System.out.println("Practical Programming");	
	}
}