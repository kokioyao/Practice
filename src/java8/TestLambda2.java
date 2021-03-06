package java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author footman77
 * @create 2018-10-24 17:58
 *
 * 一、Lambda 表达式的基础语法：Java8中引入了一个新的操作符 "->" 该操作符称为箭头操作符或 Lambda 操作符
 * 						    箭头操作符将 Lambda 表达式拆分成两部分：
 *
 * 左侧：Lambda 表达式的参数列表
 * 右侧：Lambda 表达式中所需执行的功能， 即 Lambda 体
 *
 * 语法格式一：无参数，无返回值
 * 		() -> System.out.println("Hello Lambda!");
 *
 * 语法格式二：有一个参数，并且无返回值
 * 		(x) -> System.out.println(x)
 *
 * 语法格式三：若只有一个参数，小括号可以省略不写
 * 		x -> System.out.println(x)
 *
 * 语法格式四：有两个以上的参数，有返回值，并且 Lambda 体中有多条语句
 *		Comparator<Integer> com = (x, y) -> {
 *			System.out.println("函数式接口");
 *			return Integer.compare(x, y);
 *		};
 *
 * 语法格式五：若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写
 * 		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 *
 * 语法格式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”
 * 		(Integer x, Integer y) -> Integer.compare(x, y);
 *
 * 上联：左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 *
 * 二、Lambda 表达式需要“函数式接口”的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。 可以使用注解 @FunctionalInterface 修饰
 * 			 可以检查是否是函数式接口
 */
public class TestLambda2 {


    @Test
    public void test01(){

        int num = 0;//jdk1.7以前，必须是final，1.8可以省略，但也无法修改

        Runnable r = new Runnable(){

            @Override
            public void run() {
                System.out.println("hello world!" + num);
            }
        };

        r.run();

        System.out.println("------------");

        Runnable r1 = () -> System.out.println("hello Lambda!");

        r1.run();
    }

    @Test
    public void test02(){
        Consumer<String> con = (x) -> System.out.println(x);

        con.accept("达赖");
    }
    @Test
    public void test03(){
        Comparator<Integer> con = (x,y) -> {
            System.out.println("比较啥啊");
            return Integer.compare(x, y);
        };

        int compare = con.compare(2, 10);
        System.out.println(compare);
    }

    @Test
    public void test04(){
        Comparator<Integer> con = (x,y) -> Integer.compare(x,y);
    }




}
