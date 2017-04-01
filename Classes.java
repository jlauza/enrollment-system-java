package students;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
public class Classes extends javax.swing.JFrame {
Connection con;
ResultSet rs;
Statement stmt;
    public Classes() {
        initComponents();
        doConnect();
        comboSection();
        comboInstructor();
        showTable();
    }
    @Override
    public void setDefaultCloseOperation(int operation) {
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //To change body of generated methods, choose Tools | Templates.
    }

    public void doConnect(){
        classdbid.setEnabled(false);
        try{
            //connect
            String host ="jdbc:mysql://localhost:3306/test";
            String dbuser ="root";
            String dbpass ="";
            con = DriverManager.getConnection(host,dbuser,dbpass);
            
            //execute
            /*
            stmt = con.createStatement();
            String sql = "SELECT * FROM student_info";
            ResultSet rs = stmt.executeQuery(sql);
            
            //move cursor
            rs.next();
            int id_col = rs.getInt("student_dbid");
            String dbid = Integer.toString(id_col);
            String sid = rs.getString("StudentID");
            String fname = rs.getString("Firstname");
            String mname = rs.getString("Middlename");
            String lname = rs.getString("Lastname");
            String age = rs.getString("Age");
            String gender = rs.getString("Gender");
            String course = rs.getString("Course");
            String yrlvl = rs.getString("YearLevel");
            String email = rs.getString("Email");
            
            //display data
            textsdbid.setText(dbid);
            textsid.setText(sid);
            textsfname.setText(fname);
            textsmname.setText(mname);
            textslname.setText(lname);
            textsage.setText(age);
            textsgender.setSelectedItem(gender);
            textscourse.setText(course);
            textyrlvl.setSelectedItem(yrlvl);
            textsemal.setText(email);
            */
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }    

    public void comboSection(){
        try {
            stmt = con.createStatement();
            String sqlcourse = "SELECT * FROM section";
            rs = stmt.executeQuery(sqlcourse);
            while(rs.next()) {
                classsection.addItem(rs.getString(2));
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        /*
        finally {
            try{
            stmt.close();
            rs.close();
            con.close();
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } */
    }

    public void comboInstructor(){
        try {
            stmt = con.createStatement();
            String sqlcourse = "SELECT * FROM instructors";
            rs = stmt.executeQuery(sqlcourse);
            while(rs.next()) {
                classinstructor.addItem(rs.getString(5));
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        /*
        finally {
            try{
            stmt.close();
            rs.close();
            con.close();
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }*/
    }
 
   void update_table() throws SQLException {
        //try {
            rs = stmt.executeQuery("SELECT * FROM classes");
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        //}
        /*
        catch (SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
        }*/
    }    

    public ArrayList<Classes_1> class1List() {
        ArrayList<Classes_1> classes1 = new ArrayList<Classes_1>();
        //Connection connection = getConnection();
        String sql = "SELECT * FROM classes";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            Classes_1 c;
            while (rs.next()) {
            c = new Classes_1(rs.getInt("Class_dbid"),rs.getString("ClassName"),rs.getInt("ClassCapacity"),rs.getString("Instructor"),rs.getString("Section"),rs.getString("Day"),rs.getString("Start"),rs.getString("End"),rs.getInt("Units"));
            classes1.add(c);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        return classes1;
    }
    
    public void showTable() {
    ArrayList<Classes_1> list = class1List();
    //DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
    Object[] row = new Object[9];
    
    for (int i=0;i<list.size();i++) {
        row[0] = list.get(i).getClassdbid();
        row[1] = list.get(i).getClassName();
        row[2] = list.get(i).getClassCapacity();
        row[3] = list.get(i).getInstructor();
        row[4] = list.get(i).getSection();
        row[5] = list.get(i).getDay();
        row[6] = list.get(i).getStart();
        row[7] = list.get(i).getEnd();
        row[8] = list.get(i).getUnits();
        //table.addRow(row);
        }
    }       
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("test?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        classes_1Query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Classes_1 c");
        classes_1List = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : classes_1Query.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        classname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        classcapaity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        classday = new javax.swing.JComboBox<>();
        classstart = new javax.swing.JComboBox<>();
        classend = new javax.swing.JComboBox<>();
        classunit = new javax.swing.JTextField();
        classsection = new javax.swing.JComboBox<>();
        classdbid = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        classinstructor = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Classes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit / Add New");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Class Name");

        jLabel3.setText("Class Capacity");

        jLabel4.setText("Instructor");

        jLabel5.setText("Section");

        jLabel6.setText("Start");

        jLabel7.setText("End");

        jLabel8.setText("Unit Count");

        jLabel9.setText("Day");

        classday.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Weekly", "Mon-Wed-Fri", "Tue-Thurs-Sat" }));

        classstart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8am", "9am", "10am", "11am", "12pm", "1pm", "2pm", "3pm", "4pm", "5pm", "6pm", "7pm", "8pm" }));

        classend.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8am", "9am", "10am", "11am", "12pm", "1pm", "2pm", "3pm", "4pm", "5pm", "6pm", "7pm", "8pm" }));

        jLabel10.setText("Class dbID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(classcapaity, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(classend, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(classday, javax.swing.GroupLayout.Alignment.LEADING, 0, 114, Short.MAX_VALUE)
                                .addComponent(classstart, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(classunit)
                                .addComponent(classsection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(classname, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(classdbid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(classinstructor, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(53, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addContainerGap(12, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classdbid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classcapaity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(classinstructor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(classsection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classstart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(classunit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, classes_1List, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${classdbid}"));
        columnBinding.setColumnName("Classdbid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${className}"));
        columnBinding.setColumnName("Class Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${classCapacity}"));
        columnBinding.setColumnName("Class Capacity");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${instructor}"));
        columnBinding.setColumnName("Instructor");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${section}"));
        columnBinding.setColumnName("Section");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${day}"));
        columnBinding.setColumnName("Day");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${start}"));
        columnBinding.setColumnName("Start");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${end}"));
        columnBinding.setColumnName("End");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${units}"));
        columnBinding.setColumnName("Units");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton5.setText("Cancel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addContainerGap(370, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton5))
        );

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String sql = "INSERT INTO classes "
                + "(ClassName,ClassCapacity,Instructor,Section,Day,Start,End,Units) "
                + "VALUES (?,?,?,?,?,?,?,?)";   
        try(PreparedStatement stmt = con.prepareStatement(sql)){
            String cname = classname.getText();
            int ccap = Integer.parseInt(classcapaity.getText());
            String cins = classinstructor.getSelectedItem().toString();
            String csec = classsection.getSelectedItem().toString();
            String cday = classday.getSelectedItem().toString();
            String cstart = classstart.getSelectedItem().toString();
            String cend = classend.getSelectedItem().toString();
            int cunit = Integer.parseInt(classunit.getText());
            stmt.setString(1, cname);
            stmt.setInt(2, ccap);
            stmt.setString(3, cins);
            stmt.setString(4, csec);
            stmt.setString(5, cday);
            stmt.setString(6, cstart);
            stmt.setString(7, cend);
            stmt.setInt(8, cunit);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "New class added!");
            update_table();
            
            classname.setText("");
            classcapaity.setText("");
            classunit.setText("");
            classname.setEditable(false);
            classcapaity.setEditable(false);
            classinstructor.setEnabled(false);
            classsection.setEnabled(false);
            classday.setEnabled(false);
            classstart.setEnabled(false);
            classend.setEnabled(false);
            classunit.setEditable(false);
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            classname.setEditable(true);
            classcapaity.setEditable(true);
            classinstructor.setEnabled(true);
            classsection.setEnabled(true);
            classday.setEnabled(true);
            classstart.setEnabled(true);
            classend.setEnabled(true);
            classunit.setEditable(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int dbid = Integer.parseInt(classdbid.getText());
        String cname = classname.getText();
        String cins = classinstructor.getSelectedItem().toString();
        String csec = classsection.getSelectedItem().toString();
        String cday = classday.getSelectedItem().toString();
        String cstart = classstart.getSelectedItem().toString();
        String cend = classend.getSelectedItem().toString();
        int unit = Integer.parseInt(classunit.getText());
        int ccap = Integer.parseInt(classcapaity.getText());

        String sql = "UPDATE classes SET "
                + "ClassName=?,ClassCapacity=?,Instructor=?,Section=?,Day=?,Start=?,End=?,Units=? "
                + "WHERE Class_dbid='"+dbid+"'";
        try(PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, cname);
            pstmt.setInt(2, ccap);
            pstmt.setString(3, cins);
            pstmt.setString(4, csec);
            pstmt.setString(5, cday);
            pstmt.setString(6, cstart);
            pstmt.setString(7, cend);
            pstmt.setInt(8, unit);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Updated!");
            
            classname.setText("");
            classcapaity.setText("");    
            classunit.setText("");
            classinstructor.setEnabled(false);
            classsection.setEnabled(false);
            classday.setEnabled(false);
            classstart.setEnabled(false);
            classend.setEnabled(false);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }   
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int dbid = Integer.parseInt(classdbid.getText());
        String sql = "DELETE FROM classes WHERE Class_dbid='"+dbid+"'";
        try(PreparedStatement pstmt=con.prepareStatement(sql)){
            int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this item?");
            if (result == JOptionPane.OK_OPTION) {
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, "1 record deleted!");
                }
            }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
            }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        classdbid.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        classname.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        classcapaity.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        classinstructor.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
        classsection.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
        classday.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
        classstart.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
        classend.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
        classunit.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 8).toString());

            classname.setEditable(false);
            classcapaity.setEditable(false);
            classinstructor.setEnabled(false);
            classsection.setEnabled(false);
            classday.setEnabled(false);
            classstart.setEnabled(false);
            classend.setEnabled(false);
            classunit.setEditable(false);
            jButton1.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jButton1.setEnabled(true);
        classdbid.setText("");
        classname.setText("");
        classcapaity.setText("");
        classunit.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Classes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Classes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Classes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Classes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Classes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField classcapaity;
    private javax.swing.JComboBox<String> classday;
    private javax.swing.JTextField classdbid;
    private javax.swing.JComboBox<String> classend;
    private java.util.List<students.Classes_1> classes_1List;
    private javax.persistence.Query classes_1Query;
    private javax.swing.JComboBox<String> classinstructor;
    private javax.swing.JTextField classname;
    private javax.swing.JComboBox<String> classsection;
    private javax.swing.JComboBox<String> classstart;
    private javax.swing.JTextField classunit;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
