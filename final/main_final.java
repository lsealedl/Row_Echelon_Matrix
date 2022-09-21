import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class main_final{
    public static void main(String[] arngs)
    {   
        new gui(1,1);
    }
}

class gui extends javax.swing.JFrame implements ActionListener{ //เพิ่มให้ class extends javax.swing.JFrame 
    private int max=15;

    private JButton RowSizeUpJButton =new JButton();
    private JButton RowSizeDownJButton =new JButton();
    private JButton ColumnSizeUpJButton =new JButton();
    private JButton ColumnSizeDownJButton =new JButton();
    private JTextField matrix_textfield[][]= new JTextField[max][max];
    private JButton rem_Button=new JButton();
    private JButton rrem_Button=new JButton(); 
    private JButton reset_Button =new JButton();
    private JButton fill_zero_Button =new JButton();
    private int row,column;

    JFrame frame =new JFrame();
    Container container = frame.getContentPane();

    private JPanel main_panel = new JPanel();
    private JPanel matrix_panel = new JPanel();
    private JPanel button_panel = new JPanel();
    private JPanel top_panel = new JPanel();

    private JPanel matrix_panel_center = new JPanel();
    private JTextField row_sizeJTextField = new JTextField("",3);
    private JTextField column_sizeJTextField = new JTextField("",3);
    private JButton enter_matrix_size_JButton = new JButton("Enter Matrix Size");
    GridBagConstraints c = new GridBagConstraints();

    private int frame_width;

    gui(int row,int column){
        this.row=row;
        this.column=column;
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////// ทำให้ปุ่มใช้ feature ที่มีใน  javax.swing มาใช้
        RowSizeUpJButton =new javax.swing.JButton();
        RowSizeDownJButton =new javax.swing.JButton();
        ColumnSizeUpJButton =new javax.swing.JButton();
        ColumnSizeDownJButton =new javax.swing.JButton();
        rem_Button=new javax.swing.JButton("rem check");
        rrem_Button=new javax.swing.JButton("rrem check");
        reset_Button =new javax.swing.JButton("reset matrix");
        fill_zero_Button =new javax.swing.JButton("fill empty matix with 0");

        ///////////////////////////////////////////////////////////////////////////////////////////////////// set รูป/ลักษณะปุ่มให้ปุ่ม , กำหนดตัวอักษร
        
        RowSizeUpJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("up.png")));
        RowSizeUpJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RowSizeDownJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("down.png")));
        RowSizeDownJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ColumnSizeUpJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("right.png")));
        ColumnSizeUpJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ColumnSizeDownJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("left.png")));
        ColumnSizeDownJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        
        rem_Button.setFont(new java.awt.Font("Tahoma", 1, 13));
        rrem_Button.setFont(new java.awt.Font("Tahoma", 1, 13));
        reset_Button.setFont(new java.awt.Font("Tahoma", 1, 13));
        fill_zero_Button.setFont(new java.awt.Font("Tahoma", 1, 13));

        row_sizeJTextField.setHorizontalAlignment(SwingConstants.CENTER);
        column_sizeJTextField.setHorizontalAlignment(SwingConstants.CENTER);
       
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
       
        container.setLayout(new BorderLayout());

        //////////////////////////////////////////////////////ทำ panel ย่อย
        main_panel.setLayout(new GridBagLayout());

        matrix_panel.setLayout(new GridBagLayout());
        
        button_panel.setLayout(new GridBagLayout());

        top_panel.setLayout(new GridBagLayout());

        matrix_panel_center.setLayout(new GridBagLayout());
        //////////////////////////////////////////////////////

        //////////////////////////////////////////////////////สร้างช่อง matrix
        for(int i=0;i<max;i++){
            for(int l=0;l<max;l++){
                matrix_textfield[i][l]=new JTextField("",3);
                matrix_textfield[i][l].setHorizontalAlignment(SwingConstants.CENTER);}
        }
        //////////////////////////////////////////////////////

        //////////////////////////////////////////////////////จัดองค์ประกอบต่างๆ
        c.insets=new Insets (5,5,5,5);
        //int n=0;
        for(int i=0;i<row;i++){
            for(int l=0;l<column;l++){
                c.gridx=l;c.gridy=i;
                matrix_panel.add(matrix_textfield[i][l],c);
                //n++;
            }
        }

        c.gridx=1;c.gridy=1;
        button_panel.add(rem_Button,c);
        c.gridx=2;c.gridy=1;
        button_panel.add(reset_Button,c);
        c.gridx=3;c.gridy=1;
        button_panel.add(rrem_Button,c);

        /* 
        c.gridx=1;c.gridy=1;
        main_panel.add(matrix_panel,c);*/
        c.gridx=1;c.gridy=1;
        matrix_panel_center.add(matrix_panel,c);

        c.gridx=1;c.gridy=2;
        main_panel.add(fill_zero_Button,c);
        c.gridx=1;c.gridy=3;
        main_panel.add(button_panel,c);

        c.gridx=2;c.gridy=1;
        top_panel.add(RowSizeUpJButton,c);
        c.gridx=2;c.gridy=2;
        top_panel.add(RowSizeDownJButton,c);
        c.gridx=6;c.gridy=1;
        top_panel.add(ColumnSizeUpJButton,c);
        c.gridx=5;c.gridy=1;
        top_panel.add(ColumnSizeDownJButton,c);

        c.gridx=1;c.gridy=1;
        top_panel.add(row_sizeJTextField,c);
        row_sizeJTextField.setText(row+"");

        c.gridx=4;c.gridy=1;
        top_panel.add(column_sizeJTextField,c);
        column_sizeJTextField.setText(column+"");

        c.gridx=3;c.gridy=1;
        top_panel.add(enter_matrix_size_JButton,c);
        
        //////////////////////////////////////////////////////

        container.add(top_panel,BorderLayout.NORTH);


        container.add(matrix_panel_center,BorderLayout.CENTER); //ทำให้สวยขึ้นได้ แต่ยังมีบัค

        container.add(main_panel,BorderLayout.SOUTH);

        fill_zero_Button.addActionListener(this);
        reset_Button.addActionListener(this);
        rem_Button.addActionListener(this);
        rrem_Button.addActionListener(this);

        RowSizeUpJButton.addActionListener(this);
        RowSizeDownJButton.addActionListener(this);
        ColumnSizeUpJButton.addActionListener(this);
        ColumnSizeDownJButton.addActionListener(this);

        enter_matrix_size_JButton.addActionListener(this);
        frame.pack();
        //frame.setSize(500,550);
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame_width=frame.getWidth();
    }

    public void generate_matrix(int row ,int column,JPanel matrix_panel){
        matrix_panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets=new Insets (5,5,5,5);
        for(int i=row;i<max;i++){
            for(int l=0;l<max;l++){
                matrix_textfield[i][l].setText("");
            }
        }
        
        for(int i=0;i<max;i++){
            for(int l=column;l<max;l++){
                matrix_textfield[i][l].setText("");
            }
        }
        for(int i=0;i<row;i++){
            for(int l=0;l<column;l++){
                c.gridx=l;c.gridy=i;
                matrix_panel.add(matrix_textfield[i][l],c);
                //n++;
            }
        }
        /* 
        for(int i=n+1;i<100;i++){
            matrix_textfield[n].setText("");
        }*/
    }
    public void reload_matrix(){
        matrix_panel.setLayout(new GridBagLayout());
        matrix_panel.removeAll();
        generate_matrix(row,column,matrix_panel);
        frame.revalidate();
        row_sizeJTextField.setText(row+"");  
        column_sizeJTextField.setText(column+"");    
        frame.pack();

        Point frame_location=frame.getLocation();
        frame.setLocation((int)frame_location.getX()-(frame.getWidth()-frame_width)/2, (int)frame_location.getY());

        frame_width=frame.getWidth();
    }
    
    @Override
    public void actionPerformed(ActionEvent click_event) {
        matrix_operation m_o=new matrix_operation(row, column);
        try {
            if(click_event.getSource() == reset_Button){
                for(int i=0;i<row;i++){
                    for(int l=0;l<column;l++){
                        matrix_textfield[i][l].setText("");
                }
            }
            }
            else if(click_event.getSource() == rem_Button){
                float[][] matrix=new float[row][column];
                for(int i=0;i<row;i++){
                    for(int l=0;l<column;l++){
                    matrix[i][l]=Float.parseFloat(matrix_textfield[i][l].getText());
                    }
                }
                JOptionPane.showMessageDialog(null, "Row Echelon Matrix : "+m_o.check_row_echelon_matrix(matrix));
            }
            else if(click_event.getSource() == rrem_Button){
                float[][] matrix=new float[row][column];
                for(int i=0;i<row;i++){
                    for(int l=0;l<column;l++){
                    matrix[i][l]=Float.parseFloat(matrix_textfield[i][l].getText());
                    }
                }
                JOptionPane.showMessageDialog(null, "Reduce Row Echelon Matrix : "+m_o.check_reduce_row_echelon_matrix(matrix));
            }    
            else if(click_event.getSource() == fill_zero_Button){
                for(int i=0;i<row;i++){
                    for(int l=0;l<column;l++){ 
                        if((matrix_textfield[i][l].getText().isBlank())){
                            matrix_textfield[i][l].setText("0");
                        }
                    }
                }
            }
            else if(click_event.getSource() == RowSizeUpJButton){
                if(row<max){
                    row++;
                    reload_matrix();        
                }
                
            }
            else if(click_event.getSource() == RowSizeDownJButton){
                if(row>1){
                    row--;
                    reload_matrix();                
                }
                
            }
            else if(click_event.getSource() == ColumnSizeUpJButton){
                if(column<max){
                    column++;
                    reload_matrix();                  
                }
                
            }
            else if(click_event.getSource() == ColumnSizeDownJButton){
                if(column>1){
                    column--;
                    reload_matrix();               
                }
                
            }
            else if(click_event.getSource()==enter_matrix_size_JButton){
                try {
                    if(Integer.parseInt(column_sizeJTextField.getText())>=1&&Integer.parseInt(column_sizeJTextField.getText())<=max
                    &&Integer.parseInt(row_sizeJTextField.getText())>=1&&Integer.parseInt(row_sizeJTextField.getText())<=max){
                        column=Integer.parseInt(column_sizeJTextField.getText());
                        row=Integer.parseInt(row_sizeJTextField.getText());
                        reload_matrix();
                    }
                    else{JOptionPane.showMessageDialog(null, "Pls Matrix Size in 1 to "+max);}
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Pls Input Only Integer In Matrix Size"/*+e*/);
                }
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pls Input Only Float In Matrix"/*+e*/);
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
    private int rows,columns;
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