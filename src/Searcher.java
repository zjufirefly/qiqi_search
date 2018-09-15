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
	public static String all_words[] = new String[60];
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
			System.out.println("remember word index:");
			for (int i = 0; i < arr_remember.size(); i++) {
				OutWord out =  arr_remember.get(i);
				String output = String.format("%c    %-2d    %-4d", out.word, out.group, out.num);
				System.out.println(output);
			}
			System.out.println("");
			
		}
	}
	
	public static void init_remember_words() {
		remember_words = "爸子橙";
		
		
//		remember_words += "何人鱼鸟天田花叶大小长上去立笑包书我你东西南北空儿不爱背要太阳早歌什么学校说到对江戏间可为动当照劳采";
//		remember_words += "习民功迟莲庐府茫喳似筑勒敕川嗡穹头手四牛羊云风草山下来朵们见树真朋友蹦跳唱快乐彩落拉新蜜蜂阴野低盖窝";
//		remember_words += "笼朝汉吹苍";

//		remember_words += "裤足左背这厂右器机偶台生六笔怎班暖步爱四播吸级剪未尺取窗捉蹦九箱的什角五泥色袋袜天风人头笑外瓜目牛羊";
//		remember_words += "草鱼马耳鼻身飞手心口点三牙舌小电鸟林喝开少坐水半眉高看花月大多土去叶面井长直分出问车门苦方虫豆雪田日";
//		remember_words += "森圆一果石走木二尖雨山弓刀麦跳桥快跑唱歌爪雷勺乐美苗吃奶灯光男女前后布包裙鞋火画你东伞上下七八十里广";
//		remember_words += "米吐猫买亭立密皮工毛巾哥弟姐妹衣帽我家书妈灰爷竹子阿姨来么弯爸尘关丽河灭骑不升乌术莓线床圈号午兵今玉";
//		remember_words += "课题糕苹太饭入鸡爬树幼儿园换种玩会拿猪狗杂每兔本领孩娃没有发芽宝和拉起到路红停绿行还要瞅轻地慢是踩疼";
//		remember_words += "了就跟们好猜两棵个杈能写算干活说话荷在黄黑欢喜在刨青做游戏棋洗服搭积满各只主住都喂味西像星样杨桃着晚";
//		remember_words += "突然阵刮凉所邻居感冒也挤杯给香蕉葡萄病知道处变成春吹柳蝴蝶醒蛙得咪抹吗条块蛋真老卷明呢呀熊拍让蜜蜂追";
//		remember_words += "团鼠治吧盒根肠炸但胡巴他颗围把片早那同于终可怕萝卜它动如坚持钻掉周断浇拔恐嘟第串啊呜扭咕获又及菠迫嗯";
//		remember_words += "嘴腰回张现散阳朋友饿擦吞再带惊刺结闻收伸找理待晒喷懒蛇紫妞嚷哈揪勾朵她很边用借趣觉象瞧梦对时候贝抱睡";
//		remember_words += "珠臂急才办伙呼当甜啦露解决枕嘎锤键阶耸屁噜啪梆钉咚溜悠股咦喵咻嚼嗒哦哧叮叽哭球眼睛脚铃请汤滑进白亲泳";
//		remember_words += "想穿最响菜帮自己舞谁虾放公眨体物伴倒而碗煮蘑菇膀扶梯肚定指约肩澡板琴锅";
		for (int i = 0; i < remember_words.length(); i++) {
			set_remember_words.add(remember_words.charAt(i));
		}
	}
	
	public static void init_all_words() {
		all_words[0] = "爸妈我大米土地马花哥弟个画下洗衣服鸡做过了不乐出读书骑车的话你他水白皮子在小爱吃鱼和牛草好家飞机有儿";
		all_words[1] = "河入校山田左片右半云她老师文朵鹅条雨天桥一去二三里四五六七八九十口耳目羊鸟兔日月火木禾竹沙发报纸台灯";
		all_words[2] = "电视晚上送果笑也打球拨拍跳高跑步足响课真身体远色近听无声春还人来惊对说是叶圆夏秋雪肚就冬排中游流唱两";
		all_words[3] = "岸树苗绿江南哪座房漂亮青门窗香屋要们爷棵到给穿暖冷开伞热静夜床光举头望低故乡船弯坐只看见闪星蓝阳像金";
		all_words[4] = "野更面长早晨拉近谁影前后常跟着黑狗它朋友比尾巴短把猴松鼠扁最公鸭黄毛杏桃苹红边多少群颗堆商场包奶牙毛";
		
		all_words[5] = "巾笔尺作业本东西菜园豆角萝卜心又捉迷藏嘴越风明鲜尘尖灭力男休手林森从众想告诉路能走北京城安广升旗点数";
		all_words[6] = "清彩飘落空问回答方平搭间这些都住呢啊没很自己吧您带吗深学会那景美次瓜燕什么样得再可仔细兴现找生旁种许";
		all_words[7] = "格外艳呀每言语啦梅用几成娃为参加洞睡放步熊快怎饭班拿正礼物今孩让起玩往觉烧知道化砍造满舍结年直动束丽";
		all_words[8] = "万复苏柳歌舞冰泉丁百齐争鸣醒雷澡枝软梳梢耍线论趣题底颜淋洒滴油欢邓植节岁龄已经息站行扶栽亲古诗首眠处";
		all_words[9] = "闻村居醉烟童散忙评访挤邮局轿钱懂貌父母教认错事改愿晚筷扫夸全奇妙却精赛关掉完换员写音蹈胖喜张刚贴墙替";
		
		all_words[10] = "拖鞋帮等变情棉照晒被盖午收脱躺合眼睛摆帘女背装气另顾病太累医悄离户票元旦值篇遍雾霜朝霞夕蝶蜂碧紫千李";
		all_words[11] = "杨秀蛋取凉定捧连轻仿佛拾投向聪活泼忽然眨如总以主意先鹿慢积鼻脑袋怪推辆赶久干净失级同观围工专准备队才";
		all_words[12] = "请双各字代舌页弓秒炒蜻蜓展蝴蚯蚓蚂蚁运蝌蚪蜘蛛网所牧捕蝉闭立池惜阴晴柔露荷珠摇篮晶停坪透翅膀蹲嘻莲哭";
		all_words[13] = "睁趴根腰爬非感激谢急时坡割闷伸喊潮湿虫消搬阵哗壁虎借蚊蛇逃难姐新擦抄拾摔拨拦摸团量相遇及怕攻互尊重令";
		all_words[14] = "纯挂街熟伙伴尝甜温冻脸该因季乌鸦喝渴瓶石办法渐司假缸别慌吓叫块使劲砸破救称象官腿柱议杆秤倒艘沉止微矮";
		
		all_words[15] = "瘦暗丑闲旧海鸥滩军舰帆秧稻塘溪竿铜号领忘挖井席导革命战士解刻念望助哨敌荡顺突枪杀害英雄冲部宽虾脚捡贝";
		all_words[16] = "壳原奔密匹市楼吹祝贺希祖国由羽丰勇敢理敬度厂甲申句兄虚骄傲淡诚实赢赞招翻浇施肥饿候挑担狮整练习滚扑咬";
		all_words[17] = "懒洋吞将靠应餐丢矿糟糕粗概共汽记保管夹盆位选并宣分芽规盛丝表煮饼饮饺子猪狼初眉辨斗湖即雁归转寒姑娘蚜";
		all_words[18] = "盼治啄斑俩摘伯而且踢引兰梁程波架特砖划采薄巧稳郊列弄查速度断提修建世界创梦名灰迎阿姨追披鼓甘埋闯掰跌";
		all_words[19] = "宜层尽染叠翠爽壮谷登华图梨笼浪粱燃勤劳区尤其仙盘峰胳膊巨当脖著形状旅蒲降娃纷苍洼啪炸蹦察识刘菊残君橙";
		
		all_words[20] = "橘径斜枫于交支龙求凡利棋弹钢琴胡戏喂鸽养航模株踮院除疲倦牵困委补室宁愣切集掌钟零闹哈欠迟叹决悔计算冒";
		all_words[21] = "览馆紧怦握容普奋灿烂柏纪纺织优胜湾粒神州川涌岛隔峡与陆民族庆献帜洁奏曲亿央瓦庄严阔碑周似拼案坛迹厦讯";
		all_words[22] = "传约聚锣呼击拥抱泪泽克扬省店橱指接讲铺毯银仗退危险买卖反杂简单寸益彰豹障泰徒功渠沿际信息葫芦藤哇盯邻";
		all_words[23] = "枣浅秃忍呗虽乘思抽续吸极夫汗驶示筝踪伤责酸葡萄狐狸串迫待硬茶饱袍鞭炮移动谋柴焰易折搓绳斤独刺猬板凳糙";
		all_words[24] = "但傍椅瞧留术铅惹吐桌盒注削邹坏扎抓莓幸福吵受之轮期第任惯式眯郑铁钉裙裤袄疼痛疯恨漠炭贫富饥索奉永科亚";
		
		all_words[25] = "呆始猜拴逗良缩遥寻食泣健康操则昨纱羡慕粉料套份妹贵寄费客何赠汪舟欲踏潭历贡肯扇确愁护牢孔雀锦鹰丛鹂灵";
		all_words[26] = "嘻叽喳蓬跃棱巢崭牌侧卷欣赏龟镜映幻演蕉扔跨甚至蒸死继乎叨蒙喃味浓腾猎黎射卫填嫦娥宇宙载箭浮雹暴躁灌溉";
		all_words[27] = "器淹稼毁灭呱哩圈纹碰返舒必须绑通杯塑咳嗽钩件喷设浴博珍孙悉绝肉史核缺乏稀农技袁隆介绍培育产棚控制泥茁";
		all_words[28] = "羞遮掩躲探嫩符触鹊枯荣宿徐篱疏未笋唤揉漆轰扭钻唠辫抚滋润冈豪玫瑰骨终瘸拐惋莺材牺牲渡帽烈达按笨哦股缝";
		all_words[29] = "罐搭杜鹃脆锋叔曾泞窝迈荆棘瓣莹觅需弱末萨托铃簇随芬芳聊倾递娇掀卡罗尔适余垫洛喵绒屉免糊涂厨蹭义占勾库";
		
		all_words[30] = "";
		all_words[31] = "";
		all_words[32] = "";
		all_words[33] = "";
		all_words[34] = "";
		
		all_words[35] = "";
		all_words[36] = "";
		all_words[37] = "";
		all_words[38] = "";
		all_words[39] = "";
		
		all_words[40] = "";
		all_words[41] = "";
		all_words[42] = "";
		all_words[43] = "";
		all_words[44] = "";
		
		all_words[45] = "";
		all_words[46] = "";
		all_words[47] = "";
		all_words[48] = "";
		all_words[49] = "";
		
		all_words[50] = "";
		all_words[51] = "";
		all_words[52] = "";
		all_words[53] = "";
		all_words[54] = "";
		
		all_words[55] = "";
		all_words[56] = "";
		all_words[57] = "";
		all_words[58] = "";
		all_words[59] = "";
		
//		all_words[0] = "人头目眉鼻耳口牙舌心手足身一二三四五六七八九十马牛羊鱼虫鸟天日月云风雨雪雷电田木米果瓜禾苗森林石亭花";
//		all_words[1] = "草山叶竹水土方圆尖大小高长弓刀勺面豆气分半点出入例外开关多少上下弯直来去吃喝吐立坐走飞看问哭笑车门井";
//		all_words[2] = "伞包布皮书画灯光衣裙袜裤鞋帽毛巾工厂灭火灰尘家爷奶妈爸哥弟姐妹我你男女前后左右东西南北中宋郑李徐刘陈";
//		all_words[3] = "吴郭赵胡章婆伯叔姨阿视迷球国京兴空发脸孔眼睛朵齿嘴巴双脚腿铃正腰好您请茶给孩儿们和不见喊纱回今午读题";
//		all_words[4] = "图线圈号课骑钓枪汤肉芽冬柿条饭铺玉莓苹糕床他她是就辆张盏件块本个颗只支服红黄黑绿蓝围色生窗未袋偶爱剪";
//		all_words[5] = "箱角台背机器吸汽炮箭兵类极滑冷痰向现很羽过亮乌打刮滴把闪路进退底青蛙这桥子树河地麦消害许房做盆片竿短";
//		all_words[6] = "坡散边蛋要用太阳的真更溪碧鲜艳早晨旁在美丽燕有还白枝了样院久没班级借知识算魔术讲完成拿着老师事故听懂";
//		all_words[7] = "趣得觉起始专朋友象踢庭亲能够游泳盼望跑步蹦跳唱歌活泼快乐那些像什么怎病都想学校排队穿旗升城广播星送礼";
//		all_words[8] = "敬最响声祖说到瞧也菜额卷紧唇饱同岁拖饿擦汗帮助干净明聪夸奖自己年龄卡贺彩虹慢岭荷变化蝴蝶舞蹈梦乡吞湖";
//		all_words[9] = "颜再洗谁呢比赛对市节季春夏秋枯笔烈遮挡撑落降秘密取暖泥堆从滚玻璃常非鸭等于带斤江终猫爪买尺捉虾猴戏作";
//		all_words[10] = "业渴捡纸童呀哎瓦装船划放轻松挂钩晴朗间时候岸可以感谢喜欢两群尾兔养怕狗猎咬萝卜喂猪惊慌每次屋为因公主";
//		all_words[11] = "其它运动激选择微如熊加参刺猬辣椒填晚傍漂流哪棵迎接粗细桃核泪种结束摘梨错会拉差话力抓此苦新闻行粮食瓶";
//		all_words[12] = "罐血管丢失假期脑千万集合雀收藏铅拍姑娘玩具踩坏配壳贝抱鹅简单厨满影积搭谎眨柳杨攻蚊位让躺椅奇怪蜜蜂蜻";
//		all_words[13] = "蜓缺标几页睡桌珍珠扔休息愿意报阴较观众永远超姓名冠军金牌抄写教室体操场伸臂曲锻炼坚持句越互相座钟拳确";
//		all_words[14] = "深浅挺跟踪拦住顶峰矮希帘香烟清楚舒急忙暗耀寒街道棉袄告诉近处虎王植物勇敢已经刚才强壮钻洞攀登卖户飘洒";
//		all_words[15] = "商店捏娃粘帖宝贵元旦答案泡熟悉昨夜吵架规则全骂鸦办法悬崖棋幼鹿伙伴跌倒救命狐狸鸣叫连臭悄巧妙胜利寻找";
//		all_words[16] = "母鸡妖鬼凶恶杀敌脱掉冲垮野兽斑纹重量推翻战士使劲讨厌追赶斜爬低部挣扎毒理叠邻居辈而且并列庆祝梳辫招待";
//		all_words[17] = "端碗捧舰艇杯盖炒栗煮饺团聚烧饼思念呼沙漠保护阵距离困难容易海滩无聊周站岗危险壶糟卫建设环境污染塑料搬";
//		all_words[18] = "貌鸥趴披匹坪稍哨拾掰闭尝丑导丁冻蹲帆整齐池塘蝌蚪蚯蚓蚂蚁被窝捕捞鸽笼罩平衡稳当原谅醉枣项链交叉转移铁";
//		all_words[19] = "锹挖坑砸缸受伤首先射击称赞英雄鼠诵猜谜租司令任务药膏医治疗照顾胸闷弹味精往返砖墙斗争展另遇皱劳累价格";
//		all_words[20] = "酒吧武艺准备餐厅蘑菇压扁虽然形状产品采访甘甜介绍瞎除夕党员醒淘鞠躬托盘联系应该顽哗啦忽略健康奔渔网桶";
//		all_words[21] = "钱柜朝霞胖瘦引悔输赢湿透继续热闹议论撕破敲鼓特别灵敏摔碎拥挤停顿优秀代替顺序宣传掌握即将遗留割断票投";
//		all_words[22] = "篮忆普通制造按怀疑组凉爽晾晒扫帚施肥浇灌唐古诗科技旅馆茂盛腊梅喷泉蜘蛛拔剑领楼层乘融描词语翅膀懒惰抬";
//		all_words[23] = "轿邮局烦恼秒表暴露雕刻针盒随便剩余驾驶艘速逃挑铜文惜席杏兄仿丰佛父各根共汉夹剧痛批评摆弄严肃扶梯检查";
//		all_words[24] = "肚肠承认修改闯祸诚实练嗓肯定恳求温度估计零沉浮棍棒催眠纺织秤杆习惯丝钢柱情况指挥演奏鞭躲避内村庄震聋";
//		all_words[25] = "吓碰撞突袭邀淹死抢夺善良必需寄信冒充含糖农民封存坦克摇晃调换警察忧愁拒绝贡献付款颤抖孤独忘记拼音牢固";
//		all_words[26] = "神仙垃圾漏由贫穷富翁隔壁皇帝宫殿灿烂辉煌筷培育缝补衬衫套幸福芝麻羡慕预约解决货轮愤怒宽肩娇嫩澡堂厕所";
//		all_words[27] = "拎恐龙派糊涂厚薄印折扇银锁轰隆挠痒败仗功夫偷摸甩绳仓库板凳官隐蔽忍耐闲谈跨栏捣乱硬币欺骗创举央瓣航模";
//		all_words[28] = "琴弦怨恨笨狼缩横竖淋浴狮吼禁止油漆爆炸筋骨龟蛇扮蒸须骄傲吹喇叭扑粉番茄考试安静世界拨镜旧锅堵塞迟枕景";
//		all_words[29] = "区临稻减数波浪宇宙免费反复增添苍蝇陪客冰雹柔软葡萄延郊晶砍靠矿兰莲埋蚜言雁秧洋饮映园栽睁值啄紫字总百";
		
		int count = 1;
		for (int i = 0; i < all_words.length; i++) {
			for (int j = 0; j < all_words[i].length(); j++) {
				Word word = new Word();
				word.word = all_words[i].charAt(j);
				word.group = (i*50 + j + 1)/100;
				word.num = count;
				map_words.put(word.word, word);

				count++;
			}
		}
	}

}