import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class EngSearch {

    // sight
    public static String[] sightWords = new String[6];
    public static HashMap<String, Integer> setSightWords = new HashMap<>(); // key word, value 卡片组1,2,3,4,5
    public static String remSightWord = "  ";



    public static void intiSightWord() {
        sightWords[1] = "a and away big can come funny go help here it is jump little my play i the to you blue down find for in look make me not one red run said see three two up we where yellow";
        sightWords[2] = "all am ate are but did do eat four get have like must no new now please say so soon this that want what who yes at be black brown came good he into on out our pretty ran ride saw she there they too under was well went white with";
        sightWords[3] = "an as ask could fly give her how just know let live may of put take thank then think walk after again any by every form old going had has him his once open over round some stop them were when";
        sightWords[4] = "always around because been before best both call cold does don't fast first goes its off many made pull very why upon buy found gave green or read right sleep sing sit these those tell their us wash which wish work would write your";
        sightWords[5] = "about better bring clean cut donedraw drink far full grow hurt laugh myself never own pick shall show start together carry eight fall got hold hot if keep kind light long much nine only seven six small ten today try warm";
        sightWords[0] = "";

        // TODO 会读的sight word
        remSightWord = " this is my the go in out can jump run sit over has too many one two three four five six seven goes " +
                " i ride play a he to have his what are and he that they she who these those their";

        for (int i = 1; i <= 5; i++) {
            String temp[] = sightWords[i].split(" ");
            for (int j = 0; j < temp.length; j++) {
                setSightWords.put(temp[j], i);
            }
        }
    }

    public static void outputSightWord(String input) {
        System.out.println("sight word:");
        String inputs[] = input.split(" ");
        for (String word: inputs) {
            if (remSightWord.indexOf(" "+ word + " ") >= 0) {
                // word, isRem, num
                String output = String.format("%-15s%s\t%d", word, "Y", setSightWords.get(word));
                System.out.println(output);
            }
        }

        for (String word: inputs) {
            if (remSightWord.indexOf(" "+ word + " ") < 0) {
                if (setSightWords.containsKey(word)) {
                    String output = String.format("%-15s%s\t%d", word, "N", setSightWords.get(word));
                    System.out.println(output);
                }
            }
        }
    }

    // normal word
    public static String remNormalWord;
    public static String[] normalWords = new String[100];

    public static void initNormal() {
        StringBuffer remBuffer = new StringBuffer();
        // TODO 会读的词
        remBuffer.append(" head belly chest this is my body arm foot leg hand ");
        remBuffer.append(" the in cat go oh cow dog boy mud out pig  ");
        remBuffer.append(" eye nose mouse face eyebrow chin cheek ear  ");
        remBuffer.append(" over can dig roll run hug ciimb swim jump sit ");
        remBuffer.append(" six too four one seven has many two three five pumpkin ");
        remBuffer.append(" mountain city car goes street bird tree farm table home ");
        remBuffer.append(" climb play swing hop i ride crawl ");
        remBuffer.append(" feet a tail draw teech bunny ");
        remBuffer.append(" plane bus school pool to store he boat train ");
        remBuffer.append("  ");
        remBuffer.append(" bag kite family talk mom dad cat dog what are and he that has his they she who "); // vipkid u4l1
        remBuffer.append(" equal tablet snowman his what are have hat noodle noodles "); // vipkid u4l2
        remBuffer.append(" these those their banana apple lie brother sister "); // vipkid u4l3
        remNormalWord = remBuffer.toString();

        // TODO 按照raz编号，每册出现的单词
        normalWords[1] = "head belly chest this is my body arm foot leg hand";
        normalWords[2] = "the in cat go oh cow dog boy mud out pig";
        normalWords[3] = "eye nose mouse face eyebrow chin cheek ear";
        normalWords[4] = "over can dig roll run hug ciimb swim jump sit ";
        normalWords[5] = "six too four one seven has many two three five pumpkin";
        normalWords[6] = "mountain city car goes street bird tree farm table home";
        normalWords[7] = "climb play swing hop i ride crawl ";
        normalWords[8] = "feet a tail draw teech bunny";
        normalWords[9] = "plane bus school pool to store he boat train";
        normalWords[10] = "";
        normalWords[0] = "";
    }

    public static void outputNormalWord(String input) {
        HashSet<String> setInputs = new HashSet<>();
        String[] inputs = input.trim().split(" ");
        for (String word: inputs) {
            setInputs.add(word);
        }

        // all word
        System.out.println("");
        System.out.println("");
        System.out.println("all normal word：");
        for (String word: setInputs) {
                // word, isRem, num
                String output = String.format("%s ", word);
                System.out.print(output);
        }
        System.out.println("");


        // all not rem
        System.out.println("all not remember normal word：");
        for (String word: setInputs) {
            if (remNormalWord.indexOf(" "+ word + " ") < 0) {
                String output = String.format("%s ", word);
                System.out.print(output);
            }
        }
        System.out.println("");


        // rem word
        for (String word: setInputs) {
            if (remNormalWord.indexOf(" "+ word + " ") >= 0) {
                // word, isRem, num
                String output = String.format("%-15s%s", word, "Y");
                System.out.println(output);
            }
        }

        // not rem word
        for (String word: setInputs) {
            if (remNormalWord.indexOf(" "+ word + " ") < 0) {
                // word, isRem, num
                String output = String.format("%-15s%s", word, "N");
                System.out.println(output);
            }
        }
        System.out.println("");

    }

    public static void main(String args[]) {
        intiSightWord();
        initNormal();

        System.out.println("Please input words");
        while (true) {
            //创建输入对象
            Scanner sc = new Scanner(System.in);

            //获取用户输入的字符串
            String input = null;
            System.out.println("请输入任意句子, 输入exit退出");
            System.out.print(">>> ");
            input = sc.nextLine();
            if (input.equals("exit")) {
                return;
            }

            System.out.println("");
            System.out.println("查询结果如下");

            outputSightWord(input);

            outputNormalWord(input);
        }

    }

}
