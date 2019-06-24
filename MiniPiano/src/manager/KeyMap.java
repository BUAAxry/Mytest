package manager;

import java.util.HashMap;
import java.util.Map;

public class KeyMap {
	private Map<Object, Object> map;	//���̼�ֵ-��������Ŷ�Ӧ��
	private Map<Object, Object> smap;	//���̼�ֵ-���Ŷ�Ӧ��
	@SuppressWarnings("unused")
	private Map<Object,Object> blackmap;	//�ڼ���Ӧ��
	@SuppressWarnings("unused")
	private Map<Object,Object> whitemap;	//�׼���Ӧ��
	@SuppressWarnings("unused")
	private int black[]= {	//�ڼ�����Ӧ�ļ�ֵ
			49,50,51,52,53,54,55,56,57,48,45,61,155,36,81,87,
			69,82,84,89,85,73,79,80,91,93,92,127,65,83,68,70,71,72,74,75,
			76,59,222,44,46,47,77,32,97,98,99,100,101,102,103,107
			
	};
	private static int whitenums=52;	//�׼�����
	private static int blacknums=36;	//�ڼ�����
	//���˳��Ϊ�ȷŰ׼���źڼ�
	@SuppressWarnings("unused")
	private int white[]= {	//�׼�����Ӧ�ļ�ֵ
			78,66,
			86,67,88,90,104,105,111,106,109,37,40,39,96,110,38,35,34,33,19,
			8,123,122,121,120,119,118,117,116,115,114,113,112,192,20
	};
	private int key[]= {	//��ť��Ӧ�ļ�ֵ
			49,50,51,52,53,54,55,56,57,48,45,61,155,36,81,87,
			69,82,84,89,85,73,79,80,91,93,92,127,65,83,68,70,71,72,74,75,
			76,59,222,44,46,47,77,32,97,98,99,100,101,102,103,107,78,66,
			86,67,88,90,104,105,111,106,109,37,40,39,96,110,38,35,34,33,19,
			8,123,122,121,120,119,118,117,116,115,114,113,112,192,20
	};
	private String press[]= {		//��Ӧ�����ϵİ�ť
			"1","2","3","4","5","6","7","8","9","0","-","=","insert","home",
			"Q","W","E","R","T","Y","U","I","O","P","[","]","\\","delete",
			"A","S","D","F","G","H","J","K","L",";","'",",",".","/",
			"M","SPACE","NUM1","NUM2","NUM3","NUM4","NUM5","NUM6","NUM7",
			"NUM+","N","B","V","C","X","Z","NUM8","NUM9","NUM/","NUM*","NUM-",
			"��","��","��","NUM0","NUM.","��","end","pagedown","pageup","Pause",
			"Backspace","F12","F11","F10","F9","F8","F7","F6","F5","F4","F3",
			"F2","F1","~","CAPSLOCK"
	};
	private int value[]= {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,
			19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,
			39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,
			60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,
			81,82,83,84,85,86,87};		//��ť������а�˳��ʵ�������齨���
	public KeyMap(){
		this.map=new HashMap<>();
		this.smap=new HashMap<>();
		for(int i=0;i<key.length;i++) {		
			map.put(key[i], value[i]);		//�����̼�ֵ�Ͱ�ť�����Ӧ
			smap.put(key[i], press[i]);		//�����̼�ֵ�ͼ��̷��Ŷ�Ӧ
		}
	}
	public Object mapget(int key) {			//�õ���ֵ��Ӧ�����������
		 return map.get(key);
	}
	public boolean mapcount(int key) {		//�жϸü�ֵ�Ƿ���ڶ�Ӧ�����������
		return map.containsKey(key);
	}
	public Object smapget(int key) {	   //�õ���ֵ��Ӧ�ķ���
		 return smap.get(key);
	}
	public boolean smapcount(int key) {	  //�жϸü�ֵ�Ƿ���ڶ�Ӧ����
		return smap.containsKey(key);
	}
	public int getBlackNums() {				//�õ��ڼ���Ŀ
		return blacknums;
	}
	public int getWhiteNums() {				//�õ��׼���Ŀ
		return whitenums;
	}
}
