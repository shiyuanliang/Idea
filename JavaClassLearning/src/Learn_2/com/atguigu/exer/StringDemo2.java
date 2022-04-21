package Learn_2.com.atguigu.exer;

import org.junit.Test;

/**
 * @author shkstart
 * @create 2019 上午 10:42
 */
public class StringDemo2 {
    /*
    获取两个字符串中最大相同子串。比如：
   str1 = "abcwerthelloyuiodefabcdef";str2 = "cvhellobnm"
   提示：将短的那个串进行长度依次递减的子串与较长的串比较。

     */
    //前提：两个字符串中只有一个最大相同子串

    public  String getMaxSubstring(String str1, String str2){
        String temp;
        if(str1.length()<str2.length()){
            temp = str1;
            str1 = str2;
            str2 = temp;
        }

        for(int i = 0; i<str2.length(); i++){
            for(int j = 0; j<=i;j++){
                String str2Sub = str2.substring(j,str2.length()-i+j);
                int result = str1.indexOf(str2Sub);
                if(result!=-1){
                    return str2Sub;
                }
            }
        }
        return null;
    }
    @Test
    public void  testGetMaxSubstring(){
        String str1 = "abcwerthelsddsloyuiodefadfajsdhbcdef",str2 = "cvhelsdhajklohasdsdfasdfhkahsdfkjahsdkafksdafjfabnm";
        String MaxSubstring = getMaxSubstring(str1,str2);
        System.out.println(MaxSubstring);
    }

}
