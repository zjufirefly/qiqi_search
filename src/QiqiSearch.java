import java.util.HashMap;
import java.util.Scanner;


public class QiqiSearch {
	String words[] = new String[2];
	// key, 汉字 value，索引
	HashMap dict_words = new HashMap();
	
	String can_read_words = new String();
	// key，汉字 value，bool
	HashMap can_read_dict_words = new HashMap();
	
	public void init_words() {
		words[0] = "人头目眉鼻";
		words[1] = "草山叶竹水";
		
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
