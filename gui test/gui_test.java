import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class a{
    public static void main(String[] arngs)
    {   
        gui_test1 test=new gui_test1();
        
    }
}

public class gui_test implements ActionListener {
    public JButton reset_b =new JButton("reset matrix");
    public JButton rem_Button=new JButton("rem check");
    public JButton rrem_Button=new JButton("rrem check"); 
    JTextField jc[]= new JTextField[100];
    int rows,columns;

    gui_test(int rows,int columns){
        this.rows=rows;
        this.columns=columns;
        JFrame f =new JFrame();
        Container cp = f.getContentPane();
        cp.setLayout(new BorderLayout());
        
        JPanel main_panel = new JPanel();
        main_panel.setLayout(new GridBagLayout());

        JPanel sub_panel1 = new JPanel();
        sub_panel1.setLayout(new GridBagLayout());

        
        JPanel sub_panel2 = new JPanel();
        sub_panel2.setLayout(new GridBagLayout());


        for(int i=0;i<rows*columns;i++){
            jc[i]=new JTextField("",3);
        } 

        
        GridBagConstraints c = new GridBagConstraints();
        c.insets=new Insets (5,5,5,5);
        int n=0;
        for(int i=0;i<rows;i++){
            for(int l=0;l<columns;l++){
                c.gridx=l;c.gridy=i;
                sub_panel1.add(jc[n],c);
                n++;
            }
        }

        
        c.gridx=2;c.gridy=1;
        sub_panel2.add(reset_b,c);
        c.gridx=1;c.gridy=1;
        sub_panel2.add(rem_Button,c);
        c.gridx=3;c.gridy=1;
        sub_panel2.add(rrem_Button,c);

        reset_b.addActionListener(this);
        rem_Button.addActionListener(this);
        rrem_Button.addActionListener(this);

        c.gridx=1;c.gridy=1;
        main_panel.add(sub_panel1,c);
        c.gridx=1;c.gridy=2;
        main_panel.add(sub_panel2,c);

        cp.add(main_panel,BorderLayout.CENTER);

        f.setSize(500,450);
        f.setVisible(true);
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        

    }
    public void actionPerformed(ActionEvent e){ 
        matrix_operation m_o=new matrix_operation(rows, columns);
        if(e.getSource() == reset_b){
            for(int i=0;i<columns;i++){
                for(int l=0;l<rows;l++){
                    jc[(i*columns)+l].setText("");
            }
        }
        }
        else if(e.getSource() == rem_Button){
            float[][] matrix=new float[rows][columns];
            for(int i=0;i<columns;i++){
                for(int l=0;l<rows;l++){
                matrix[i][l]=Float.parseFloat(jc[(i*columns)+l].getText());
                }
            }
            JOptionPane.showMessageDialog(null, "Row Echelon Matrix : "+m_o.check_row_echelon_matrix(matrix));
        }
        else if(e.getSource() == rrem_Button){
            float[][] matrix=new float[rows][columns];
            for(int i=0;i<columns;i++){
                for(int l=0;l<rows;l++){
                matrix[i][l]=Float.parseFloat(jc[(i*columns)+l].getText());
                }
            }
            JOptionPane.showMessageDialog(null, "Reduce Row Echelon Matrix : "+m_o.check_reduce_row_echelon_matrix(matrix));
        }
    }
}
class gui_test1 implements ActionListener{
    JLabel in_put_matrix_label = new JLabel("Input Matrix Size");
    JLabel row_label = new JLabel("Row Size");
    JLabel column_label = new JLabel("Column Size");
    JTextField row_textbox= new JTextField("",3);
    JTextField column_textbox= new JTextField("",3);
    JButton input_Button=new JButton("Input");

    gui_test1(){
        JFrame f =new JFrame();
        Container cp = f.getContentPane();
        cp.setLayout(new BorderLayout());

        JPanel main_panel = new JPanel();
        main_panel.setLayout(new GridBagLayout());
        

        JPanel sub_panel = new JPanel();
        sub_panel.setLayout(new GridBagLayout());

        input_Button.addActionListener(this);

        GridBagConstraints c = new GridBagConstraints();
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
        sub_panel.add(row_textbox,c);
        c.gridx=2;c.gridy=2;
        sub_panel.add(column_textbox,c);
        c.insets=new Insets(0,0,0,0);

        c.insets=new Insets(5,0,5,0);
        c.gridx=1;c.gridy=2;
        main_panel.add(sub_panel,c);
        c.gridx=1;c.gridy=3;
        main_panel.add(input_Button,c);
        c.insets=new Insets(0,0,0,0);
        
        cp.add(main_panel,BorderLayout.CENTER);

        f.setSize(300,200);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
    }
    public void actionPerformed(ActionEvent e){ 
        if(e.getSource() == input_Button){
            int row=Integer.parseInt(row_textbox.getText());
            int column=Integer.parseInt(column_textbox.getText());
            gui_test test=new gui_test(row,column);
        }
    }

}