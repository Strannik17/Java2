import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	  String str = "500 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
	  int summa = 0;
	  String[][] arr = null;

        try {
            arr = strToArray(str);
            summa = sum(arr);
            System.out.println(summa);
        }catch (SizeExeption e){
            System.out.println("Матрица имела неверный размер!");
        }catch (NumberFormatException e){
            System.out.println("Один из элементов не является числом!");
        }


    }

    public static String[][] strToArray (String source) throws SizeExeption{
        String[][] returnedArray = new String[4][4];

        String[] array_splitted = source.split("\n");

        if (array_splitted.length != 4) {
            throw new SizeExeption("Matrix size incorrect!");
        }

        for (int i = 0; i < array_splitted.length; i++){
            String[] row = array_splitted[i].split("\\s");

            if (row.length != 4){
                throw new SizeExeption("Matrix size incorrect!");
            }else{
                for (int j = 0; j < row.length; j++) {
                    returnedArray[i][j] = row[j];
                }
            }

        }
        return returnedArray;
    }

    public static int sum(String[][] source) throws NumberFormatException{
        int result = 0;
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source.length; j++) {
                result+= Integer.parseInt(source[i][j]);
            }
        }

        return result / 2;
    }
}
