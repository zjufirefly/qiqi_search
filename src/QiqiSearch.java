import java.util.HashMap;
import java.util.Scanner;


public class QiqiSearch {
	String words[] = new String[5];
	// key, 汉字 value，索引
	HashMap dict_words = new HashMap();
	
	String can_read_words = new String();
	// key，汉字 value，bool
	HashMap can_read_dict_words = new HashMap();
	
	public void init_words() {
		words[0] = "人头目眉鼻耳口牙舌心手足身一二三四五六七八九十马牛羊鱼虫鸟天日月云风雨雪雷电田木米果瓜禾苗森林石亭花";
		words[1] = "草山叶竹水土方圆尖大小高长弓刀勺面豆气分半点出入例外开关多少上下弯直来去吃喝吐立坐走飞看问哭笑车门井";
		words[2] = "伞包布皮书画灯光衣裙袜裤鞋帽毛巾工厂灭火灰尘家爷奶妈爸哥弟姐妹我你男女前后左右东西南北中宋郑李徐刘陈";
		words[3] = "吴郭赵胡章婆伯叔姨阿视迷球国京兴空发脸孔眼睛朵齿嘴巴双脚腿铃正腰好您请茶给孩儿们和不见喊纱回今午读题";
		words[4] = "图线圈号课骑钓枪汤肉芽冬柿条饭铺玉梅苹糕床他她是就辆张盏件块本个颗只支服红黄黑绿蓝围色生窗未袋偶爱剪";
		
		
		int count = 1;
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				dict_words.put(words[i].charAt(j), count);
				count++;
			}
		}
		
	}
	
	public void init_can_read_words() {
		can_read_words = "人山";
		for (int i = 0; i < can_read_words.length(); i++) {
			can_read_dict_words.put(can_read_words.charAt(i), true);
		}
	}
	
	public static void main(String[] args) {
		QiqiSearch search = new QiqiSearch();
		search.init_words();
		search.init_can_read_words();
		
		System.out.println("Please input words");
		while (true) {
			//创建输入对象
			Scanner sc = new Scanner(System.in);
	  
			//获取用户输入的字符串
			String input = null;
			System.out.println("请输入任意句子, 输入exit退出");
			System.out.print(">>> ");
			input=sc.nextLine();
			if (input.equals("exit")) {
				return;
			}
			
			System.out.println("");
			System.out.println("查询结果如下");
			for (int i = 0; i < input.length(); i++) {
				System.out.print(input.charAt(i));
				System.out.print("    ");
				System.out.print(search.dict_words.get(input.charAt(i)));
				System.out.print("    ");
				if (search.can_read_dict_words.get(input.charAt(i)) != null) {
					System.out.println("yes");
				} else {
					System.out.println("");
				}
			}
			System.out.println("");
		}

	}

}
