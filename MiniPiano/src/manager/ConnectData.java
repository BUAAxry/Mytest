package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * static {
		try {
		java.sql.DriverManager.registerDriver(new Driver());
		} catch (SQLException E) {
			throw new RuntimeException(��Can��t register driver!��);
		}
	}
	��Class.forName�����������࣬
	��ʼִ�о�̬��ʼ������ʱ�����Զ��½�һ��Driver�Ķ���
	������DriverManager.registerDriver���Լ�
	ע�ᵽDriverManager��ȥ��֮�����Ի�ȡConnection;
 * */
/*��MYSQL���Ѿ�������һ����Ϊpianousers�����ݿ⣬
 *�ڸ����ݿ��д�����һ����Ϊuser�ı�   
 *   
 */
public class ConnectData {
	private static Connection connect=null;	//���ݿ����Ӷ���
	private static String driver = "com.mysql.cj.jdbc.Driver"; //����
	private static String dbname="pianousers";		//�����ӵ����ݿ�����
	private static String url="jdbc:mysql://localhost:3306/"+dbname+"?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";;	//���ӵ�ַ�ַ���
	private static String username= "root";  //���ݿ��½�û���
	private static String password="root";	//���ݿ��½����
	//��ȡ���Ӷ���
	private static synchronized Connection getconnect() {
		System.setProperty(driver,"");
		if(connect==null) {//�����������Ӳ�����
			try {
				Class.forName(driver);
				connect=DriverManager.getConnection(url, username, password);  //�����ݿ�����
				System.out.println("Connect DataBase sucessfully!!");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Loading Driver failed,please check it import sucessfully!!");
				e.printStackTrace();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Connect DataBase Failed!!");
			}
		}
		return connect;
	}
	public void insert(String user,String step) throws SQLException{		//SQL��insert���
		String tt="insert into users(users,steps) values('"+user+"','"+step+"')";
		PreparedStatement pstmt;
        pstmt = getconnect().prepareStatement(tt);
        pstmt.execute();
        pstmt.close();
	}
	//ִ�в�ѯ���
    public Object[][] query(String sql, boolean isSelect) throws SQLException{
    	
        PreparedStatement pstmt;
        Object[][]  tmp=new Object[1323][3];  	//��ʱ����
        int i=0;
        try {
            pstmt = getconnect().prepareStatement(sql);
            //����һ������������ѯ�����Ľ��
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
               //String name = rs.getString("name");
                //System.out.println(name);
            	/*��������
            	 * System.out.println("user : " + rs.getString(1) + " ID : "
                       + rs.getInt(2)+" steps :"+rs.getString(3));
                        */
            	tmp[i++]= new Object[] {rs.getString(1),rs.getInt(2)+"" ,rs.getString(3)};
            }
            rs.close();  		//�رռ�¼��
            pstmt.close();		//�ر�����
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmp;
    }
    
    public void query(String sql) throws SQLException{
        PreparedStatement pstmt;
        pstmt = getconnect().prepareStatement(sql);
        pstmt.execute();
        pstmt.close();
    }
     
     
    //�ر����Ӷ���
    public void close(){
        try {
            getconnect().close();
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
