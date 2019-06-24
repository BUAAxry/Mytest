package manager;


import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayWave extends Thread{ //�̳�
	private	String FileName;		//�ļ���
	private Position curPosition;		//����
	private final int EXTERNAL_BUFFER_SIZE=524288;	//Ĭ��128k
	boolean flag=false;	//�жϿ�ʼ
	enum Position{		//����
		LEFT,RIGHT,NORMAL
	};
	
	//���캯��
	public AudioPlayWave(String wavFile) {
		this.FileName=wavFile;
		curPosition=Position.NORMAL;
	}
	
	public void run() {
		AudioInputStream audioInputStream =null;  //������Ƶ����������
		try {
			audioInputStream=AudioSystem.getAudioInputStream(getClass().getResource(FileName));		//������Ƶ����
		}catch(UnsupportedAudioFileException el) {
			el.printStackTrace();
			return ;
		}catch(IOException el) {
			el.printStackTrace();
			return ;
		}
		AudioFormat format=audioInputStream.getFormat();		//��Ƶ��ʽ
		SourceDataLine auline=null; 							//Դ������
		DataLine.Info info=new DataLine.Info(SourceDataLine.class, format);
		
		try {
			auline=(SourceDataLine)AudioSystem.getLine(info);
			auline.open(format);
		}catch(LineUnavailableException e){
			e.printStackTrace();
			return ;
		}catch(Exception e) {
			e.printStackTrace();
			return ;
		}
		
		if(auline.isControlSupported(FloatControl.Type.PAN)) {
			FloatControl pan=(FloatControl) auline.getControl(FloatControl.Type.PAN);
			if(curPosition==Position.RIGHT)
				pan.setValue(1.0f);
			else if(curPosition==Position.LEFT)
				pan.setValue(-1.0f);
		}
		
		auline.start();
		int nBytesRead=0;
		byte[] abData=new byte[EXTERNAL_BUFFER_SIZE];
		
		try {
			while(nBytesRead!=-1) {
				nBytesRead=audioInputStream.read(abData, 0, abData.length);
				if(nBytesRead>=0) {
					auline.write(abData, 0, nBytesRead);
				}
			}
		}catch(IOException e){
				e.printStackTrace();
				return;
		}finally{
			auline.drain();
			auline.close();
		}
		
	}
}
