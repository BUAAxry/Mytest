package FirstBird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WinJPanel extends JPanel {
	int xxx = 0;// �������ĺ�����
	int c = 160; // ��������֮��ļ��

	// �����һ������
	Column c1 = new Column(320 + 100);
	// ����ڶ�������
	Column c2 = new Column(320 + 100 + c);
	// ����bird
	Bird b1 = new Bird();
	boolean start = false;// �ж���Ϸ�Ƿ�ʼ
	boolean gameover = false;// �ж���Ϸ�Ƿ������true��Ϊ����
	int score=0;		//����
	int rank=0;			//�ȼ�
	public void paint(Graphics g) {
		// ���Ʊ���
		g.drawImage(new ImageIcon("img/bg.png").getImage(), 0, 0, null);
		// ���ƹ�����
		g.drawImage(new ImageIcon("img/ground.png").getImage(), xxx, 400, null);
		// ����
		c1.painter(g);
		c2.painter(g);
		// ������bird����֤bird�����ӵ�ǰ�棬���ᱻ����
		b1.paint(g);
		
		//��������
		Font font=new Font (Font.MONOSPACED,Font.BOLD,30);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Score: "+score, 30, 50);
		g.drawString("Rank: "+rank, 30, 80);
		// ���ƽ���
		if (gameover) {
			g.drawImage(new ImageIcon("img/gameover.png").getImage(), 0, 0, null);
			//System.out.println("Gameover!");
			return; // ���ﷵ�ط�ֹ��ʼ�ͽ��������ص�
		}
		// ���ƿ�ʼ
		if (!start) {
			g.drawImage(new ImageIcon("img/start.png").getImage(), 0, 0, null);
			//System.out.println("GameStart!");
		}
	}

	@SuppressWarnings("deprecation")
	public void action(AudioPlayWave bg) throws InterruptedException {
		// ��Ӵ����������ļ���
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				//System.out.println("Click on the Mouse!");
				//System.out.println(score);
				start = true; // ������Ϸ״̬Ϊ��ʼ
				b1.y -= 30; // �����꣬bird�����ƶ�
				b1.up();	//��������
				if(gameover) {
					score=0;
					rank=0;
					gameover=false;
					start=false;
					b1=new Bird();
					c1=new Column(320+100);
					c2=new Column(320+100+180);
					bg.resume();
				}
			}
		});
		while (true) {
			System.out.flush();
			if (start) {// ��Ϸ��ʼ
				// �����ƶ�
				c1.move(rank);
				c2.move(rank);

				// bird���ƶ�
				b1.move();

				// ���ײ���ˣ�����Ϸ����
				if (b1.hit(c1, c2)) {
					start = false;
					gameover = true;
					b1.down();
					bg.suspend();
				}
				if(b1.pass(c1, c2)) {
					score++;
					if(score%6==0)
						rank++;
				}
				
				xxx--; // ��x���ƶ�
				if (xxx < -137) {
					xxx = 0;
				}
				repaint();
				Thread.sleep(1000/60);// �߳����ߣ���ֹ̫�쿴�����ƶ�
			}
		}
		//System.out.print(" ");
	}
}
