import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GeneratorInput {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        char[][] matrix;
        //100*100 all mines
        matrix = generator(100,100,1);
        sb.append(caseStr(matrix));
        //100*100 no mines
        matrix = generator(100,100,0);
        sb.append(caseStr(matrix));
        //100*100 random mines
        matrix = generator(100,100,0.3);
        sb.append(caseStr(matrix));

        //1*100
        matrix = generator(1,100,1);
        sb.append(caseStr(matrix));

        matrix = generator(1,100,0);
        sb.append(caseStr(matrix));

        matrix = generator(1,100,0.3);
        sb.append(caseStr(matrix));

        //100*1
        matrix = generator(100,1,1);
        sb.append(caseStr(matrix));

        matrix = generator(100,1,0);
        sb.append(caseStr(matrix));

        matrix = generator(100,1,0.3);
        sb.append(caseStr(matrix));

        //1*1
        matrix = generator(1,1,1);
        sb.append(caseStr(matrix));

        matrix = generator(1,1,0);
        sb.append(caseStr(matrix));

        //any size
        matrix = generator(50,30,1);
        sb.append(caseStr(matrix));

        matrix = generator(50,30,0);
        sb.append(caseStr(matrix));

        matrix = generator(50,30,0.3);
        sb.append(caseStr(matrix));

        //add end 0 0
        sb.append("0 0\n");

        //write input
        writeInput(sb.toString());

    }

    /**
     * 
     * @return
     */
    public static char[][] generator(int rows,int cols,double percent){
        double temp;
        char[][] matrix=new char[rows][cols];
        for(int i = 0 ; i < rows;i++){
            for (int j = 0; j < cols;j++){
                temp = Math.random();
                if(temp < percent){
                    matrix[i][j]='*';
                }else{
                    matrix[i][j]='.';
                }

            }
        }
        return matrix;
    }

    public static String caseStr(char[][] matrix){
        StringBuffer sb = new StringBuffer();
        sb.append(matrix.length+" "+matrix[0].length+"\n");
        for(int i = 0 ; i < matrix.length;i++){
            for(int j=0; j < matrix[0].length;j++){
                sb.append(matrix[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void writeInput(String str){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("G:\\Java study\\360 A1\\src\\minesweeper_input.txt"));
            out.write(str);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
