package main;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import extra.RegMessage;
public class Mysql {

    private Connection conn;//���Ӷ���
    private Statement state;//����
    private ResultSet setForLogin,setForReg,setForPrize;// ��ʱ   +  ���
    /*
     * usr����������
     * name,password
     * user_wait����ֻ����δ�й������û�
     * */
    public Mysql() {
    	conn=Database.getconnect();
    }
    //�ж�����û��Ƿ��Ѿ��й���
    public void queryPrize(String name)throws SQLException{
    	String SQL="select * from user_wait where name ='"+name+"';";
		boolean flag=true;
    	try {
    		//��ʱ�Ѿ��ǵ�½��ģ�����������һ�����ڸ��û�
    		conn=Database.getconnect();
    		state=conn.createStatement();
			setForPrize=state.executeQuery(SQL);
			if(setForPrize.next())
				flag=true;//δ�й���
			else
				flag=false;//�й���
    	}finally {
			setForPrize.close();
			//conn.close();
		}
    	if(!flag) {
    		@SuppressWarnings("unused")
    		RegMessage passwordfail=new RegMessage("���Ѿ��й����������ٴγ齱");
    	}
	//	return flag;//�й�����
    }
    //���н����û��Ӵ��齱�û�Ⱥ��ȥ��
    public void queryDone(String name)throws SQLException{
   		String SQL="delete from user_wait where name='"+name+"';";
    	try {
    		conn=Database.getconnect();
    		state=conn.createStatement();
			state.executeUpdate(SQL);
    	}
    	finally {
			//conn.close();
    	}
    }
    //���û�������齱�û�Ⱥ
    public void queryAddWait(String name)throws SQLException{
    	String SQL="insert into user_wait values('"+name+"');";
    	try {
    		conn=Database.getconnect();
    		state=conn.createStatement();
			state.executeUpdate(SQL);
    	}
    	finally {
			//conn.close();
    	}
    }
    //�ж�����û��Ƿ�ע�����
    public boolean queryRegister(String name) throws SQLException {
    	String SQL="select * from user where name ='"+name+"';";
    	boolean flag=true;
    	try {
    		conn=Database.getconnect();
			state=conn.createStatement();
			setForReg=state.executeQuery(SQL);
			if(setForReg.next())
			{
				@SuppressWarnings("unused")
				RegMessage nameused=new RegMessage("�û����Ѿ���ʹ�ã�\n");
	        	flag=true;
			}else
				flag=false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//conn.close();
			setForReg.close();
		}
    	
    	return flag;//δע��
    }
    //��ע��ɹ����û��������ݿ���
    public void queryAddNew(String name,String password) throws SQLException {
		String SQL="insert into user(name,password) values('"+name+"','"+password+"');";
    	try {
    		conn=Database.getconnect();
    		state=conn.createStatement();
    		state.executeUpdate(SQL);
    		@SuppressWarnings("unused")
    		RegMessage RegSuccess=new RegMessage("ע��ɹ���\n");
    	}
    	finally {
			//conn.close();
    	}
    }
	//�ж�����û��ܷ��½�ɹ�
    public boolean queryLogin(String name,String password) {
    	String SQL="select * from user where name ='"+name+"';";
    	boolean flag=true;
    	try {
    	conn=Database.getconnect();
    	state=conn.createStatement();
    	setForLogin=state.executeQuery(SQL);
        if(!setForLogin.next()) {
        	@SuppressWarnings("unused")
			RegMessage namefail=new RegMessage("�û���������");
        	flag=false;
        }
        //��ȡ��Ӧ�û���������
        if(flag && setForLogin.getString("password").compareTo(password)!=0) {
        	@SuppressWarnings("unused")
			RegMessage passwordfail=new RegMessage("�������");
        	flag=false;
        }
    	}catch (Exception e) {
            e.printStackTrace();
    	}finally {
            try {
            	//conn.close();
            	setForLogin.close(); 
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
    	if(flag) {
    		@SuppressWarnings("unused")
			RegMessage passwordfail=new RegMessage("��½�ɹ�");
    	}
    	return flag;
        //���Ե�½
    }
     
}
