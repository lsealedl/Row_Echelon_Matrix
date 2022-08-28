import java.util.Scanner;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.lang.Math;
public class guimatrix {
    
    public static void main(String[] args) {
        new gui();
    }
}
class  gui
{   
    gui(){
    JFrame f =new JFrame();
    Container cp = f.getContentPane();
    cp.setLayout(new BorderLayout());
     
    JPanel p = new JPanel();
    p.setLayout(new GridBagLayout());
    JTextField tf =new JTextField("",3);
    JTextField tf2 =new JTextField("",3);
    JTextField tf3 =new JTextField("",3);
    JTextField tf4 =new JTextField("",3);
    JTextField tf5 =new JTextField("",3);
    JTextField tf6 =new JTextField("",3);
    JTextField tf7 =new JTextField("",3);
    JTextField tf8 =new JTextField("",3);
    JTextField tf9 =new JTextField("",3);
    JTextField tf10 =new JTextField("",3);
    JTextField tf11=new JTextField("",3);
    JTextField tf12=new JTextField("",3);
    JTextField tf13=new JTextField("",3);
    JTextField tf14=new JTextField("",3);
    JTextField tf15=new JTextField("",3);
    JTextField tf16=new JTextField("",3);
    JTextField tf17=new JTextField("",3);
    JTextField tf18=new JTextField("",3);
    JTextField tf19=new JTextField("",3);
    JTextField tf20=new JTextField("",3);
    JTextField tf21=new JTextField("",3);
    JTextField tf22=new JTextField("",3);
    JTextField tf23=new JTextField("",3);
    JTextField tf24=new JTextField("",3);
    JTextField tf25=new JTextField("",3);
    
    cp.add(p);
    
    GridBagConstraints c = new GridBagConstraints();
    c.insets=new Insets (15,15,15,15);
    c.gridx=0;c.gridy=0;//[1][1]
    p.add(tf,c);
    c.gridx=1;c.gridy=0;//[1][2]
    p.add(tf2,c);
    c.gridx=2;c.gridy=0;//[1][3]
    p.add(tf3,c);
    c.gridx=3;c.gridy=0;//[1][4]
    p.add(tf4,c);
    c.gridx=4;c.gridy=0;//[1][5]
    p.add(tf5,c);
    c.gridx=0;c.gridy=1;//[2][1]
    p.add(tf6,c);
    c.gridx=1;c.gridy=1;//[2][2]
    p.add(tf7,c);
    c.gridx=2;c.gridy=1;//[2][3]
    p.add(tf8,c);
    c.gridx=3;c.gridy=1;//[2][4]
    p.add(tf9,c);
    c.gridx=4;c.gridy=1;//[2][5]
    p.add(tf10,c);
    c.gridx=0;c.gridy=2;//[3][1]
    p.add(tf11,c);
    c.gridx=1;c.gridy=2;//[3][2]
    p.add(tf12,c);
    c.gridx=2;c.gridy=2;//[3][3]
    p.add(tf13,c);
    c.gridx=3;c.gridy=2;//[3][4]
    p.add(tf14,c);
    c.gridx=4;c.gridy=2;//[3][5]
    p.add(tf15,c);
    c.gridx=0;c.gridy=3;//[4][1]
    p.add(tf16,c);
    c.gridx=1;c.gridy=3;//[4][2]
    p.add(tf17,c);
    c.gridx=2;c.gridy=3;//[4][3]
    p.add(tf18,c);
    c.gridx=3;c.gridy=3;//[4][4]
    p.add(tf19,c);
    c.gridx=4;c.gridy=3;//[4][5]
    p.add(tf20,c);
    c.gridx=4;c.gridy=2;//[5][1]
    p.add(tf21,c);
    c.gridx=0;c.gridy=3;//[5][2]
    p.add(tf22,c);
    c.gridx=1;c.gridy=3;//[5][3]
    p.add(tf23,c);
    c.gridx=2;c.gridy=3;//[5][4]
    p.add(tf24,c);
    c.gridx=3;c.gridy=3;//[5][5]
    p.add(tf25,c);
    
    f.add(p);
    f.setSize(500,500);
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


