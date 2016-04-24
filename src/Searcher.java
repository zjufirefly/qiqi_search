import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Word {
	public Character word;
	public int group;
	public int num;
}

class OutWord  implements Comparable<OutWord>{
	public Character word;
	public int group;
	public int num;
	public boolean in_dict;
	
	@Override
	public int compareTo(OutWord o) {
		return this.num - o.num;
	}
}

public class Searcher {
	public static String all_words[] = new String[30];
	public static HashMap<Character, Word> map_words = new HashMap<Character, Word>();
	
	public static String remember_words = new String();
	public static HashSet<Character> set_remember_words = new HashSet<Character>();
	
	public static HashSet<Character> set_input = new HashSet<Character>();
	
	public static ArrayList<OutWord> arr_remember = new ArrayList<OutWord>();
	public static ArrayList<OutWord> arr_not_remember = new ArrayList<OutWord>();
	
	
	public static void main(String[] args) {
		init_all_words();
		init_remember_words();
		
		System.out.println("请输入任意句子, 输入exit退出");
		while (true) {
			arr_remember = new ArrayList<OutWord>();
			arr_not_remember = new ArrayList<OutWord>();
			set_input = new HashSet<Character>();
			
			//创建输入对象
			Scanner sc = new Scanner(System.in);
	  
			//获取用户输入的字符串
			String input = null;
			
			System.out.print(">>> ");
			input=sc.nextLine();
			if (input.equals("exit") || input.equals("quit")) {
				return;
			}
			
			if (input == null || input.equals("") || input.equals("\n")) {
				continue;
			}
			
			for (int i = 0; i < input.length(); i++) {
				set_input.add(input.charAt(i));
			}
		
			for (Character input_word:set_input) {
				OutWord out_word = new OutWord();
				
				out_word.word = input_word;
				if (map_words.containsKey(input_word)) {
					out_word.group = map_words.get(input_word).group;
					out_word.num = map_words.get(input_word).num;
					out_word.in_dict = true;
				} else {
					out_word.group = -1;
					out_word.num = -1;
					out_word.in_dict = false;
				}
				
				if (set_remember_words.contains(input_word)) {
					arr_remember.add(out_word);
				} else {
					arr_not_remember.add(out_word);
				}
			}
			
			// sort
			Collections.sort(arr_remember);
			Collections.sort(arr_not_remember);
			
			// output
			// not remember
			System.out.println("not remember word:");
			for (int i = 0; i < arr_not_remember.size(); i++) {
				String output = String.format("%c", arr_not_remember.get(i).word);
				System.out.print(output);	
			}
			System.out.println("");
			
			// not remember index
			System.out.println("not remember word index:");
			for (int i = 0; i < arr_not_remember.size(); i++) {
				OutWord out =  arr_not_remember.get(i);
				String output = String.format("%c    %-2d    %-4d", out.word, out.group, out.num);
				System.out.println(output);
			}
			System.out.println("");
			
			// not remember index
			System.out.println("not remember word index:");
			for (int i = 0; i < arr_remember.size(); i++) {
				OutWord out =  arr_remember.get(i);
				String output = String.format("%c    %-2d    %-4d", out.word, out.group, out.num);
				System.out.println(output);
			}
			System.out.println("");
			
		}
	}
	
	public static void init_remember_words() {
		remember_words = "";
		remember_words += "裤足左背这厂右器机偶台生六笔怎班暖步爱四播吸级剪未尺取窗捉蹦九箱的什角五泥色袋袜天风人头笑外瓜目牛羊";
		remember_words += "草鱼马耳鼻身飞手心口点三牙舌小电鸟林喝开少坐水半眉高看花月大多土去叶面井长直分出问车门苦方虫豆雪田日";
		remember_words += "森圆一果石走木二尖雨山弓刀麦跳桥快跑唱歌爪雷勺乐美苗吃奶灯光男女前后布包裙鞋火画你东伞上下七八十里广";
		remember_words += "米吐猫买亭立密皮工毛巾哥弟姐妹衣帽我家书妈灰爷竹子阿姨来么弯爸尘关丽河灭骑不升乌术莓线床圈号午兵今玉";
		remember_words += "课题糕苹太饭入鸡爬树幼儿园换种玩会拿猪狗杂每兔本领孩娃没有发芽宝和拉起到路红停绿行还要瞅轻地慢是踩疼";
		remember_words += "了就跟们好猜两棵个杈能写算干活说话荷在黄黑欢喜在刨青做游戏棋洗服搭积满各只主住都喂味西像星样杨桃着晚";
		remember_words += "突然阵刮凉所邻居感冒也挤杯给香蕉葡萄病知道处变成春吹柳蝴蝶醒蛙得";
		
		for (int i = 0; i < remember_words.length(); i++) {
			set_remember_words.add(remember_words.charAt(i));
		}
	}
	
	public static void init_all_words() {
		all_words[0] = "人头目眉鼻耳口牙舌心手足身一二三四五六七八九十马牛羊鱼虫鸟天日月云风雨雪雷电田木米果瓜禾苗森林石亭花";
		all_words[1] = "草山叶竹水土方圆尖大小高长弓刀勺面豆气分半点出入例外开关多少上下弯直来去吃喝吐立坐走飞看问哭笑车门井";
		all_words[2] = "伞包布皮书画灯光衣裙袜裤鞋帽毛巾工厂灭火灰尘家爷奶妈爸哥弟姐妹我你男女前后左右东西南北中宋郑李徐刘陈";
		all_words[3] = "吴郭赵胡章婆伯叔姨阿视迷球国京兴空发脸孔眼睛朵齿嘴巴双脚腿铃正腰好您请茶给孩儿们和不见喊纱回今午读题";
		all_words[4] = "图线圈号课骑钓枪汤肉芽冬柿条饭铺玉莓苹糕床他她是就辆张盏件块本个颗只支服红黄黑绿蓝围色生窗未袋偶爱剪";
		all_words[5] = "箱角台背机器吸汽炮箭兵类极滑冷痰向现很羽过亮乌打刮滴把闪路进退底青蛙这桥子树河地麦消害许房做盆片竿短";
		all_words[6] = "坡散边蛋要用太阳的真更溪碧鲜艳早晨旁在美丽燕有还白枝了样院久没班级借知识算魔术讲完成拿着老师事故听懂";
		all_words[7] = "趣得觉起始专朋友象踢庭亲能够游泳盼望跑步蹦跳唱歌活泼快乐那些像什么怎病都想学校排队穿旗升城广播星送礼";
		all_words[8] = "敬最响声祖说到瞧也菜额卷紧唇饱同岁拖饿擦汗帮助干净明聪夸奖自己年龄卡贺彩虹慢岭荷变化蝴蝶舞蹈梦乡吞湖";
		all_words[9] = "颜再洗谁呢比赛对市节季春夏秋枯笔烈遮挡撑落降秘密取暖泥堆从滚玻璃常非鸭等于带斤江终猫爪买尺捉虾猴戏作";
		all_words[10] = "业渴捡纸童呀哎瓦装船划放轻松挂钩晴朗间时候岸可以感谢喜欢两群尾兔养怕狗猎咬萝卜喂猪惊慌每次屋为因公主";
		all_words[11] = "其它运动激选择微如熊加参刺猬辣椒填晚傍漂流哪棵迎接粗细桃核泪种结束摘梨错会拉差话力抓此苦新闻行粮食瓶";
		all_words[12] = "罐血管丢失假期脑千万集合雀收藏铅拍姑娘玩具踩坏配壳贝抱鹅简单厨满影积搭谎眨柳杨攻蚊位让躺椅奇怪蜜蜂蜻";
		all_words[13] = "蜓缺标几页睡桌珍珠扔休息愿意报阴较观众永远超姓名冠军金牌抄写教室体操场伸臂曲锻炼坚持句越互相座钟拳确";
		all_words[14] = "深浅挺跟踪拦住顶峰矮希帘香烟清楚舒急忙暗耀寒街道棉袄告诉近处虎王植物勇敢已经刚才强壮钻洞攀登卖户飘洒";
		all_words[15] = "商店捏娃粘帖宝贵元旦答案泡熟悉昨夜吵架规则全骂鸦办法悬崖棋幼鹿伙伴跌倒救命狐狸鸣叫连臭悄巧妙胜利寻找";
		all_words[16] = "母鸡妖鬼凶恶杀敌脱掉冲垮野兽斑纹重量推翻战士使劲讨厌追赶斜爬低部挣扎毒理叠邻居辈而且并列庆祝梳辫招待";
		all_words[17] = "端碗捧舰艇杯盖炒栗煮饺团聚烧饼思念呼沙漠保护阵距离困难容易海滩无聊周站岗危险壶糟卫建设环境污染塑料搬";
		all_words[18] = "貌鸥趴披匹坪稍哨拾掰闭尝丑导丁冻蹲帆整齐池塘蝌蚪蚯蚓蚂蚁被窝捕捞鸽笼罩平衡稳当原谅醉枣项链交叉转移铁";
		all_words[19] = "锹挖坑砸缸受伤首先射击称赞英雄鼠诵猜谜租司令任务药膏医治疗照顾胸闷弹味精往返砖墙斗争展另遇皱劳累价格";
		all_words[20] = "酒吧武艺准备餐厅蘑菇压扁虽然形状产品采访甘甜介绍瞎除夕党员醒淘鞠躬托盘联系应该顽哗啦忽略健康奔渔网桶";
		all_words[21] = "钱柜朝霞胖瘦引悔输赢湿透继续热闹议论撕破敲鼓特别灵敏摔碎拥挤停顿优秀代替顺序宣传掌握即将遗留割断票投";
		all_words[22] = "篮忆普通制造按怀疑组凉爽晾晒扫帚施肥浇灌唐古诗科技旅馆茂盛腊梅喷泉蜘蛛拔剑领楼层乘融描词语翅膀懒惰抬";
		all_words[23] = "轿邮局烦恼秒表暴露雕刻针盒随便剩余驾驶艘速逃挑铜文惜席杏兄仿丰佛父各根共汉夹剧痛批评摆弄严肃扶梯检查";
		all_words[24] = "肚肠承认修改闯祸诚实练嗓肯定恳求温度估计零沉浮棍棒催眠纺织秤杆习惯丝钢柱情况指挥演奏鞭躲避内村庄震聋";
		all_words[25] = "吓碰撞突袭邀淹死抢夺善良必需寄信冒充含糖农民封存坦克摇晃调换警察忧愁拒绝贡献付款颤抖孤独忘记拼音牢固";
		all_words[26] = "神仙垃圾漏由贫穷富翁隔壁皇帝宫殿灿烂辉煌筷培育缝补衬衫套幸福芝麻羡慕预约解决货轮愤怒宽肩娇嫩澡堂厕所";
		all_words[27] = "拎恐龙派糊涂厚薄印折扇银锁轰隆挠痒败仗功夫偷摸甩绳仓库板凳官隐蔽忍耐闲谈跨栏捣乱硬币欺骗创举央瓣航模";
		all_words[28] = "琴弦怨恨笨狼缩横竖淋浴狮吼禁止油漆爆炸筋骨龟蛇扮蒸须骄傲吹喇叭扑粉番茄考试安静世界拨镜旧锅堵塞迟枕景";
		all_words[29] = "区临稻减数波浪宇宙免费反复增添苍蝇陪客冰雹柔软葡萄延郊晶砍靠矿兰莲埋蚜言雁秧洋饮映园栽睁值啄紫字总百";
		
		int count = 1;
		for (int i = 0; i < all_words.length; i++) {
			for (int j = 0; j < all_words[i].length(); j++) {
				Word word = new Word();
				word.word = all_words[i].charAt(j);
				word.group = i + 1;
				word.num = count;
				map_words.put(word.word, word);

				count++;
			}
		}
	}

}
