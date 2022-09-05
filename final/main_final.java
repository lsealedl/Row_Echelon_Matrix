import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class main_final{
    public static void main(String[] arngs)
    {   
        new gui_first_page();
    }
}

class gui_first_page implements ActionListener{
    private JLabel input_matrix_label = new JLabel("Input Matrix Size");
    private JLabel row_label = new JLabel("Row Size");
    private JLabel column_label = new JLabel("Column Size");
    private JTextField row_textbox= new JTextField("",3);
    private JTextField column_textbox= new JTextField("",3);
    private JButton input_Button=new JButton("Input");
    private JFrame frame =new JFrame();

    gui_first_page(){

        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());

        //////////////////////////////////////////////////////ทำ panel ย่อย
        JPanel main_panel = new JPanel();
        main_panel.setLayout(new GridBagLayout());
        
        JPanel sub_panel = new JPanel();
        sub_panel.setLayout(new GridBagLayout());
        //////////////////////////////////////////////////////

        GridBagConstraints c = new GridBagConstraints();

        //////////////////////////////////////////////////////จัดองค์ประกอบต่างๆ
        c.insets=new Insets(5,0,30,0);
        c.gridx=1;c.gridy=1;
        //System.out.println(javax.swing.UIManager.getDefaults().getFont("Label.font"));

        input_matrix_label.setFont(new Font("Dialog",Font.BOLD,25));
        main_panel.add(input_matrix_label,c);
        c.insets=new Insets(0,0,0,0);

        c.insets=new Insets(0,10,0,10);
        c.gridx=1;c.gridy=1;
        sub_panel.add(row_label,c);
        c.gridx=2;c.gridy=1;
        sub_panel.add(column_label,c);
        c.gridx=1;c.gridy=2;
        row_textbox.setHorizontalAlignment(SwingConstants.CENTER);
        sub_panel.add(row_textbox,c);
        c.gridx=2;c.gridy=2;
        column_textbox.setHorizontalAlignment(SwingConstants.CENTER);
        sub_panel.add(column_textbox,c);
        c.insets=new Insets(0,0,0,0);

        c.insets=new Insets(5,0,5,0);
        c.gridx=1;c.gridy=2;
        main_panel.add(sub_panel,c);
        c.gridx=1;c.gridy=3;
        main_panel.add(input_Button,c);
        c.insets=new Insets(0,0,0,0);
        //////////////////////////////////////////////////////

        container.add(main_panel,BorderLayout.CENTER);

        input_Button.addActionListener(this);

        frame.setSize(300,200);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    public void actionPerformed(ActionEvent click_event){ 
        if(click_event.getSource() == input_Button){
            try {
                int row=Integer.parseInt(row_textbox.getText());
                int column=Integer.parseInt(column_textbox.getText());
                if((row>=1&&row<=10)&&column>=1&&column<=10){
                    new gui_second_page_test(row,column);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

                }
                else{JOptionPane.showMessageDialog(null, "row and column size must be in 1 to 10");}
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Pls input only float");
            }
        }
    }

}

class gui_second_page_test implements ActionListener{
    private JTextField matrix_textfield[]= new JTextField[100];
    private JButton rem_Button=new JButton("Row Echelon Check");
    private JButton rrem_Button=new JButton("Reduced Row Echelon Check"); 
    private JButton reset_Button =new JButton("Reset Matrix");
    private JButton fill_zero_Button =new JButton("Fill Empty Matix With 0");
    private int row,column;

    gui_second_page_test(int row,int column){
        this.row=row;
        this.column=column;

        JFrame frame =new JFrame();
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());

        //////////////////////////////////////////////////////ทำ panel ย่อย
        JPanel main_panel = new JPanel();
        main_panel.setLayout(new GridBagLayout());

        JPanel matrix_panel = new JPanel();
        matrix_panel.setLayout(new GridBagLayout());
        
        JPanel button_panel = new JPanel();
        button_panel.setLayout(new GridBagLayout());
        //////////////////////////////////////////////////////

        //////////////////////////////////////////////////////สร้างช่อง matrix
        for(int i=0;i<row*column;i++){
            matrix_textfield[i]=new JTextField("",3);
            matrix_textfield[i].setHorizontalAlignment(SwingConstants.CENTER);
        }
        //////////////////////////////////////////////////////

        //////////////////////////////////////////////////////จัดองค์ประกอบต่างๆ
        GridBagConstraints c = new GridBagConstraints();
        c.insets=new Insets (5,5,5,5);
        int n=0;
        for(int i=0;i<row;i++){
            for(int l=0;l<column;l++){
                c.gridx=l;c.gridy=i;
                matrix_panel.add(matrix_textfield[n],c);
                n++;
            }
        }

        c.gridx=1;c.gridy=1;
        button_panel.add(rem_Button,c);
        c.gridx=2;c.gridy=1;
        button_panel.add(reset_Button,c);
        c.gridx=3;c.gridy=1;
        button_panel.add(rrem_Button,c);
        
        c.gridx=1;c.gridy=1;
        main_panel.add(matrix_panel,c);
        c.gridx=1;c.gridy=2;
        main_panel.add(fill_zero_Button,c);
        c.gridx=1;c.gridy=3;
        main_panel.add(button_panel,c);
        //////////////////////////////////////////////////////

        container.add(main_panel,BorderLayout.CENTER);

        fill_zero_Button.addActionListener(this);
        reset_Button.addActionListener(this);
        rem_Button.addActionListener(this);
        rrem_Button.addActionListener(this);

        frame.setSize(700,450);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent click_event) {
        matrix_operation m_o=new matrix_operation(row, column);
        try {
            if(click_event.getSource() == reset_Button){
                for(int i=0;i<row;i++){
                    for(int l=0;l<column;l++){
                        matrix_textfield[(i*column)+l].setText("");
                }
            }
            }
            else if(click_event.getSource() == rem_Button){
                float[][] matrix=new float[row][column];
                for(int i=0;i<row;i++){
                    for(int l=0;l<column;l++){
                    matrix[i][l]=Float.parseFloat(matrix_textfield[(i*column)+l].getText());
                    }
                }
                JOptionPane.showMessageDialog(null, "Row Echelon Matrix : "+m_o.check_row_echelon_matrix(matrix));
            }
            else if(click_event.getSource() == rrem_Button){
                float[][] matrix=new float[row][column];
                for(int i=0;i<row;i++){
                    for(int l=0;l<column;l++){
                    matrix[i][l]=Float.parseFloat(matrix_textfield[(i*column)+l].getText());
                    }
                }
                JOptionPane.showMessageDialog(null, "Reduce Row Echelon Matrix : "+m_o.check_reduce_row_echelon_matrix(matrix));
            }    
            else if(click_event.getSource() == fill_zero_Button){
                for(int i=0;i<row;i++){
                    for(int l=0;l<column;l++){ 
                        if((matrix_textfield[(i*column)+l].getText().isBlank())){
                            matrix_textfield[(i*column)+l].setText("0");
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pls input only float");
        }
        
    }
}

interface matrix_operation_template{
    boolean row_is_zero(float[][]matrix,int row);
    int leading_coefficient(float[][]matrix,int row);
    boolean check_row_echelon_matrix(float[][] matrix);
    boolean check_reduce_row_echelon_matrix(float[][] matrix);
}

class matrix_operation implements matrix_operation_template{
    /*
    rows คือ จำนวนแถว
    columns คือ จำนวนหลัก
    ปัญหาคือ เวลาเก็บใน array มันเริ่มที่ 0 แต่ใน matrix มันเริ่มที่ 1 เวลาใช้ method เลยนับว่าให้เริ่มที่ 1 ตาม matrix
    */
    public int rows,columns;
    Scanner input=new Scanner(System.in);

    matrix_operation(int rows,int columns){//กำหนดจำนวนแถวและหลัก
        this.rows=rows;
        this.columns=columns;
    }  

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
}