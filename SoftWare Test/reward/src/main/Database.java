package main;

import java.sql.*; //����

/*
 * ��Ҫ�ڱ��ش���һ����Ϊprizers�����ݿ�
 * ���������ű�һ����user,����name(varchar-20)��password(varchar-20)���У�
 * user���ŵ����Ѿ�ע������û�
 * ��һ����user_wait��ֻ����name(varchar-20)һ�У���������û���й������û�Ⱥ
 */
public class Database {

	private static Connection connect=null;	//���ݿ����Ӷ���
	private static String driver = "com.mysql.cj.jdbc.Driver"; //����
	private static String dbname="prizers";		//�����ӵ����ݿ�����
	private static String url="jdbc:mysql://localhost:3306/"+dbname+"?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&autoReconnect=true";//���ӵ�ַ�ַ���
	private static String username= "root";  //���ݿ��½�û���
	private static String password="root";	//���ݿ��½����
   
	//��ȡ���Ӷ���
		public static synchronized Connection getconnect() {
			//System.setProperty(driver,"");
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
	    //�ر����Ӷ���
	    public void close(){
	        try {
	            getconnect().close();
	             
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	}
