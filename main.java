import java.util.*;
public class main
{
    public static void main(String[] arngs)
    {   
        Scanner input=new Scanner(System.in);
        int rows,columns;

        System.out.print("Pls input rows size:");
        rows=input.nextInt();
        System.out.print("Pls input columns size:");
        columns=input.nextInt();
        
        float[][] matrix=new float[rows][columns];
        matrix_operation matrix_operation=new matrix_operation(rows,columns);
        matrix_operation.input_matix_all(matrix);

        System.out.println("REM : "+matrix_operation.check_row_echelon_matrix(matrix));
        System.out.println("RREM : "+matrix_operation.check_reduce_row_echelon_matrix(matrix));
        //matrix_operation.rem(matrix);
        matrix_operation.print_matrix(matrix);

        
    }
}

