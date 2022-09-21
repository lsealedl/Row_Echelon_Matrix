
public class test_case {
    public static void main(String[] arngs){
      

        test_case_tool test=new test_case_tool();
        /*
        System.out.println("ข้อ 1");
        float[] array1={
            1,0,2,1,
            0,1,4,3     
        };
        test.use(2, 4, array1, true, true);

        System.out.println("ข้อ 2");
        float[] array2={
            0,0,0,
            0,0,0,
            0,0,0       
        };
        test.use(3, 3, array2, true, true);

        System.out.println("ข้อ 3");
        float[] array3={
            1,0,0,
            0,0,0,
            0,0,1       
        };
        test.use(3, 3, array3, false, false);

        System.out.println("ข้อ 4");
        float[] array4={
            0,1,0,
            1,0,0,
            0,0,1       
        };
        test.use(3, 3, array4, false, false);

        System.out.println("ข้อ 5");
        float[] array5={
            -2,5,2,
            0,1,-1,
            0,0,3       
        };
        test.use(3, 3, array5, false, false);

        System.out.println("ข้อ 6");
        float[] array6={
            1,0,0,6,
            0,0,1,7,
            0,1,0,5    
        };
        test.use(3, 4, array6, false, false);

        System.out.println("ข้อ 7");
        float[] array7={
            1,3,0,2,0,
            0,0,1,1,0,
            0,0,0,0,1,
            0,0,0,0,0,  
        };
        test.use(4, 5, array7, true, true);

        System.out.println("ข้อ 8");
        float[] array8={
            1,2,0,3,0,
            1,0,2,2,0,
            0,0,0,0,1,
            0,0,0,0,0,  
        };
        test.use(4, 5, array8, false, false);

        System.out.println("ข้อ 9");
        float[] array9={
            1,2,0,0,1,
            0,0,1,2,3,
            0,0,0,0,0 
        };
        test.use(3, 5, array9, true, true);
        
        System.out.println("ข้อ 10");
        float[] array10={
            1,2,0,4,
            0,0,0,0,
            0,0,1,-3,
        };
        test.use(3, 4, array10, false, false);

        System.out.println("ข้อ 11");
        float[] array11={
            1,0,3,4,
            0,2,-2,5,
            0,0,1,2
        };
        test.use(3, 4, array11, false, false);

        System.out.println("ข้อ 12");
        float[] array12={
            1,2,3,4,
            0,1,-2,5,
            0,0,1,2
        };
        test.use(3, 4, array12, true, false);

        System.out.println("ข้อ 13");
        float[] array13={
            1,2,-5,2,
            0,1,-2,0,
            0,0,0,0
        };
        test.use(3, 4, array13, true, false);

        System.out.println("ข้อ 14");
        float[] array14={
            0,0,0,0
        };
        test.use(1, 4, array14, true, true);

        System.out.println("ข้อ 15");
        float[] array15={
            1,1,1,1,1
        };
        test.use(1, 5, array15, true, true);

        System.out.println("ข้อ 16");
        float[] array16={
            0,0,0,1
        };
        test.use(1, 4, array16, true, true);

        System.out.println("ข้อ 17");
        float[] array17={
            1,
            0,
            1,
            0,
            1
        };
        test.use(5, 1, array17, false, false);

        System.out.println("ข้อ 18");
        float[] array18={
            0,
            0,
            1,
            0,
            1
        };
        test.use(5, 1, array18, false, false);
        
        System.out.println("ข้อ 19");
        float[] array19={
            
            1,0,7,0,
            0,1,2,0,
            0,0,0,0
        };
        test.use(3, 4, array19, true, true);

        System.out.println("ข้อ 20");
        float[] array20={
            
            1,2,0,3,0,
            0,0,1,1,0,
            0,0,0,0,1,
            0,0,0,0,0
        };
        test.use(4, 5, array20, true, true);

        System.out.println("ข้อ 21");
        float[] array21={
            
           1,-7,5,5,
           0,1,3,2
        };
        test.use(2, 4, array21, true, false);

        System.out.println("ข้อ 22");
        float[] array22={
            
          1,-2,0,1,
          0,0,1,-2
        };
        test.use(2, 4, array22, true, true);

        System.out.println("ข้อ 23");
        float[] array23={
            
          1,2,3,
          0,0,0,
          0,0,1
        };
        test.use(3,3, array23, false, false);

        System.out.println("ข้อ 24");
        float[] array24={
            
          1,2,3,4,5,
          1,0,7,1,3,
          0,0,0,0,1,
          0,0,0,0,0
        };
        test.use(4, 5, array24, false, false);

        System.out.println("ข้อ 25");
        float[] array25={
            
          1,0,0,
          0,1,0,
          0,2,0
        };
        test.use(3, 3, array25, false, false);
        */

        System.out.println("ข้อ 1");
        float[] array_rrem_1={
          1,1,2,9,
          2,4,-3,1,
          3,6,-5,0
        };
        test.use_check_rem_rrem(3,4,array_rrem_1);
        
       /* 
        System.out.println("ข้อ 2");
        float[] array_rrem_2={
          1,
          2,
          3
        };
        test.use_check_rem_rrem(3,1,array_rrem_2);

        System.out.println("ข้อ 3");
        float[] array_rrem_3={
          1,1,
          2,4,
          3,6
        };
        test.use_check_rem_rrem(3,2,array_rrem_3);
        /*
        System.out.println("ข้อ 4");
        float[] array_rrem_4={
          1,-3,0,-1,0,-1,
          -1,3,1,3,0,3,
          2,-6,1,0,-1,-1,
          -1,3,2,5,1,6
        };
        test.use_check_rem_rrem(4,6,array_rrem_4);
        */
        /* 
        System.out.println("ข้อ 5");
        float[] array_rrem_5={
          0,1,
          2,4,
          3,6
        };
        test.use_check_rem_rrem(3,2,array_rrem_5);
        */
    }
    
}


class test_case_tool{
    test_case_tool(){};
    void use(int rows,int columns,float[] array,boolean rem,boolean rrem){
        matrix_operation_develop m = new matrix_operation_develop(rows,columns);
        float[][] matrix=new float[rows][columns];
        for(int i=0;i<rows;i++){
            for(int l=0;l<columns;l++){
                matrix[i][l]=array[(i*columns)+l];
            }
        }
        m.print_matrix(matrix);
        System.out.println("expectation | rem  : "+rem+" , rrem : "+rrem);
        System.out.println("result      | rem  : "+m.check_row_echelon_matrix(matrix)+" , rrem : "+m.check_reduce_row_echelon_matrix(matrix));
        if(rem!=m.check_row_echelon_matrix(matrix)||rrem!=m.check_reduce_row_echelon_matrix(matrix)){
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!NOT PASS!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        System.out.println("__________________________________________________________");
        System.out.println();
    }
    void use_check_rrem(int rows,int columns,float[] array){
        String method="";
        matrix_operation_develop m = new matrix_operation_develop(rows,columns);
        float[][] matrix=new float[rows][columns];
        for(int i=0;i<rows;i++){
            for(int l=0;l<columns;l++){
                matrix[i][l]=array[(i*columns)+l];
            }
        }
        //m.print_matrix(matrix);
        System.out.println("__________________________________________________________");
        m.rrem(matrix,method);
        m.print_matrix(matrix);
        System.out.println("__________________________________________________________");
    }
    void use_check_rem(int rows,int columns,float[] array){
        String method="";
        matrix_operation_develop m = new matrix_operation_develop(rows,columns);
        float[][] matrix=new float[rows][columns];
        for(int i=0;i<rows;i++){
            for(int l=0;l<columns;l++){
                matrix[i][l]=array[(i*columns)+l];
            }
        }
        //m.print_matrix(matrix);
        System.out.println("__________________________________________________________");
        m.rem(matrix,method);
        m.print_matrix(matrix);
        System.out.println("__________________________________________________________");
    }
    void use_check_rem_rrem(int rows,int columns,float[] array){
        String text1="",text2="";
        matrix_operation_develop m = new matrix_operation_develop(rows,columns);
        float[][] matrix_1=new float[rows][columns];
        float[][] matrix_2=new float[rows][columns];
        for(int i=0;i<rows;i++){
            for(int l=0;l<columns;l++){
                matrix_1[i][l]=array[(i*columns)+l];
            }
        }
        for(int i=0;i<rows;i++){
            for(int l=0;l<columns;l++){
                matrix_2[i][l]=array[(i*columns)+l];
            }
        }
        m.print_matrix(matrix_1);
        System.out.println();
        System.out.println("__________________________________________________________");
        
        System.out.println("rem : ");
        m.rem(matrix_1,text1);
        m.print_matrix(matrix_1);

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");

        System.out.println("rrem : ");
        m.rrem(matrix_2,text2);
        m.print_matrix(matrix_2);
        System.out.println();

        System.out.println("__________________________________________________________");
    }
}

