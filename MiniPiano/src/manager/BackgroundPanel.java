package manager;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

class BackgroundPanel extends JPanel  
{  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image im;  
    public BackgroundPanel(Image im)  
    {  
        this.im=im;  
        this.setOpaque(true);                    //���ÿؼ���͸��
    }  
    
    //Draw the background again
    public void paintComponent(Graphics g)       //��ͼ��
    {  
        super.paintComponents(g);  
        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);   //��̬��ȡ����С	

    }  
}

