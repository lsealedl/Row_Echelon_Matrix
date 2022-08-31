public class test_case {
    public static void main(String[] arngs){
        System.out.println("ข้อ 1");
        matrix_operation m1 = new matrix_operation(2,4);
        float[][] a1=new float[2][4];
        a1[0][0]=1;a1[0][1]=0;a1[0][2]=2;a1[0][3]=1;
        a1[1][0]=0;a1[1][1]=1;a1[0][2]=4;a1[0][3]=3;
        m1.print_matrix(a1);
        System.out.println("rem : "+m1.check_row_echelon_matrix(a1)+"|true , rrem : "+m1.check_reduce_row_echelon_matrix(a1)+"|true");
        System.out.println();

        System.out.println("ข้อ 2");
        matrix_operation m2 = new matrix_operation(3,3);
        float[][] a2=new float[3][3];
        a2[0][0]=0;a2[0][1]=0;a2[0][2]=0;
        a2[1][0]=0;a2[1][1]=0;a2[1][2]=0;
        a2[2][0]=0;a2[2][1]=0;a2[2][2]=0;
        m2.print_matrix(a2);
        System.out.println("rem : "+m2.check_row_echelon_matrix(a2)+"|true , rrem : "+m2.check_reduce_row_echelon_matrix(a2)+"|true");
        System.out.println();

        System.out.println("ข้อ 3");
        matrix_operation m3 = new matrix_operation(3,3);
        float[][] a3=new float[3][3];
        a3[0][0]=1;a3[0][1]=0;a3[0][2]=0;
        a3[1][0]=0;a3[1][1]=0;a3[1][2]=0;
        a3[2][0]=0;a3[2][1]=0;a3[2][2]=1;
        m3.print_matrix(a3);
        System.out.println("rem : "+m3.check_row_echelon_matrix(a3)+"|false , rrem : "+m3.check_reduce_row_echelon_matrix(a3)+"|false");
        System.out.println();

        System.out.println("ข้อ 4");
        matrix_operation m4 = new matrix_operation(3,3);
        float[][] a4=new float[3][3];
        a4[0][0]=0;a4[0][1]=1;a4[0][2]=0;
        a4[1][0]=1;a4[1][1]=0;a4[1][2]=0;
        a4[2][0]=0;a4[2][1]=0;a4[2][2]=1;
        m4.print_matrix(a4);
        System.out.println("rem : "+m4.check_row_echelon_matrix(a4)+"|false , rrem : "+m4.check_reduce_row_echelon_matrix(a4)+"|false");
        System.out.println();

        System.out.println("ข้อ 5");
        matrix_operation m5 = new matrix_operation(3,3);
        float[][] a5=new float[3][3];
        a5[0][0]=-2;a5[0][1]=5;a5[0][2]=2;
        a5[1][0]=0;a5[1][1]=1;a5[1][2]=-1;
        a5[2][0]=0;a5[2][1]=0;a5[2][2]=3;
        m5.print_matrix(a5);
        System.out.println("rem : "+m5.check_row_echelon_matrix(a5)+"|false , rrem : "+m5.check_reduce_row_echelon_matrix(a5)+"|false");
        System.out.println();

        System.out.println("ข้อ 6");
        matrix_operation m6 = new matrix_operation(3,4);
        float[][] a6=new float[3][4];
        a6[0][0]=1;a6[0][1]=0;a6[0][2]=0;a6[0][3]=6;
        a6[1][0]=0;a6[1][1]=0;a6[1][2]=1;a6[1][3]=7;
        a6[2][0]=0;a6[2][1]=1;a6[2][2]=0;a6[2][3]=5;
        m6.print_matrix(a6);
        System.out.println("rem : "+m6.check_row_echelon_matrix(a6)+"|false , rrem : "+m6.check_reduce_row_echelon_matrix(a6)+"|false");
        System.out.println();

        System.out.println("ข้อ 7");
        matrix_operation m7 = new matrix_operation(4,5);
        float[][] a7=new float[4][5];
        a7[0][0]=1;a7[0][1]=3;a7[0][2]=0;a7[0][3]=2;a7[0][4]=0;
        a7[1][0]=0;a7[1][1]=0;a7[1][2]=1;a7[1][3]=1;a7[1][4]=0;
        a7[2][0]=0;a7[2][1]=0;a7[2][2]=0;a7[2][3]=0;a7[2][4]=1;
        a7[3][0]=0;a7[3][1]=0;a7[3][2]=0;a7[3][3]=0;a7[3][4]=0;
        m7.print_matrix(a7);
        System.out.println("rem : "+m7.check_row_echelon_matrix(a7)+"|true , rrem : "+m7.check_reduce_row_echelon_matrix(a7)+"|true");
        System.out.println();

        System.out.println("ข้อ 8");
        matrix_operation m8 = new matrix_operation(4,5);
        float[][] a8=new float[4][5];
        a8[0][0]=1;a8[0][1]=2;a8[0][2]=0;a8[0][3]=3;a8[0][4]=0;
        a8[1][0]=1;a8[1][1]=0;a8[1][2]=2;a8[1][3]=2;a8[1][4]=0;
        a8[2][0]=0;a8[2][1]=0;a8[2][2]=0;a8[2][3]=0;a8[2][4]=1;
        a8[3][0]=0;a8[3][1]=0;a8[3][2]=0;a8[3][3]=0;a8[3][4]=0;
        m8.print_matrix(a8);
        System.out.println("rem : "+m8.check_row_echelon_matrix(a8)+"|false , rrem : "+m8.check_reduce_row_echelon_matrix(a8)+"|false");
        System.out.println();



    }
    
}
