import java.util.HashMap;
import java.util.Scanner;


public class QiqiSearch {
	String words[] = new String[15];
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
		words[5] = "箱角台背机器吸汽炮箭兵类极滑冷痰向现很羽过亮乌打刮滴把闪路进退底青蛙这桥子树河地麦消害许房做盆片竿短";
		words[6] = "坡散边蛋要用太阳的真更溪碧鲜艳早晨旁在美丽燕有还白枝了样院久没班级借知识算魔术讲完成拿着老师事故听懂";
		words[7] = "趣得觉起始专朋友象踢庭亲能够游泳盼望跑步蹦跳唱歌活泼快乐那些像什么怎病都想学校排队穿旗升城广播星送礼";
		words[8] = "敬最响声祖说到瞧也菜额卷紧唇饱同岁拖饿擦汗帮助干净明聪夸奖自己年龄卡贺彩虹慢岭荷变化蝴蝶舞蹈梦乡吞湖";
		words[9] = "颜再洗谁呢比赛对市节季春夏秋枯笔烈遮挡撑落降秘密取暖泥堆从滚玻璃常非鸭等于带斤江终猫爪买尺捉虾猴戏作";
		words[10] = "业渴捡纸童呀哎瓦装船划放轻松挂钩晴朗间时候岸可以感谢喜欢两群尾兔养怕狗猎咬萝卜喂猪惊慌每次屋为因公主";
		words[11] = "其他运动激选择微如熊加参刺猬辣椒填晚傍漂流哪棵迎接粗细桃核泪种结束摘梨错会拉差活力抓此苦新闻行粮食瓶";
		words[12] = "灌血管丢失假期脑千万集合雀收藏铅拍姑娘玩具踩坏配壳贝抱鹅简单厨满影积搭谎眨柳杨攻蚊位让躺椅奇怪蜜蜂蜻";
		words[13] = "蜓缺标几页睡桌珍珠扔休息愿意报阴较观众永远超姓名冠军金牌抄写教室体操场伸臂曲锻炼坚持句越互相座钟拳确";
		words[14] = "深浅挺跟踪拦住顶峰矮希帘香烟清楚舒急忙暗耀寒街道棉袄告诉近处虎王植物勇敢已经刚才强壮钻洞攀登卖户飘洒";
		
		
		int count = 1;
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				dict_words.put(words[i].charAt(j), count);
				count++;
			}
		}
		
	}
	
	public void init_can_read_words() {
		can_read_words = "大小";
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
