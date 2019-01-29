import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Draw extends JComponent{

	private BufferedImage image;
	private BufferedImage backgroundImage;
	private URL resource = getClass().getResource("run0.png");

	public int x = 250;
	public int y = 350;

	public int state = 0;

	public Draw(){
		try{
			image = ImageIO.read(resource);
			backgroundImage = ImageIO.read(getClass().getResource("bcks.jpg"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void reloadImage(){

		state++;

		if(state == 0){
			resource = getClass().getResource("run0.png");
		}
		else if(state == 1){
			resource = getClass().getResource("run1.png");
		}
		else if(state == 2){
			resource = getClass().getResource("run2.png");
		}
		else if(state == 3){
			resource = getClass().getResource("run3.png");
		}
		else if(state == 4){
			resource = getClass().getResource("run4.png");
		}
		else if(state == 5){
			resource = getClass().getResource("run5.png");
			state = 0;
		}

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void jump(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 4; ctr++){
					try{
						if(ctr==3){
							resource = getClass().getResource("run0.png");
							y = y + 15;
						}
						else{
							resource = getClass().getResource("jump"+ctr+".png");
							y = y - 5;
						}

						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(100);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		});
		thread1.start();
	}

	public void swrdAttack(){
		Thread thread2 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 11; ctr++){
					try{
						if(ctr==10){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("swrdAttack"+ctr+".png");
						}

						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(50);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		});
		thread2.start();
	}

	public void bowAttack(){
		Thread thread3 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 9; ctr++){
					try{
						if(ctr==8){
							resource = getClass().getResource("bow0.png");
						}
						else{
							resource = getClass().getResource("bow"+ctr+".png");
						}

						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(100);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		});
		thread3.start();
	}

	public void punch(){
		Thread thread4 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 13; ctr++){
					try{
						if(ctr==12){
							resource = getClass().getResource("punch0.png");
						}
						else{
							resource = getClass().getResource("punch"+ctr+".png");
						}

						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(100);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		});
		thread4.start();
	}

	public void kick(){
		Thread thread5 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 8; ctr++){
					try{
						if(ctr==7){
							resource = getClass().getResource("punch0.png");
						}
						else{
							resource = getClass().getResource("kick"+ctr+".png");
						}

						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(100);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		});
		thread5.start();
	}

	public void cast(){
		Thread thread6 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 6; ctr++){
					try{
						if(ctr==5){
							resource = getClass().getResource("punch0.png");
						}
						else{
							resource = getClass().getResource("cast"+ctr+".png");
						}

						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(100);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		});
		thread6.start();
	}

	public void roll(){
		Thread thread7 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 4; ctr++){
					try{
						if(ctr==3){
							resource = getClass().getResource("punch0.png");
							y = y + 15;
						}
						else{
							resource = getClass().getResource("smrslt"+ctr+".png");
							y = y - 5;
							x = x + 10;
						}

						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(100);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		});
		thread7.start();
	}

	public void moveDown(){
		y = y + 5;
		reloadImage();
		repaint();
	}
	public void moveRight(){
		x = x + 5;
		reloadImage();
		repaint();
	}
	public void moveLeft(){
		x = x - 5;
		reloadImage();
		repaint();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, this);
		g.drawImage(image, x, y, this);	
	}
}