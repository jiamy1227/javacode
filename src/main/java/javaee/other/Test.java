package javaee.other;

public class Test {
    public static void main(String[] args) {
        String s = "'sds gdasda" + "\n" + "edaeafd'";
        System.out.println("转换前："+s);
        s = s.replaceAll("\r|\n", "");
        System.out.println("转换后："+s);
    }
}
