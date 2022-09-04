import java.util.Scanner;
import javax.swing.*;
import java.util.*;
import java.awt.*;
public class gui_test {

    public static void main(String[] arngs){new gui_test();}

    gui_test(){
    int rows=10,columns=10;
    int number=rows*columns;

    JFrame f =new JFrame();
    Container cp = f.getContentPane();
    cp.setLayout(new BorderLayout());
    JPanel p = new JPanel();
    p.setLayout(new GridBagLayout());
    JComponent jc[] = new JComponent[number];
    for(int i=0;i<number;i++){
        jc[i]=new JTextField("",3);
    } 
    cp.add(p,BorderLayout.NORTH);
    
    GridBagConstraints c = new GridBagConstraints();
    c.insets=new Insets (15,15,15,15);
    int n=0;
    for(int i=0;i<rows;i++){
        for(int l=0;l<columns;l++){
            c.gridx=l;c.gridy=i;
            p.add(jc[n],c);
            n++;
        }
    }
    JPanel p2 = new JPanel();
    p2.setLayout(new GridBagLayout());
    JButton reset_b =new JButton("reset matrix");
    GridBagConstraints c2 = new GridBagConstraints();
    c2.insets=new Insets (40,40,40,40);
    p2.add(reset_b,c2);
    cp.add(p2,BorderLayout.SOUTH);
    
    f.add(p);  
    f.setSize(700,700);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLocationRelativeTo(null);
    
    }
}