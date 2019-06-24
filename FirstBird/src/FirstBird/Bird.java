package FirstBird;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Bird {
	int x;
	int y;
	int i;  //ָ��bird��ͼƬ
	Image img;
	
	//����ͼƬ
	public void paint(Graphics g) {
		g.drawImage(img, x, y, null);
	}
	
	//����
	public Bird() {
		x=120;
		y=240;
		i=0;
		img=new ImageIcon("img/"+i+".png").getImage();
	}
	
	public void move() {
		y++;
		i++;
		i%=3;
		img=new ImageIcon("img/"+i+".png").getImage();
	}
	
	//��ײ����
	public boolean hit(Column c1,Column c2) {
		//���Ӹ߶�Ϊ296����϶����Ϊ108�����Ϊ58
		//bird�Ŀ��Ϊ38,�߶�Ϊ35(y�᷽��)
		if(y<=0 ||y>=390) {		//������ײ
			System.out.println("Hit the sky or the ground!!!");
			return true;
		}
		if(x+38>=c1.x &&x<=c1.x+58 &&(y<=c1.y+296 || y+35>=c1.y+296+108)) {
			//System.out.println("Hit the first Column!!!");
			return true;
		}
		if(x+38>=c2.x &&x<=c2.x+58 &&(y<=c2.y+296 || y+35>=c2.y+296+108)) {
			//System.out.println("Hit the second Column!!!");
			return true;
		}
		return false;
	}
	
	public boolean pass(Column c1,Column c2) {
		return x==c1.x+58 ||x==c2.x+58;
	}
	public void up() {
		AudioPlayWave play=new AudioPlayWave ("fei.wav");
		play.start();
	}
	public void down() {
		AudioPlayWave play=new AudioPlayWave ("deg.wav");
		play.start();
	}
}
