import java.util.*;

interface matrix_operation_template{
    boolean row_is_zero(float[][]matrix,int row);
    int leading_coefficient(float[][]matrix,int row);
    boolean check_row_echelon_matrix(float[][] matrix);
    boolean check_reduce_row_echelon_matrix(float[][] matrix);
}

public class matrix_operation implements matrix_operation_template{
    /*
    rows คือ จำนวนแถว
    columns คือ จำนวนหลัก
    ปัญหาคือ เวลาเก็บใน array มันเริ่มที่ 0 แต่ใน matrix มันเริ่มที่ 1 เวลาใช้ method เลยนับว่าให้เริ่มที่ 1 ตาม matrix
    */
    int rows,columns;
    Scanner input=new Scanner(System.in);

    matrix_operation(int rows,int columns){//กำหนดจำนวนแถวและหลัก
        this.rows=rows;
        this.columns=columns;
    }  
    ////////////////////////////////////////////////////////////////
    void input_matix_all(float[][]matrix){//ใส่ค่าให้ matrix เฉยๆ
        for(int i=0;i<rows;i++){
            for(int l=0;l<columns;l++){
                System.out.print("matrix["+(i+1)+"]["+(l+1)+"]=");
                matrix[i][l]=input.nextFloat();
            }
        }
    }

    void print_matrix(float[][] matrix){
        for(int i=0;i<rows;i++){
            for(int l=0;l<columns;l++){
                System.out.print(matrix[i][l]+" ");
            }
            System.out.println();
        }
    }

    ///////////////////////////////////////////////////////////////////

    public boolean row_is_zero(float[][]matrix,int row){//return ว่าแถวเป็น 0 ทั้งแถวหรือเปล่า
        boolean row_is_zero=true;
        for(int i=0;i<columns;i++){
            if(matrix[row-1][i]==0){}
            else{row_is_zero=false;}
        }
        if(row_is_zero==true){
            return true;
        }
        else{return false;}
    }

    public int leading_coefficient(float[][]matrix,int row){//return ตำแหน่งของตัวนำ 1 ในแถว ถ้าไม่มีจะ return -1
        for(int i=0;i<columns;i++){
            if(matrix[row-1][i]==1){
                return i+1;
            }
            else if(matrix[row-1][i]==0){}
            else {return -1;}
        }        
        return -1;
    }
    
    public boolean check_row_echelon_matrix(float[][] matrix){//เช็คว่าเป็น row echelon matrix เปล่า
        matrix_operation m_o=new matrix_operation(rows,columns);
        if(rows==1){
            if((m_o.row_is_zero(matrix,1))||m_o.leading_coefficient(matrix,1)!=-1){return true;}//ถ้า matrix มี 1 แถวแล้วแถว 1 เป็น 0 ทั้งแถวหรือมีตัวนำ 1
            else return false;}
        for(int i=2;i<=rows;i++){
            if((m_o.leading_coefficient(matrix,i-1)!=-1||m_o.row_is_zero(matrix,i-1))&&(m_o.leading_coefficient(matrix,i)!=-1||m_o.row_is_zero(matrix,i))){//ถ้า (matrix ตัวก่อนหน้ามีตัวนำ 1 หรือเป็น 0 ทั้งแถว) และ (matrix ตัวปัจจุบันมีตัวนำ 1 หรือเป็น 0 ทั้งแถว)
                if(m_o.leading_coefficient(matrix,i-1)!=-1&&m_o.leading_coefficient(matrix,i)!=-1){
                    if(m_o.leading_coefficient(matrix,i-1)<m_o.leading_coefficient(matrix,i)){}
                    else{return false;}
                }
                else if(m_o.leading_coefficient(matrix,i-1)!=-1&&m_o.row_is_zero(matrix,i)){}//matrix ตัวก่อนหน้าต้องมี ตัวนำ 1 และ ตัวปัจจุบันต้องเป็น 0 ทั้งแถว
                else if(m_o.row_is_zero(matrix,i-1)&&m_o.row_is_zero(matrix,i)){}///matrix ตัวก่อนหน้าต้องป็น 0 ทั้งแถวและ ตัวปัจจุบันต้องเป็น 0 ทั้งแถว
                else {return false;}
            }
            else {return false;}                        
        }
        for(int i=1;i<=rows;i++){
            if(m_o.leading_coefficient(matrix,i)!=-1){//เลือกม่าเฉพาะแถวที่มีตัวนำ 1
                for(int l=i;l<=rows;l++){
                    if(matrix[l-1][m_o.leading_coefficient(matrix,i)-1]==0){}//ในหลักของตัวนำ 1 ตัวที่ไม่ใช่ตัวนำ 1 ต้องเป็น 0 เท่านั้น เฉพาะข้างล่าง
                    else if(l==i){}//กัน for loop แล้วเจอตัวนำ 1 เพราะตัวนำ 1 ไม่ใช่ 0
                    else {return false;}
                }
            }
        }
        return true;
    }

    
    public boolean check_reduce_row_echelon_matrix(float[][] matrix){//เช็คว่าเป็น reduce row echelon matrix เปล่า
        matrix_operation m_o=new matrix_operation(rows,columns);
        if(m_o.check_row_echelon_matrix(matrix)){//เช็คว่าเป็น rem เปล่าถ้าไม่เป็นก็ไม่มีทางเป็น rrem ได้
            for(int i=1;i<=rows;i++){
                if(m_o.leading_coefficient(matrix,i)!=-1){//เลือกม่าเฉพาะแถวที่มีตัวนำ 1
                    for(int l=1;l<=rows;l++){
                        if(matrix[l-1][m_o.leading_coefficient(matrix,i)-1]==0){}//ในหลักของตัวนำ 1 ตัวที่ไม่ใช่ตัวนำ 1 ต้องเป็น 0 เท่านั้น ทั้งข้างบนข้างล่าง
                        else if(l==i){}//กัน for loop แล้วเจอตัวนำ 1 เพราะตัวนำ 1 ไม่ใช่ 0
                        else return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////หลังจากนี้เป็นส่วนของการให้หา rem ไม่ใช่เช็ค
    void multiplying_row_by_constant(float[][] matrix,int row,float constant){
        if(constant==0){
            return;
        }
        else{for(int i=0;i<columns;i++){
            matrix[row-1][i]=matrix[row-1][i]*constant;
        }}
    }

    void adding_row_by_row(float[][] matrix,int row_1,int row_2,int constant){//row_1 คือตัวตั้ง row_2 คือตัวบวก
        if(constant==0){
            return;
        }
        else{for(int i=0;i<columns;i++){
            matrix[row_1-1][i]=matrix[row_1-1][i]+(matrix[row_2-1][i]*constant);
        }}
    }

    void switching_two_rows(float[][] matrix,int row_1,int row_2){//สลับแถว
        for(int i=0;i<columns;i++){
            float tmp=matrix[row_1-1][i];
            matrix[row_1-1][i]=matrix[row_2-1][i];
            matrix[row_2-1][i]=tmp;
        }
    }

    void rem(float[][]matrix){//ยังไม่เสร็จ อาจไม่ต้องทำ
        matrix_operation m_o=new matrix_operation(rows,columns);
        while(m_o.check_row_echelon_matrix(matrix)!=true){
            for(int i=2;i<=rows;i++){
                if(m_o.row_is_zero(matrix, i-1)&&(m_o.row_is_zero(matrix, i)==false)){m_o.switching_two_rows(matrix, i-1, i);i=2;}
            }            
        }
    }


}
