package extra;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * Create the frame.�ô���������ʾ�û�������Ϣ
 *   ����ע����Ϣ����½��Ϣ���Լ��н���Ϣ
 */
@SuppressWarnings("serial")
public class RegMessage extends JFrame {
	private JFrame frame;
	private String str;
	public RegMessage(String st) {
		str=st;
		init();
	}
	
	public void init() {
		frame= new JFrame();
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//�ر�ʱ���漰������
		frame.setBounds(100, 100, 391, 145);
		frame.getContentPane().setLayout(null);
		
		JLabel lbla = new JLabel(str);
		lbla.setFont(new Font("����", Font.PLAIN, 23));
		lbla.setBounds(25, 13, 301, 51);
		frame.getContentPane().add(lbla);
	}
}
