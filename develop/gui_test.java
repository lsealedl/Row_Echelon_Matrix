
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class gui_test{
    public static void main(String[] arngs)
    {   
        new gui_first_page_test();
        
    }
}

class gui_first_page_test implements ActionListener{
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

class gui_second_page_test implements ActionListener{
    JTextField matrix_textfield[]= new JTextField[100];
    JButton rem_Button=new JButton("rem check");
    JButton rrem_Button=new JButton("rrem check"); 
    JButton reset_Button =new JButton("reset matrix");
    JButton fill_zero_Button =new JButton("fill empty matix with 0");
    int row,column;

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

        frame.setSize(500,450);
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent click_event) {
        matrix_operation_develop m_o=new matrix_operation_develop(row, column);
        try {
            if(click_event.getSource() == reset_Button){
                for(int i=0;i<column;i++){
                    for(int l=0;l<row;l++){
                        matrix_textfield[(i*column)+l].setText("");
                }
            }
            }
            else if(click_event.getSource() == rem_Button){
                float[][] matrix=new float[row][column];
                for(int i=0;i<column;i++){
                    for(int l=0;l<row;l++){
                    matrix[i][l]=Float.parseFloat(matrix_textfield[(i*column)+l].getText());
                    }
                }
                JOptionPane.showMessageDialog(null, "Row Echelon Matrix : "+m_o.check_row_echelon_matrix(matrix));
            }
            else if(click_event.getSource() == rrem_Button){
                float[][] matrix=new float[row][column];
                for(int i=0;i<column;i++){
                    for(int l=0;l<row;l++){
                    matrix[i][l]=Float.parseFloat(matrix_textfield[(i*column)+l].getText());
                    }
                }
                JOptionPane.showMessageDialog(null, "Reduce Row Echelon Matrix : "+m_o.check_reduce_row_echelon_matrix(matrix));
            }    
            else if(click_event.getSource() == fill_zero_Button){
                for(int i=0;i<column;i++){
                    for(int l=0;l<row;l++){ 
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