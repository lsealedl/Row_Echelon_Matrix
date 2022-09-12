
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;

import java.awt.*;
import java.awt.event.*;
import java.io.FileFilter;
public class gui_test{
    public static void main(String[] arngs)
    {   
        //new gui_first_page_test();
        new gui_second_page_test(1, 1);
        
    }
}

/*class gui_first_page_test implements ActionListener{
    JLabel in_put_matrix_label = new JLabel("Input Matrix Size");
    JLabel row_label = new JLabel("Row Size");
    JLabel column_label = new JLabel("Column Size");
    JTextField row_textbox= new JTextField("",3);
    JTextField column_textbox= new JTextField("",3);
    JButton input_Button=new JButton("Input");

    gui_first_page_test(){
        JFrame frame =new JFrame();
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
        main_panel.add(in_put_matrix_label,c);
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }
    public void actionPerformed(ActionEvent click_event){ 
        if(click_event.getSource() == input_Button){
            try {
                int row=Integer.parseInt(row_textbox.getText());
                int column=Integer.parseInt(column_textbox.getText());
                if((row>=1&&row<=10)&&column>=1&&column<=10){
                    new gui_second_page_test(row,column);
                }
                else{JOptionPane.showMessageDialog(null, "row and column size must be in 1 to 10");}
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Pls input only float");
            }
        }
    }

}
*/
class gui_second_page_test extends javax.swing.JFrame implements ActionListener{ //เพิ่มให้ class extends javax.swing.JFrame 
    JButton RowSizeUpJButton =new JButton();
    JButton RowSizeDownJButton =new JButton();
    JButton ColumnSizeUpJButton =new JButton();
    JButton ColumnSizeDownJButton =new JButton();
    JTextField matrix_textfield[][]= new JTextField[10][10];
    JButton rem_Button=new JButton();
    JButton rrem_Button=new JButton(); 
    JButton reset_Button =new JButton();
    JButton fill_zero_Button =new JButton();
    int row,column;

    JFrame frame =new JFrame();
    Container container = frame.getContentPane();

    JPanel main_panel = new JPanel();
    JPanel matrix_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JPanel top_panel = new JPanel();

    GridBagConstraints c = new GridBagConstraints();

    gui_second_page_test(int row,int column){
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

        RowSizeUpJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/up.png")));
        RowSizeUpJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RowSizeDownJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/down.png")));
        RowSizeDownJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ColumnSizeUpJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/right.png")));
        ColumnSizeUpJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ColumnSizeDownJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/left.png")));
        ColumnSizeDownJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        
        rem_Button.setFont(new java.awt.Font("Tahoma", 1, 13));
        rrem_Button.setFont(new java.awt.Font("Tahoma", 1, 13));
        reset_Button.setFont(new java.awt.Font("Tahoma", 1, 13));
        fill_zero_Button.setFont(new java.awt.Font("Tahoma", 1, 13));
       
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
       
        container.setLayout(new BorderLayout());

        //////////////////////////////////////////////////////ทำ panel ย่อย
        main_panel.setLayout(new GridBagLayout());

        matrix_panel.setLayout(new GridBagLayout());
        
        button_panel.setLayout(new GridBagLayout());

        top_panel.setLayout(new GridBagLayout());
        //////////////////////////////////////////////////////

        //////////////////////////////////////////////////////สร้างช่อง matrix
        for(int i=0;i<10;i++){
            for(int l=0;l<10;l++)
            matrix_textfield[i][l]=new JTextField("",3);
            //matrix_textfield[i][l].setHorizontalAlignment(SwingConstants.CENTER);
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

        c.gridx=1;c.gridy=1;
        main_panel.add(matrix_panel,c);
        c.gridx=1;c.gridy=2;
        main_panel.add(fill_zero_Button,c);
        c.gridx=1;c.gridy=3;
        main_panel.add(button_panel,c);

        c.gridx=1;c.gridy=2;
        top_panel.add(RowSizeUpJButton,c);
        c.gridx=2;c.gridy=2;
        top_panel.add(RowSizeDownJButton,c);
        c.gridx=4;c.gridy=2;
        top_panel.add(ColumnSizeUpJButton,c);
        c.gridx=3;c.gridy=2;
        top_panel.add(ColumnSizeDownJButton,c);
        //////////////////////////////////////////////////////

        container.add(top_panel,BorderLayout.NORTH);
       // container.add(matrix_panel,BorderLayout.CENTER);// ทำให้สวยขึ้นได้ แต่ยังมีบัค
        container.add(main_panel,BorderLayout.SOUTH);

        fill_zero_Button.addActionListener(this);
        reset_Button.addActionListener(this);
        rem_Button.addActionListener(this);
        rrem_Button.addActionListener(this);

        RowSizeUpJButton.addActionListener(this);
        RowSizeDownJButton.addActionListener(this);
        ColumnSizeUpJButton.addActionListener(this);
        ColumnSizeDownJButton.addActionListener(this);

        frame.setSize(500,550);
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void generate_matrix(int row ,int column,JPanel matrix_panel){
        matrix_panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets=new Insets (5,5,5,5);
        for(int i=row;i<10;i++){
            for(int l=0;l<10;l++){
                matrix_textfield[i][l].setText("");
            }
        }
        
        for(int i=0;i<10;i++){
            for(int l=column;l<10;l++){
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
    
    @Override
    public void actionPerformed(ActionEvent click_event) {
        matrix_operation_develop m_o=new matrix_operation_develop(row, column);
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
                if(row<10){
                    matrix_panel.setLayout(new GridBagLayout());
                    row++;
                    matrix_panel.removeAll();
                    generate_matrix(row,column,matrix_panel);
                    frame.revalidate();
                                     
                }
                
            }
            else if(click_event.getSource() == RowSizeDownJButton){
                if(row>1){
                    matrix_panel.setLayout(new GridBagLayout());
                    row--;
                    matrix_panel.removeAll();
                    generate_matrix(row,column,matrix_panel);
                    frame.revalidate();
                                     
                }
                
            }
            else if(click_event.getSource() == ColumnSizeUpJButton){
                if(column<10){
                    matrix_panel.setLayout(new GridBagLayout());
                    column++;
                    matrix_panel.removeAll();
                    generate_matrix(row,column,matrix_panel);
                    frame.revalidate();
                                     
                }
                
            }
            else if(click_event.getSource() == ColumnSizeDownJButton){
                if(column>1){
                    matrix_panel.setLayout(new GridBagLayout());
                    column--;
                    matrix_panel.removeAll();
                    generate_matrix(row,column,matrix_panel);
                    frame.revalidate();
                                     
                }
                
            }
            //System.out.println("row="+row);
            //System.out.println("column="+column);
            //System.out.println("-------------------------");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pls input only float"+e);
        }
        
    }
}