import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class main_final {
    public static void main(String[] arngs) {
        new gui(1, 1);
    }
}

class gui extends javax.swing.JFrame implements ActionListener, MouseListener { // เพิ่มให้ class extends javax.swing.JFrame
    private int max = 10;

    private JButton RowSizeUpJButton = new JButton();
    private JButton RowSizeDownJButton = new JButton();
    private JButton ColumnSizeUpJButton = new JButton();
    private JButton ColumnSizeDownJButton = new JButton();
    private JTextField matrix_textfield[][] = new JTextField[max][max];
    private JButton rem_Button = new JButton();
    private JButton rrem_Button = new JButton();
    private JButton reset_Button = new JButton();
    private JButton fill_zero_Button = new JButton();
    private int row, column;

    JFrame frame = new JFrame("KASETSART MATRIX CALCULATER");
    Container container = frame.getContentPane();

    private JPanel main_panel = new JPanel();
    private JPanel matrix_panel = new JPanel();
    private JPanel button_panel = new JPanel();
    private JPanel top_panel = new JPanel();

    private JPanel matrix_panel_center = new JPanel();
    private JTextField row_sizeJTextField = new JTextField("", 3);
    private JTextField column_sizeJTextField = new JTextField("", 3);
    private JButton enter_matrix_size_JButton = new JButton("Enter Matrix Size");

    private JButton calculate_rem_Button = new JButton();
    private JButton calculate_rrem_Button = new JButton();

    GridBagConstraints c = new GridBagConstraints();

    private Color JlabelColor = new Color(0, 102, 100);
    private Color JlabelColor2 = new Color(179, 188, 24);

    private Color backgrondColor = new Color(255, 255, 255);

    private int frame_width;

    
    gui(int row, int column) {
        this.row = row;
        this.column = column;
        //////////////////////////////////////////// ทำให้ปุ่มใช้ feature ที่มีใน
        //////////////////////////////////////////// javax.swing มาใช้
        RowSizeUpJButton = new javax.swing.JButton();
        RowSizeDownJButton = new javax.swing.JButton();
        ColumnSizeUpJButton = new javax.swing.JButton();
        ColumnSizeDownJButton = new javax.swing.JButton();
        rem_Button = new javax.swing.JButton("REM check");
        rrem_Button = new javax.swing.JButton("RREM check");
        reset_Button = new javax.swing.JButton("reset matrix");
        fill_zero_Button = new javax.swing.JButton("fill empty matix with 0");
        calculate_rem_Button = new javax.swing.JButton("calculate REM");
        calculate_rrem_Button = new javax.swing.JButton("calculate RREM");
        /////////////////////////////////////////////// set รูป/ลักษณะปุ่มให้ปุ่ม ,กำหนดตัวอักษร
        ImageIcon img = new ImageIcon(getClass().getResource("image\\KU_Logo_PNG.png"));
        frame.setIconImage(img.getImage());

        RowSizeUpJButton.setOpaque(false);
        RowSizeUpJButton.setContentAreaFilled(false);
        RowSizeUpJButton.setBorderPainted(false);
        RowSizeUpJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("image\\triangle_up.png")));
        RowSizeUpJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RowSizeDownJButton.setOpaque(false);
        RowSizeDownJButton.setContentAreaFilled(false);
        RowSizeDownJButton.setBorderPainted(false);
        RowSizeDownJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("image\\triangle_down.png")));
        RowSizeDownJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ColumnSizeUpJButton.setOpaque(false);
        ColumnSizeUpJButton.setContentAreaFilled(false);
        ColumnSizeUpJButton.setBorderPainted(false);
        ColumnSizeUpJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("image\\triangle_right.png")));
        ColumnSizeUpJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ColumnSizeDownJButton.setOpaque(false);
        ColumnSizeDownJButton.setContentAreaFilled(false);
        ColumnSizeDownJButton.setBorderPainted(false);
        ColumnSizeDownJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("image\\triangle_left.png")));
        ColumnSizeDownJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        rem_Button.setBorderPainted(false);
        rem_Button.setFont(new java.awt.Font("Tahoma", 1, 13));
        rrem_Button.setBorderPainted(false);
        rrem_Button.setFont(new java.awt.Font("Tahoma", 1, 13));
        reset_Button.setBorderPainted(false);
        reset_Button.setFont(new java.awt.Font("Tahoma", 1, 13));
        fill_zero_Button.setBorderPainted(false);
        fill_zero_Button.setFont(new java.awt.Font("Tahoma", 1, 13));
        calculate_rem_Button.setBorderPainted(false);
        calculate_rem_Button.setFont(new java.awt.Font("Tahoma", 1, 13));
        calculate_rrem_Button.setBorderPainted(false);
        calculate_rrem_Button.setFont(new java.awt.Font("Tahoma", 1, 13));
        enter_matrix_size_JButton.setBorderPainted(false);

        row_sizeJTextField.setHorizontalAlignment(SwingConstants.CENTER);
        column_sizeJTextField.setHorizontalAlignment(SwingConstants.CENTER);

        /////////////////////////////////////////////////////
        container.setLayout(new BorderLayout());

        ////////////////////////////////////////////////////// ทำ panel ย่อย
        main_panel.setLayout(new GridBagLayout());

        matrix_panel.setLayout(new GridBagLayout());

        button_panel.setLayout(new GridBagLayout());

        top_panel.setLayout(new GridBagLayout());

        matrix_panel_center.setLayout(new GridBagLayout());
        //////////////////////////////////////////////////////

        ////////////////////////////////////////////////////// สร้างช่อง matrix
        for (int i = 0; i < max; i++) {
            for (int l = 0; l < max; l++) {
                matrix_textfield[i][l] = new JTextField("", 3);
                matrix_textfield[i][l].setHorizontalAlignment(SwingConstants.CENTER);
            }
        }
        //////////////////////////////////////////////////////

        ////////////////////////////////////////////////////// จัดองค์ประกอบต่างๆ
        c.insets = new Insets(5, 5, 5, 5);

        for (int i = 0; i < row; i++) {
            for (int l = 0; l < column; l++) {
                c.gridx = l;
                c.gridy = i;
                matrix_panel.add(matrix_textfield[i][l], c);
            }
        }

        c.gridx = 1;
        c.gridy = 1;
        button_panel.add(rem_Button, c);
        c.gridx = 2;
        c.gridy = 1;
        button_panel.add(rrem_Button, c);

        c.gridx = 1;
        c.gridy = 2;
        button_panel.add(calculate_rem_Button, c);
        c.gridx = 2;
        c.gridy = 2;
        button_panel.add(calculate_rrem_Button, c);

        c.gridx = 1;
        c.gridy = 1;
        matrix_panel_center.add(matrix_panel, c);

        c.gridx = 1;
        c.gridy = 2;
        main_panel.add(reset_Button, c);
        c.gridx = 1;
        c.gridy = 3;
        main_panel.add(fill_zero_Button, c);

        c.gridx = 1;
        c.gridy = 4;
        main_panel.add(button_panel, c);

        c.gridx = 2;
        c.gridy = 1;
        top_panel.add(RowSizeUpJButton, c);
        c.gridx = 2;
        c.gridy = 2;
        top_panel.add(RowSizeDownJButton, c);
        c.gridx = 6;
        c.gridy = 1;
        top_panel.add(ColumnSizeUpJButton, c);
        c.gridx = 5;
        c.gridy = 1;
        top_panel.add(ColumnSizeDownJButton, c);

        c.gridx = 1;
        c.gridy = 1;
        top_panel.add(row_sizeJTextField, c);
        row_sizeJTextField.setText(row + "");

        c.gridx = 4;
        c.gridy = 1;
        top_panel.add(column_sizeJTextField, c);
        column_sizeJTextField.setText(column + "");

        c.gridx = 3;
        c.gridy = 1;
        top_panel.add(enter_matrix_size_JButton, c);

        ////////////////////////////////////////////////////// ทำให้ jpanel ใส
        button_panel.setOpaque(false);
        matrix_panel.setOpaque(false);
        top_panel.setOpaque(false);
        matrix_panel_center.setOpaque(false);
        main_panel.setOpaque(false);
        ///////////////////////////////////////////////////////

        container.add(top_panel, BorderLayout.NORTH);
        container.add(matrix_panel_center, BorderLayout.CENTER);
        container.add(main_panel, BorderLayout.SOUTH);

        fill_zero_Button.addActionListener(this);
        reset_Button.addActionListener(this);
        rem_Button.addActionListener(this);
        rrem_Button.addActionListener(this);
        RowSizeUpJButton.addActionListener(this);
        RowSizeDownJButton.addActionListener(this);
        ColumnSizeUpJButton.addActionListener(this);
        ColumnSizeDownJButton.addActionListener(this);
        calculate_rem_Button.addActionListener(this);
        calculate_rrem_Button.addActionListener(this);
        enter_matrix_size_JButton.addActionListener(this);

        RowSizeUpJButton.addMouseListener(this);
        RowSizeDownJButton.addMouseListener(this);
        ColumnSizeUpJButton.addMouseListener(this);
        ColumnSizeDownJButton.addMouseListener(this);
        
        fill_zero_Button.addMouseListener(this);
        reset_Button.addMouseListener(this);
        rem_Button.addMouseListener(this);
        rrem_Button.addMouseListener(this);
        enter_matrix_size_JButton.addMouseListener(this);
        calculate_rem_Button.addMouseListener(this);
        calculate_rrem_Button.addMouseListener(this);

        Color FontColor = new Color(255, 255, 255);
        enter_matrix_size_JButton.setForeground(FontColor);
        fill_zero_Button.setForeground(FontColor);
        reset_Button.setForeground(FontColor);
        rem_Button.setForeground(FontColor);
        rrem_Button.setForeground(FontColor);
        // RowSizeUpJButton.setForeground(FontColor);
        // RowSizeDownJButton.setForeground(FontColor);
        // ColumnSizeUpJButton.setForeground(FontColor);
        // ColumnSizeDownJButton.setForeground(FontColor);
        calculate_rem_Button.setForeground(FontColor);
        calculate_rrem_Button.setForeground(FontColor);

        enter_matrix_size_JButton.setBackground(JlabelColor);
        fill_zero_Button.setBackground(JlabelColor);
        reset_Button.setBackground(JlabelColor);
        rem_Button.setBackground(JlabelColor);
        rrem_Button.setBackground(JlabelColor);
        // RowSizeUpJButton.setBackground(JlabelColor);
        // RowSizeDownJButton.setBackground(JlabelColor);
        // ColumnSizeUpJButton.setBackground(JlabelColor);
        // ColumnSizeDownJButton.setBackground(JlabelColor);
        calculate_rem_Button.setBackground(JlabelColor);
        calculate_rrem_Button.setBackground(JlabelColor);

        container.setBackground(backgrondColor);// เปลี่ยนพื้นหลัง

        frame.pack();
        frame.setResizable(false);
        // frame.setSize(500,550);
        frame.setVisible(true);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame_width = frame.getWidth();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==RowSizeUpJButton){
            RowSizeUpJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("image\\triangle_up.png")));
            }
        else if(e.getSource()==RowSizeDownJButton){
            RowSizeDownJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("image\\triangle_down.png")));
        }
        else if(e.getSource()==ColumnSizeUpJButton){
            ColumnSizeUpJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("image\\triangle_right.png")));
        }
        else if(e.getSource()==ColumnSizeDownJButton){
            ColumnSizeDownJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("image\\triangle_left.png")));
        }
        else{
            e.getComponent().setBackground(JlabelColor);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==RowSizeUpJButton){
            RowSizeUpJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("image\\triangle_up_2.png")));
            }
        else if(e.getSource()==RowSizeDownJButton){
            RowSizeDownJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("image\\triangle_down_2.png")));
        }
        else if(e.getSource()==ColumnSizeUpJButton){
            ColumnSizeUpJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("image\\triangle_right_2.png")));
        }
        else if(e.getSource()==ColumnSizeDownJButton){
            ColumnSizeDownJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("image\\triangle_left_2.png")));
        }
        else{
            e.getComponent().setBackground(JlabelColor2);
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    private void generate_matrix(int row, int column, JPanel matrix_panel) {// เอาไว้สร้าง matrix
        matrix_panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        for (int i = row; i < max; i++) {
            for (int l = 0; l < max; l++) {
                matrix_textfield[i][l].setText("");
            }
        }
        for (int i = 0; i < max; i++) {
            for (int l = column; l < max; l++) {
                matrix_textfield[i][l].setText("");
            }
        }
        for (int i = 0; i < row; i++) {
            for (int l = 0; l < column; l++) {
                c.gridx = l;
                c.gridy = i;
                matrix_panel.add(matrix_textfield[i][l], c);
            }
        }
    }

    private void reload_matrix() {// เอาไว้ reload matrix เมื่อเกิดการเพิ่มขนาด matrix
        matrix_panel.setLayout(new GridBagLayout());
        matrix_panel.removeAll();
        generate_matrix(row, column, matrix_panel);
        frame.revalidate();
        row_sizeJTextField.setText(row + "");
        column_sizeJTextField.setText(column + "");
        frame.pack();

        Point frame_location = frame.getLocation();
        frame.setLocation((int) frame_location.getX() - (frame.getWidth() - frame_width) / 2,(int) frame_location.getY());

        frame_width = frame.getWidth();
    }

    @Override
    public void actionPerformed(ActionEvent click_event) {
        matrix_operation m_o = new matrix_operation(row, column);
        try {
            if (click_event.getSource() == reset_Button) {
                for (int i = 0; i < row; i++) {
                    for (int l = 0; l < column; l++) {
                        matrix_textfield[i][l].setText("");
                    }
                }
            } else if (click_event.getSource() == rem_Button) {
                float[][] matrix = new float[row][column];
                for (int i = 0; i < row; i++) {
                    for (int l = 0; l < column; l++) {
                        matrix[i][l] = Float.parseFloat(matrix_textfield[i][l].getText());
                    }
                }
                JOptionPane.showMessageDialog(null, "Row Echelon Matrix : " + m_o.check_row_echelon_matrix(matrix));
            } else if (click_event.getSource() == rrem_Button) {
                float[][] matrix = new float[row][column];
                for (int i = 0; i < row; i++) {
                    for (int l = 0; l < column; l++) {
                        matrix[i][l] = Float.parseFloat(matrix_textfield[i][l].getText());
                    }
                }
                JOptionPane.showMessageDialog(null,
                        "Reduce Row Echelon Matrix : " + m_o.check_reduce_row_echelon_matrix(matrix));
            } else if (click_event.getSource() == fill_zero_Button) {
                for (int i = 0; i < row; i++) {
                    for (int l = 0; l < column; l++) {
                        if ((matrix_textfield[i][l].getText().isBlank())) {
                            matrix_textfield[i][l].setText("0");
                        }
                    }
                }
            } else if (click_event.getSource() == RowSizeUpJButton) {
                if (row < max) {
                    row++;
                    reload_matrix();
                }

            } else if (click_event.getSource() == RowSizeDownJButton) {
                if (row > 1) {
                    row--;
                    reload_matrix();
                }

            } else if (click_event.getSource() == ColumnSizeUpJButton) {
                if (column < max) {
                    column++;
                    reload_matrix();
                }

            } else if (click_event.getSource() == ColumnSizeDownJButton) {
                if (column > 1) {
                    column--;
                    reload_matrix();
                }

            } else if (click_event.getSource() == enter_matrix_size_JButton) {
                try {
                    if (Integer.parseInt(column_sizeJTextField.getText()) >= 1
                            && Integer.parseInt(column_sizeJTextField.getText()) <= max
                            && Integer.parseInt(row_sizeJTextField.getText()) >= 1
                            && Integer.parseInt(row_sizeJTextField.getText()) <= max) {
                        column = Integer.parseInt(column_sizeJTextField.getText());
                        row = Integer.parseInt(row_sizeJTextField.getText());
                        reload_matrix();
                    } else {
                        JOptionPane.showMessageDialog(null, "Pls Matrix Size in 1 to " + max);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Pls Input Only Integer In Matrix Size"/* +e */);
                }

            } else if (click_event.getSource() == calculate_rem_Button) {
                float[][] matrix = new float[row][column];
                for (int i = 0; i < row; i++) {
                    for (int l = 0; l < column; l++) {
                        matrix[i][l] = Float.parseFloat(matrix_textfield[i][l].getText());
                    }
                }
                if (m_o.check_row_echelon_matrix(matrix) == true) {
                    JOptionPane.showMessageDialog(null, "It Already Is Row Echelon Matrix");
                } else {
                    new calculate_gui(row, column, matrix, "rem");
                }

            } else if (click_event.getSource() == calculate_rrem_Button) {
                float[][] matrix = new float[row][column];
                for (int i = 0; i < row; i++) {
                    for (int l = 0; l < column; l++) {
                        matrix[i][l] = Float.parseFloat(matrix_textfield[i][l].getText());
                    }
                }
                if (m_o.check_reduce_row_echelon_matrix(matrix) == true) {
                    JOptionPane.showMessageDialog(null, "It Already Is Reduce Row Echelon Matrix");
                } else {
                    new calculate_gui(row, column, matrix, "rrem");
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pls Input Only Float In Matrix");
        }

    }
}

class calculate_gui extends javax.swing.JFrame {

    private JFrame frame = new JFrame();
    private Container container = frame.getContentPane();

    calculate_gui(int rows, int columns, float[][] matrix, String choice) {
        ImageIcon img = new ImageIcon(getClass().getResource("image\\KU_Logo_PNG.png"));
        frame.setIconImage(img.getImage());
        matrix_operation m_o = new matrix_operation(rows, columns);
        container.setLayout(new BorderLayout());
        JPanel calculate_panel = new JPanel();
        calculate_panel.setLayout(new BorderLayout());
        JPanel subPanel = new JPanel();

        subPanel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        JLabel titleLabel = new JLabel("", SwingConstants.CENTER);

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        titleLabel.setForeground(new Color(255, 255, 255));

        if (choice.equals("rem")) {
            titleLabel.setText("Calculate Row Echelon Matrix");
            c.gridx = 0;
            c.gridy = 0;
            subPanel.add(titleLabel, c);
            c.gridx = 0;
            c.gridy = 1;
            subPanel.add(m_o.calulate_rem_to_JPanel(matrix), c);
            calculate_panel.add(subPanel, BorderLayout.NORTH);
        } else if (choice.equals("rrem")) {
            titleLabel.setText("Calculate Reduced Row Echelon Matrix");
            c.gridx = 0;
            c.gridy = 0;
            subPanel.add(titleLabel, c);
            c.gridx = 0;
            c.gridy = 1;
            subPanel.add(m_o.calulate_rrem_to_JPanel(matrix), c);
            calculate_panel.add(subPanel, BorderLayout.NORTH);
        }
        JScrollPane ScrollPane = new JScrollPane(calculate_panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPane.setBorder(BorderFactory.createEmptyBorder());
        container.add(ScrollPane, BorderLayout.CENTER);

        subPanel.setOpaque(false);
        calculate_panel.setOpaque(false);
        ScrollPane.setOpaque(false);
        ScrollPane.getViewport().setOpaque(false);
        titleLabel.setOpaque(true);

        titleLabel.setBackground(new Color(0, 0, 0));
        container.setBackground(new Color(179, 188, 24));
        titleLabel.setPreferredSize(new Dimension(500, 30));

        // frame.pack();
        frame.setSize(500, 550);
        frame.setResizable(false);
        frame.setVisible(true);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }
}

interface matrix_operation_template {
    boolean check_row_echelon_matrix(float[][] matrix);

    boolean check_reduce_row_echelon_matrix(float[][] matrix);

    JPanel calulate_rrem_to_JPanel(float[][] matrix);

    JPanel calulate_rem_to_JPanel(float[][] matrix);
}

class matrix_operation implements matrix_operation_template {
    /*
     * rows คือ จำนวนแถว
     * columns คือ จำนวนหลัก
     * ปัญหาคือ เวลาเก็บใน array มันเริ่มที่ 0 แต่ใน matrix มันเริ่มที่ 1 เวลาใช้
     * method เลยนับว่าให้เริ่มที่ 1 ตาม matrix
     */
    private int rows, columns;

    matrix_operation(int rows, int columns) {// กำหนดจำนวนแถวและหลัก
        this.rows = rows;
        this.columns = columns;
    }

    private boolean row_is_zero(float[][] matrix, int row) {// return ว่าแถวเป็น 0 ทั้งแถวหรือเปล่า
        boolean row_is_zero = true;
        for (int i = 0; i < columns; i++) {
            if (matrix[row - 1][i] == 0) {
            } else {
                row_is_zero = false;
            }
        }
        if (row_is_zero == true) {
            return true;
        } else {
            return false;
        }
    }

    private int leading_coefficient(float[][] matrix, int row) {// return ตำแหน่งของตัวนำ 1 ในแถว ถ้าไม่มีจะ return -1
        for (int i = 0; i < columns; i++) {
            if (matrix[row - 1][i] == 1) {
                return i + 1;
            } else if (matrix[row - 1][i] == 0) {
            } else {
                return -1;
            }
        }
        return -1;
    }

    public boolean check_row_echelon_matrix(float[][] matrix) {// เช็คว่าเป็น row echelon matrix เปล่า
        if (rows == 1) {
            if ((row_is_zero(matrix, 1)) || leading_coefficient(matrix, 1) != -1) {
                return true;
            } // ถ้า matrix มี 1 แถวแล้วแถว 1 เป็น 0 ทั้งแถวหรือมีตัวนำ 1
            else {
                return false;
            }
        }
        for (int i = 2; i <= rows; i++) {
            if ((leading_coefficient(matrix, i - 1) != -1 || row_is_zero(matrix, i - 1))// ถ้า (matrixตัวก่อนหน้ามีตัวนำ 1หรือเป็น 0 ทั้งแถว)
                    && (leading_coefficient(matrix, i) != -1 || row_is_zero(matrix, i))) {//และ (matrix ตัวปัจจุบันมีตัวนำ1 หรือเป็น 0 ทั้งแถว)
                if (leading_coefficient(matrix, i - 1) != -1 && leading_coefficient(matrix, i) != -1) {//มีตัวนำ 1 ทั้ง 2 แถว
                    if (leading_coefficient(matrix, i - 1) < leading_coefficient(matrix, i)) {//ตัวนำ 1 แถวก่อนต้องอยู่เยื่องไปข้างหน้าตัวหลัง
                    } else {
                        return false;
                    }
                } else if (leading_coefficient(matrix, i - 1) != -1 && row_is_zero(matrix, i)) {
                } // matrix ตัวก่อนหน้าต้องมี ตัวนำ 1 และ ตัวปัจจุบันต้องเป็น 0 ทั้งแถว
                else if (row_is_zero(matrix, i - 1) && row_is_zero(matrix, i)) {
                } /// matrix ตัวก่อนหน้าต้องป็น 0 ทั้งแถวและ ตัวปัจจุบันต้องเป็น 0 ทั้งแถว
                else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean check_reduce_row_echelon_matrix(float[][] matrix) {// เช็คว่าเป็น reduce row echelon matrix เปล่า
        if (check_row_echelon_matrix(matrix)) {// เช็คว่าเป็น rem เปล่าถ้าไม่เป็นก็ไม่มีทางเป็น rrem ได้
            for (int i = 1; i <= rows; i++) {
                if (leading_coefficient(matrix, i) != -1) {// เลือกม่าเฉพาะแถวที่มีตัวนำ 1
                    for (int l = 1; l <= rows; l++) {
                        if (matrix[l - 1][leading_coefficient(matrix, i) - 1] == 0) {
                        } // ในหลักของตัวนำ 1 ตัวที่ไม่ใช่ตัวนำ 1 ต้องเป็น 0 เท่านั้น ทั้งข้างบนข้างล่าง
                        else if (l == i) {
                        } // กัน for loop แล้วเจอตัวนำ 1 เพราะตัวนำ 1 ไม่ใช่ 0
                        else {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    private void multiplying_row_by_constant(float[][] matrix, int row, float constant) {
        if (constant == 0) {
            return;
        } else {
            for (int i = 0; i < columns; i++) {
                if (matrix[row - 1][i] == 0) {
                } else {
                    matrix[row - 1][i] = matrix[row - 1][i] * constant;
                }
            }
        }
    }

    private void adding_row_by_row(float[][] matrix, int row_1, int row_2, float constant) {// row_1 คือตัวตั้ง row_2 คือตัวบวก
        if (constant == 0) {
            return;
        } else {
            for (int i = 0; i < columns; i++) {
                matrix[row_1 - 1][i] = matrix[row_1 - 1][i] + (matrix[row_2 - 1][i] * constant);
            }
        }
    }

    private void switching_two_rows(float[][] matrix, int row_1, int row_2) {// สลับแถว
        for (int i = 0; i < columns; i++) {
            float tmp = matrix[row_1 - 1][i];
            matrix[row_1 - 1][i] = matrix[row_2 - 1][i];
            matrix[row_2 - 1][i] = tmp;
        }
    }

    private JPanel matrix_to_Jpanel(float[][] matrix) {// เปลี่ยน matrix เป็น JPanel
        JPanel main_panel = new JPanel();
        JPanel matrix_panel = new JPanel();

        main_panel.setOpaque(true);
        matrix_panel.setOpaque(false);

        JLabel[][] matrix_Jlabel = new JLabel[rows][columns];
        matrix_panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < rows; i++) {
            for (int l = 0; l < columns; l++) {
                matrix_Jlabel[i][l] = new JLabel();
                if (Math.round(matrix[i][l]) == matrix[i][l]) {
                    matrix_Jlabel[i][l].setText(String.format("%.0f", (matrix[i][l])) + "   ");
                } else {
                    matrix_Jlabel[i][l].setText(matrix[i][l] + "   ");
                }
                matrix_Jlabel[i][l].setFont(new java.awt.Font("Tahoma", 1, 13));
                matrix_Jlabel[i][l].setForeground(new Color(255, 255, 255));
                c.gridx = l;
                c.gridy = i;
                matrix_panel.add(matrix_Jlabel[i][l], c);
            }
        }
        main_panel.setBackground(new Color(179, 188, 24));
        main_panel.add(matrix_panel);
        return main_panel;
    }

    private JLabel set_text_to_JLabel(String tmp) {
        JLabel text_Label = new JLabel("", SwingConstants.CENTER);
        text_Label.setOpaque(false);
        text_Label.setText(tmp);
        text_Label.setForeground(new Color(255, 255, 255));
        text_Label.setFont(new java.awt.Font("Tahoma", 1, 13));
        if (tmp == " ") {
            text_Label.setPreferredSize(new Dimension(500, 5));
            text_Label.setOpaque(true);
            text_Label.setBackground(new Color(255, 255, 255));
        } else {
            text_Label.setPreferredSize(new Dimension(500, 20));
            text_Label.setOpaque(true);
            text_Label.setBackground(new Color(0, 102, 100));
        }
        return text_Label;
    }

    public JPanel calulate_rrem_to_JPanel(float[][] matrix) {// คำนวณ rrem และแปลงเป็น JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        panel.setOpaque(false);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        int leading_coefficient_position_in_row = 0;// คือ ค่าของแถวของตัวนำ 1 ที่คาดหวัง ใช้หาว่าตัวนำต้องอยู่ในแถวไหน
        String tmp = "";
        int JPanel_sqsequence = 1;
        for (int i = 0; i < columns; i++) {
            for (int l = 0; l < rows; l++) {
                if (leading_coefficient_position_in_row != -1) {// ใช้กันไม่ให้เกิดเหตุการณ์ leading_coefficient_position_in_row มีค่ามากกว่าจำนวนแถวสูงสุด
                    if (matrix[leading_coefficient_position_in_row][i] == 1) {
                        if (leading_coefficient_position_in_row != l && matrix[l][i] != 0) {// ถ้าในหลักนั้นมีตัวนำ 1 ให้เปลี่ยนตัวที่เหลือในหลักนั้นเป็น 0
                            tmp = "R" + (l + 1) + "+(" + (-matrix[l][i]) + ")R"+ (leading_coefficient_position_in_row + 1) + "\n\n";
                            c.gridy = JPanel_sqsequence;
                            adding_row_by_row(matrix, l + 1, leading_coefficient_position_in_row + 1, -matrix[l][i]);
                            panel.add(matrix_to_Jpanel(matrix), c);

                            JPanel_sqsequence++;
                            c.gridy = JPanel_sqsequence;
                            panel.add(set_text_to_JLabel(tmp), c);
                            JPanel_sqsequence++;
                            ////////////////////////////// สร้างเว้นวรรคด้วย JLabel
                            c.gridy = JPanel_sqsequence;
                            panel.add(set_text_to_JLabel(" "), c);
                            JPanel_sqsequence++;
                            /////////////////////////////////
                        }
                    } else if (matrix[l][i] != 0 && leading_coefficient_position_in_row <= l) {// ใช้หาตัวนำ 1 โดยต้องอยู่ในแถวที่น้อยกว่าหรือเท่ากับตำนำ1ที่คาดหวัง
                        if (l != leading_coefficient_position_in_row) {// อย่างแรกสลับแถวปัจจุบันไปแถวที่ควรมีตัวนำ 1
                            tmp = "R" + (l + 1) + "↔R" + (leading_coefficient_position_in_row + 1) + "\n\n";
                            c.gridy = JPanel_sqsequence;
                            switching_two_rows(matrix, l + 1, leading_coefficient_position_in_row + 1);
                            panel.add(matrix_to_Jpanel(matrix), c);
                            JPanel_sqsequence++;

                            c.gridy = JPanel_sqsequence;
                            panel.add(set_text_to_JLabel(tmp), c);
                            JPanel_sqsequence++;
                            ////////////////////////////// สร้างเว้นวรรคด้วย JLabel
                            c.gridy = JPanel_sqsequence;
                            panel.add(set_text_to_JLabel(" "), c);
                            JPanel_sqsequence++;
                            /////////////////////////////////
                        }
                        if (matrix[leading_coefficient_position_in_row][i] != 1) {// เปลี่ยนช่องที่อยู่ให้กลายเป็น 1 โดยการหารตัวมันเองทั้งแถว
                            tmp = "R" + (leading_coefficient_position_in_row + 1) + "/"+ matrix[leading_coefficient_position_in_row][i] + "\n\n";
                            c.gridy = JPanel_sqsequence;
                            multiplying_row_by_constant(matrix, leading_coefficient_position_in_row + 1,1 / matrix[leading_coefficient_position_in_row][i]);
                            panel.add(matrix_to_Jpanel(matrix), c);
                            JPanel_sqsequence++;

                            c.gridy = JPanel_sqsequence;
                            panel.add(set_text_to_JLabel(tmp), c);
                            JPanel_sqsequence++;
                            ////////////////////////////// สร้างเว้นวรรคด้วย JLabel
                            c.gridy = JPanel_sqsequence;
                            panel.add(set_text_to_JLabel(" "), c);
                            JPanel_sqsequence++;
                            /////////////////////////////////
                        }
                        l = -1;// ต้องเป็น -1 เพราะว่า อยากให้ l=0 เพื่อที่มันจะได้วน loop แต่พอจบ if มันจะ +1 เลยตัองเป็น -1
                    }
                }
            }
            if (leading_coefficient_position_in_row == -1) {
            } // ใช้กันไม่ให้เกิดเหตุการณ์ leading_coefficient_position_in_row มีค่ามากกว่าจำนวนแถวสูงสุด
            else if (matrix[leading_coefficient_position_in_row][i] == 1) {
                leading_coefficient_position_in_row++;
                if (leading_coefficient_position_in_row == rows) {// ถ้า leading_coefficient_position_in_rowมีค่าเท่ากับจำนวนแถวสูงสุดแล้วปรับให้เป็น -1 ซะเพื่อจะไม่ต้องทำต่อ
                    leading_coefficient_position_in_row = -1;
                }
            }
        }

        for (int i = 0; i < columns; i++) {
            for (int l = 0; l < rows; l++) {
                if (matrix[l][i] == -0) {
                    matrix[l][i] = 0;
                }
            }
        }
        return panel;
    }

    public JPanel calulate_rem_to_JPanel(float[][] matrix) {// คำนวณ rem และแปลงเป็น JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        panel.setOpaque(false);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        int leading_coefficient_position_in_row = 0;// คือ ค่าของแถวของตัวนำ 1 ที่คาดหวัง ใช้หาว่าตัวนำต้องอยู่ในแถวไหน
        String tmp = "";
        int JPanel_sqsequence = 1;
        for (int i = 0; i < columns; i++) {
            for (int l = 0; l < rows; l++) {
                if (leading_coefficient_position_in_row != -1) {// ใช้กันไม่ให้เกิดเหตุการณ์ leading_coefficient_position_in_row มีค่ามากกว่าจำนวนแถวสูงสุด
                    if (matrix[leading_coefficient_position_in_row][i] == 1) {
                        if (leading_coefficient_position_in_row != l && matrix[l][i] != 0 && leading_coefficient_position_in_row < l) {// ถ้าในหลักนั้นมีตัวนำ 1 ให้เปลี่ยนตัวที่เหลือในหลักนั้นเป็น 0
                            tmp = "R" + (l + 1) + "+(" + (-matrix[l][i]) + ")R"+ (leading_coefficient_position_in_row + 1) + "\n\n";

                            c.gridy = JPanel_sqsequence;
                            adding_row_by_row(matrix, l + 1, leading_coefficient_position_in_row + 1, -matrix[l][i]);
                            panel.add(matrix_to_Jpanel(matrix), c);
                            JPanel_sqsequence++;

                            c.gridy = JPanel_sqsequence;
                            panel.add(set_text_to_JLabel(tmp), c);
                            JPanel_sqsequence++;
                            ////////////////////////////// สร้างเว้นวรรคด้วย JLabel
                            c.gridy = JPanel_sqsequence;
                            panel.add(set_text_to_JLabel(" "), c);
                            JPanel_sqsequence++;
                            /////////////////////////////////
                        }
                    } else if (matrix[l][i] != 0 && leading_coefficient_position_in_row <= l) {// ใช้หาตัวนำ 1 โดยต้องอยู่ในแถวที่น้อยกว่าหรือเท่ากับตำนำ1ที่คาดหวัง
                        if (l != leading_coefficient_position_in_row) {// อย่างแรกสลับแถวปัจจุบันไปแถวที่ควรมีตัวนำ 1
                            tmp = "R" + (l + 1) + "↔R" + (leading_coefficient_position_in_row + 1) + "\n\n";
                            c.gridy = JPanel_sqsequence;
                            switching_two_rows(matrix, l + 1, leading_coefficient_position_in_row + 1);
                            panel.add(matrix_to_Jpanel(matrix), c);
                            JPanel_sqsequence++;

                            c.gridy = JPanel_sqsequence;
                            panel.add(set_text_to_JLabel(tmp), c);
                            JPanel_sqsequence++;
                            ////////////////////////////// สร้างเว้นวรรคด้วย JLabel
                            c.gridy = JPanel_sqsequence;
                            panel.add(set_text_to_JLabel(" "), c);
                            JPanel_sqsequence++;
                            /////////////////////////////////
                        }
                        if (matrix[leading_coefficient_position_in_row][i] != 1) {// เปลี่ยนช่องที่อยู่ให้กลายเป็น 1 โดยการหารตัวมันเองทั้งแถว
                            tmp = "R" + (leading_coefficient_position_in_row + 1) + "/"+ matrix[leading_coefficient_position_in_row][i] + "\n\n";
                            c.gridy = JPanel_sqsequence;
                            multiplying_row_by_constant(matrix, leading_coefficient_position_in_row + 1,1 / matrix[leading_coefficient_position_in_row][i]);
                            panel.add(matrix_to_Jpanel(matrix), c);
                            JPanel_sqsequence++;

                            c.gridy = JPanel_sqsequence;
                            panel.add(set_text_to_JLabel(tmp), c);
                            JPanel_sqsequence++;
                            ////////////////////////////// สร้างเว้นวรรคด้วย JLabel
                            c.gridy = JPanel_sqsequence;
                            panel.add(set_text_to_JLabel(" "), c);
                            JPanel_sqsequence++;
                            /////////////////////////////////
                        }
                        l = -1;// ต้องเป็น -1 เพราะว่า อยากให้ l=0 เพื่อที่มันจะได้วน loop แต่พอจบ if มันจะ +1 เลยตัองเป็น -1
                    }
                }
            }
            if (leading_coefficient_position_in_row == -1) {
            } // ใช้กันไม่ให้เกิดเหตุการณ์ leading_coefficient_position_in_row มีค่ามากกว่าจำนวนแถวสูงสุด
            else if (matrix[leading_coefficient_position_in_row][i] == 1) {
                leading_coefficient_position_in_row++;
                if (leading_coefficient_position_in_row == rows) {// ถ้า leading_coefficient_position_in_row มีค่าเท่ากับจำนวนแถวสูงสุดแล้วปรับให้เป็น -1 ซะเพื่อจะไม่ต้องทำต่อ
                    leading_coefficient_position_in_row = -1;
                }
            }
        }

        for (int i = 0; i < columns; i++) {
            for (int l = 0; l < rows; l++) {
                if (matrix[l][i] == -0) {
                    matrix[l][i] = 0;
                }
            }
        }
        return panel;
    }
}
