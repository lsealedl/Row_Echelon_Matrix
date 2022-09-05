import java.util.Scanner;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.lang.Math;
import java.awt.event.*;
public class guimatrix {
    
    guimatrix(){
    JFrame f =new JFrame();
    Container cp = f.getContentPane();
    cp.setLayout(new BorderLayout());
     
    JPanel p = new JPanel();
    p.setLayout(new GridBagLayout());
    JComponent jc[] = new JComponent[100];
    for(int i=0;i<100;i++){
        jc[i]=new JTextField("",3);
    } 
    cp.add(p,BorderLayout.NORTH);
    
    GridBagConstraints c = new GridBagConstraints();
    c.insets=new Insets (5,5,5,5);
    int n=0;
    for(int i=0;i<10;i++){
        for(int l=0;l<10;l++){
            c.gridx=l;c.gridy=i;
            p.add(jc[n],c);
            n++;
        }
    }
    JPanel p2 = new JPanel();
    p2.setLayout(new GridBagLayout());
    JButton reset_b =new JButton("reset matrix");
    GridBagConstraints c2 = new GridBagConstraints();
    c2.insets=new Insets (40,5,5,5);
    p2.add(reset_b,c2);
    cp.add(p2,BorderLayout.SOUTH);
    
    f.add(p);  
    f.pack();
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLocationRelativeTo(null);
    
    }
}
class createtable{
    int row,column,table_size,n,r,c;
    createtable(){
    Scanner input = new Scanner(System.in);
    System.out.println("Please Input martrix size");
    System.out.print("Row Size = ");
        row=input.nextInt();
    System.out.print("Columns Size = ");
        column=input.nextInt();

    if(row<=0&&column<=0){
            System.out.print("Please Input > 0");
        }
        
    table_size = row*column;
    n=table_size;
    r=row;
    c=column;

    if(table_size==n){
        System.out.print("Martrix "+r+" * "+c+" Created");
    }
    
}
}


