package FirstBird;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Column {
	int x;
	int y; 
	int speed=1;   //�����ƶ��ٶ�
	Image img;     //���ӵ�ͼƬ
	Random rd;
	
	
	//����
	public void painter(Graphics g) {
		g.drawImage(img, x, y, null);
	}
	
	//���캯��
	public Column(int gx) {
		x=gx;
		img=new ImageIcon("img/column.png").getImage();
		
		rd=new Random();
		y=-160+rd.nextInt(100);		//-160~-60
	}
	
	//�ƶ�
	public void move(int rank) {
		x-=(speed+rank);	//�ٶ�����
		if(x<-58) {		//����ͼƬ�Ŀ��
			x=320;		//����ĳ���
			y=-160+rd.nextInt(100);		//-160~-60 ,���������ӴӴ�����ഩ��֮����ʼ���»�����һ������
		}
	}
	
}
