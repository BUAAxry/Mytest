package manager;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.SQLException;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowData {
	  JPopupMenu popupMenu;	
	  JFrame jf = new JFrame("");
	  public JTable table;
	  Object[][] tableData = new Object[][] {};
	  //����һά������Ϊ�б���
	  Object[] columnTitle = {"username" , "ID","steps" };
	  public void init()
	  {
	    //�Զ�ά�����һά����������һ��JTable����
	    table = new JTable(tableData , columnTitle);
	    //��JTable�������JScrollPane�У�������JScrollPane���ڴ�������ʾ����
	    jf.getContentPane().add(new JScrollPane(table));    
	    jf.setTitle("ShowData");
	    jf.pack();
	    jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    jf.setVisible(true);
	    ///�����Ҽ��˵�
	    popupMenu = new JPopupMenu();
	    addPopup(table, popupMenu);
	    
	    JMenuItem delMenItem = new JMenuItem();	//�Ҽ���Ŀ
	    
	    delMenItem.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mousePressed(MouseEvent e) {
	    		
	    		
	    	}
	    });
	    
        delMenItem.setText("Loading");
        popupMenu.add(delMenItem);
	  }
	  public ShowData() {
		  ConnectData  cnt=new ConnectData();
			try {
				this.tableData=cnt.query("select * from users", true); //��ѯ���ݵ����
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    this.init();
	   
	  }
	
	private void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
				if (e.isMetaDown()) {
					int focusedRowIndex = table.rowAtPoint(e.getPoint());
		            if (focusedRowIndex == -1) {		//ѡ�в��ܣ�
		                return;
		            }
		            //�������ѡ����Ϊ��ǰ�Ҽ��������
		            table.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);
		            //�����˵�
		            popupMenu.show(table, e.getX(), e.getY());
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
