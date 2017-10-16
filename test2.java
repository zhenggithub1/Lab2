import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class test2 {
    public static void main(String[] args)
    {
        String TxtString = "";     //定义字符串
        String fileName = "C:\\Users\\Administrator\\Desktop\\test.txt";
        String line = "";
        String str = "";
        try//GITHUB修改处3
        {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            line = in.readLine();
            while (line != null)
            {
                str += line;
                //System.out.println(line);
                //System.out.println(TxtString);
                line = in.readLine();
            }
            in.close();
            TxtString = str.replaceAll("[\\pP\\p{Punct}]", " ");  //过滤字符串
            System.out.println(TxtString);        //输出过滤后的字符串
        }catch (IOException e)
        {
			//GITHUB修改处2
            e.printStackTrace();
        }
        String[] arrA = TxtString.toLowerCase().split("\\s+"); //字符串写入数组，按空格分割,并大写转小写
        System.out.println(Arrays.toString(arrA));  //输出数组

        int t = 0;
        String[] tempArray = new String[arrA.length];
        for (int i=0; i<arrA.length; i++) {
            boolean isTrue = true;
            for (int j=0; j<i; j++) {
                if (arrA[i].equals(arrA[j])) {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue) {
                tempArray[t]=arrA[i];
                t++;
            }
        }
        String[] arrB = new String[t];
        System.arraycopy(tempArray,0,arrB,0,t);
        System.out.println(Arrays.toString(arrB));


        //邻接矩阵构建有向图
        int Graph[][] = new int[arrB.length][arrB.length];
        for (int i=0; i<arrA.length-1; i++) {
            int j=0;
            int m=0;

            for (j=0; j<arrB.length; j++) {
                if (arrA[i].equals(arrB[j]))
                    break;
            }
            for (m=0; m<arrB.length; m++) {
                if (arrA[i+1].equals(arrB[m]))
                    break;
            }

            //j = getPosition(arrB, arrA[i]);
            //m = getPosition(arrB, arrA[i+1]);
            if (Graph[j][m]==0)
                Graph[j][m]=1;
            else
                Graph[j][m]++;
        }
        for (int i=0; i<arrB.length; i++) {
            for (int j=0; j<arrB.length;j++) {
                System.out.printf("%d", Graph[i][j]);
            }
            System.out.printf("\n");
        }


//GITHUB修改处1
    }
}