package students;
//import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class enrollment extends javax.swing.JFrame {
    Connection con;
    Statement stmt;
    ResultSet rs;
    double a;
    double b;
    double c;
    double d;
    double overall;
    public enrollment() {
        initComponents();
        doConnect();
        combocourse();
        comboClass();
        showTable();
        showTableClasses();
    }
    
    public void doConnect(){
        btnSaveNew.setEnabled(false);
        btnCancelRec.setEnabled(false);
        btnUpdate.setEnabled(false);
        //btnDelete.setEnabled(false);
        textsdbid.setEditable(false);
        textsid.setEditable(false);
        textsfname.setEditable(false);
        textsmname.setEditable(false);
        textslname.setEditable(false);
        textsage.setEditable(false);
        textsgender.setEnabled(false);
        comboCourse.setEnabled(false);
        textyrlvl.setEnabled(false);
        textsemal.setEditable(false);
        subdbid.setEditable(false);
        subfname.setEditable(false);
        sublname.setEditable(false);
        graddbid.setEditable(false);
        subfname1.setEditable(false);
        sublname1.setEditable(false);
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
    public void combocourse(){
        try {
            stmt = con.createStatement();
            String sqlcourse = "SELECT * FROM course";
            rs = stmt.executeQuery(sqlcourse);
            while(rs.next()) {
                comboCourse.addItem(rs.getString(3));
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
        }
        */
    }

    public void comboClass(){
        try {
            stmt = con.createStatement();
            String sqlcourse = "SELECT * FROM classes";
            rs = stmt.executeQuery(sqlcourse);
            while(rs.next()) {
                selectClass.addItem(rs.getString(2) + " " + rs.getString(6) + " " + rs.getString(7) + " " + rs.getString(8));
                gradSelClass.addItem(rs.getString(2));
                //classstart.addItem(rs.getString(7));
                //classend.addItem(rs.getString(8));
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
        }
        */
    }

   void update_table() throws SQLException {
        //try {
            rs = stmt.executeQuery("SELECT * FROM student_info");
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        //}
        /*
        catch (SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
        }*/
    }    
   void update_tableGrade() throws SQLException {
        //try {
            rs = stmt.executeQuery("SELECT * FROM ratings");
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        //}
        /*
        catch (SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
        }*/
    } 

   void etoc() throws SQLException {
        //try {
            rs = stmt.executeQuery("SELECT * FROM enrolled_to_classes");
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
        //}
        /*
        catch (SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
        }*/
    } 
    public ArrayList<StudentInfo> StudentInfoList () {
        ArrayList<StudentInfo> studentinfo = new ArrayList<StudentInfo>();
        //Connection connection = getConnection();
        String sql = "SELECT * FROM student_info";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            StudentInfo sinfo;
            while (rs.next()) {
            sinfo = new StudentInfo(rs.getInt("student_dbid"),rs.getString("StudentID"),rs.getString("Firstname"),rs.getString("Middlename"),rs.getString("Lastname"),rs.getInt("Age"),rs.getString("Gender"),rs.getString("Course"),rs.getString("YearLevel"),rs.getString("Email"));
            studentinfo.add(sinfo);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        return studentinfo;
    }
    
    public void showTable() {
    ArrayList<StudentInfo> list = StudentInfoList();
    //DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
    Object[] row = new Object[10];
    
    for (int i=0;i<list.size();i++) {
        row[0] = list.get(i).getStudentDbid();
        row[1] = list.get(i).getStudentID();
        row[2] = list.get(i).getFirstname();
        row[3] = list.get(i).getMiddlename();
        row[4] = list.get(i).getLastname();
        row[5] = list.get(i).getAge();
        row[6] = list.get(i).getGender();
        row[7] = list.get(i).getCourse();
        row[8] = list.get(i).getYearLevel();
        row[9] = list.get(i).getEmail();
        //table.addRow(row);
        }
    } 
//enroll to class
    public ArrayList<EnrolledToClasses> EnrolledToClassesList () {
        ArrayList<EnrolledToClasses> enrolledtoclass = new ArrayList<EnrolledToClasses>();
        //Connection connection = getConnection();
        String sql = "SELECT * FROM enrolled_to_classes";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            EnrolledToClasses etoc;
            while (rs.next()) {
            //etoc = new EnrolledToClasses(rs.getInt("ec_id"),rs.getString("ClassDetails"),rs.getString("Firstname"),rs.getString("Lastname"));
            etoc = new EnrolledToClasses(rs.getInt("ec_id"),rs.getString("ClassDetails"),rs.getString("Firstname"),rs.getString("Lastname"));
            enrolledtoclass.add(etoc);
            }
            
        } catch (Exception e) {
        }
        return enrolledtoclass;
    }
    
    public void showTableClasses() {
    ArrayList<EnrolledToClasses> list = EnrolledToClassesList();
    //DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
    Object[] row = new Object[4];
    
    for (int i=0;i<list.size();i++) {
        row[0] = list.get(i).getEcId();
        row[1] = list.get(i).getClassDetails();
        row[2] = list.get(i).getFirstname();
        row[3] = list.get(i).getLastname();
        //table.addRow(row);
        }
    } 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("test?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        studentInfoQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT s FROM StudentInfo s");
        studentInfoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : studentInfoQuery.getResultList();
        enrolledToClassesQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT e FROM EnrolledToClasses e");
        enrolledToClassesList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : enrolledToClassesQuery.getResultList();
        ratingsQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT r FROM Ratings r");
        ratingsList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : ratingsQuery.getResultList();
        ratingsQuery1 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT r FROM Ratings r");
        ratingsList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : ratingsQuery1.getResultList();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textsdbid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textsid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textsfname = new javax.swing.JTextField();
        textsmname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textslname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textsage = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textsemal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textsgender = new javax.swing.JComboBox<>();
        textyrlvl = new javax.swing.JComboBox<>();
        comboCourse = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSaveNew = new javax.swing.JButton();
        btnCancelRec = new javax.swing.JButton();
        btnNewRec = new javax.swing.JButton();
        btnEdt = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        gradPrelim = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        gradMidterm = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        gradPrefinal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        gradFinal = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        gradOR = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        gradSem = new javax.swing.JComboBox<>();
        gradSelClass = new javax.swing.JComboBox<>();
        graddbid = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnUpdate1 = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        btnSaveNew1 = new javax.swing.JButton();
        btnCancelRec1 = new javax.swing.JButton();
        btnEdt1 = new javax.swing.JButton();
        subfname1 = new javax.swing.JTextField();
        sublname1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        btnCancelRec2 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        subfname = new javax.swing.JTextField();
        sublname = new javax.swing.JTextField();
        subdbid = new javax.swing.JTextField();
        selectClass = new javax.swing.JComboBox<>();
        btnSaveNew2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Student Records");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, studentInfoList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${studentDbid}"));
        columnBinding.setColumnName("Student Dbid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${studentID}"));
        columnBinding.setColumnName("Student ID");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${firstname}"));
        columnBinding.setColumnName("Firstname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${middlename}"));
        columnBinding.setColumnName("Middlename");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastname}"));
        columnBinding.setColumnName("Lastname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${age}"));
        columnBinding.setColumnName("Age");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${gender}"));
        columnBinding.setColumnName("Gender");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${course}"));
        columnBinding.setColumnName("Course");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${yearLevel}"));
        columnBinding.setColumnName("Year Level");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${email}"));
        columnBinding.setColumnName("Email");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel2.setText("dbID");

        jLabel3.setText("Student ID");

        jLabel4.setText("Firstname");

        jLabel5.setText("Middlename");

        jLabel6.setText("Lastname");

        jLabel7.setText("Age");

        jLabel8.setText("Gender");

        jLabel9.setText("Email");

        jLabel10.setText("Course");

        jLabel11.setText("Year Level");

        textsgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        textyrlvl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "4th" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSaveNew.setText("Save New Record");
        btnSaveNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveNewActionPerformed(evt);
            }
        });

        btnCancelRec.setText("Cancel");
        btnCancelRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelRecActionPerformed(evt);
            }
        });

        btnNewRec.setText("New Record");
        btnNewRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRecActionPerformed(evt);
            }
        });

        btnEdt.setText("Edit");
        btnEdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnEdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelRec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNewRec, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveNew, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEdt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNewRec)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelRec))
                    .addComponent(btnSaveNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textsgender, 0, 81, Short.MAX_VALUE)
                            .addComponent(textsdbid)
                            .addComponent(textsage)
                            .addComponent(textsfname))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textsemal))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textsmname, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textslname, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textsid, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textyrlvl, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 307, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textsdbid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(textsid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textsfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(textsmname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(textslname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(textsemal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textsage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(textyrlvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textsgender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(comboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Student Info", jPanel2);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel12.setText("Prelim");

        jLabel13.setText("Midterm");

        jLabel14.setText("Prefinal");

        jLabel15.setText("Final");

        jLabel16.setText("Overall Rating");

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, ratingsList1, jTable2);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ratingsdbid}"));
        columnBinding.setColumnName("Ratingsdbid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${firstname}"));
        columnBinding.setColumnName("Firstname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastname}"));
        columnBinding.setColumnName("Lastname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${className}"));
        columnBinding.setColumnName("Class Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${semester}"));
        columnBinding.setColumnName("Semester");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${prelim}"));
        columnBinding.setColumnName("Prelim");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${midterm}"));
        columnBinding.setColumnName("Midterm");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${prefinal}"));
        columnBinding.setColumnName("Prefinal");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${final1}"));
        columnBinding.setColumnName("Final1");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${overallRating}"));
        columnBinding.setColumnName("Overall Rating");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel17.setText("Select a class");

        jLabel18.setText("Semester");

        gradSem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd" }));

        jLabel19.setText("dbID");

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnUpdate1.setText("Update");
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });

        btnDelete1.setText("Delete");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        btnSaveNew1.setText("Save");
        btnSaveNew1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveNew1ActionPerformed(evt);
            }
        });

        btnCancelRec1.setText("Cancel");
        btnCancelRec1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelRec1ActionPerformed(evt);
            }
        });

        btnEdt1.setText("Edit");
        btnEdt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdt1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(btnUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnEdt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelRec1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveNew1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdt1)
                            .addComponent(btnSaveNew1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete1))
                    .addComponent(btnUpdate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelRec1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        subfname1.setText("Firstname");

        sublname1.setText("Lastname");

        jButton1.setText("Calculate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(gradSelClass, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gradFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel18))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(gradSem, 0, 97, Short.MAX_VALUE)
                                            .addComponent(gradMidterm)))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(gradPrefinal, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gradPrelim, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(gradOR)))
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(graddbid, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subfname1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sublname1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 110, Short.MAX_VALUE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(subfname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sublname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(graddbid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gradSelClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(gradSem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(gradPrelim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(gradMidterm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(gradPrefinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(gradFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(gradOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Grades/Ratings", jPanel5);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, enrolledToClassesList, jTable3);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ecId}"));
        columnBinding.setColumnName("Ec Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${classDetails}"));
        columnBinding.setColumnName("Class Details");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${firstname}"));
        columnBinding.setColumnName("Firstname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastname}"));
        columnBinding.setColumnName("Lastname");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnCancelRec2.setText("Delete");
        btnCancelRec2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelRec2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelRec2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancelRec2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel20.setText("Select Class");

        btnSaveNew2.setText("Enroll");
        btnSaveNew2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveNew2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectClass, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(subdbid, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subfname, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sublname, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveNew2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sublname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subdbid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(selectClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveNew2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jTabbedPane1.addTab("Classes/Subjects", jPanel7);

        jMenu1.setText("File");

        jMenu5.setText("Add New");

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        jMenuItem8.setText("User");
        jMenuItem8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem8MousePressed(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem1.setText("Course");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MousePressed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem2.setText("Classes/Subj");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem2MousePressed(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem3.setText("Section");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem3MousePressed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem4.setText("Rooms");
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem4MousePressed(evt);
            }
        });
        jMenu5.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem5.setText("Instructor");
        jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem5MousePressed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenu1.add(jMenu5);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        jMenuItem7.setText(" Logout");
        jMenuItem7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem7MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem7MousePressed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        jMenu4.setText(" Settings");

        jMenuItem6.setText("Grades/Ratings");
        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Credits");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu3MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveNewActionPerformed
            String sql = "INSERT INTO student_info "
                + "(StudentID,Firstname,Middlename,Lastname,Age,Gender,Course,YearLevel,Email) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";   
        try(PreparedStatement stmt = con.prepareStatement(sql)){
            int sid = Integer.parseInt(textsid.getText());
            String fname = textsfname.getText();
            String mname = textsmname.getText();
            String lname = textslname.getText();
            int age = Integer.parseInt(textsage.getText());
            String gender = textsgender.getSelectedItem().toString();
            String course = comboCourse.getSelectedItem().toString();
            String yrlvl = textyrlvl.getSelectedItem().toString();
            String email = textsemal.getText();
            stmt.setInt(1, sid);
            stmt.setString(2, fname);
            stmt.setString(3, mname);
            stmt.setString(4, lname);
            stmt.setInt(5, age);
            stmt.setString(6, gender);
            stmt.setString(7, course);
            stmt.setString(8, yrlvl);
            stmt.setString(9, email);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "New record added in database!");
            update_table();
            textsid.setText("");
            textsfname.setText("");
            textsmname.setText("");
            textslname.setText("");
            textsage.setText("");
            textsemal.setText("");
            
            textsid.setEditable(false);
            textsfname.setEditable(false);
            textsmname.setEditable(false);
            textslname.setEditable(false);
            textsage.setEditable(false);
            textsgender.setEnabled(false);
            comboCourse.setEnabled(false);
            textyrlvl.setEnabled(false);
            textsemal.setEditable(false);
        btnSaveNew.setEnabled(false);
        btnCancelRec.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnSaveNewActionPerformed

    private void btnNewRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRecActionPerformed
        btnSaveNew.setEnabled(true);
        btnCancelRec.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnEdt.setEnabled(false);
        textsid.setEditable(true);
        textsfname.setEditable(true);
        textsmname.setEditable(true);
        textslname.setEditable(true);
        textsage.setEditable(true);
        textsgender.setEnabled(true);
        comboCourse.setEnabled(true);
        textyrlvl.setEnabled(true);
        textsemal.setEditable(true);
        
        textsdbid.setText("");
        textsid.setText("");
        textsfname.setText("");
        textsmname.setText("");
        textslname.setText("");
        textsage.setText("");
        textsemal.setText("");
    }//GEN-LAST:event_btnNewRecActionPerformed

    private void btnEdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdtActionPerformed
btnUpdate.setEnabled(true);
btnDelete.setEnabled(true);
btnEdt.setEnabled(false);
btnNewRec.setEnabled(false);
btnCancelRec.setEnabled(true);
        textsid.setEditable(true);
        textsfname.setEditable(true);
        textsmname.setEditable(true);
        textslname.setEditable(true);
        textsage.setEditable(true);
        textsgender.setEnabled(true);
        comboCourse.setEnabled(true);
        textyrlvl.setEnabled(true);
        textsemal.setEditable(true);
    }//GEN-LAST:event_btnEdtActionPerformed

    private void btnCancelRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelRecActionPerformed
        btnSaveNew.setEnabled(false);
        btnCancelRec.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnEdt.setEnabled(true);
        btnNewRec.setEnabled(true);
        textsid.setText("");
        textsfname.setText("");
        textsmname.setText("");
        textslname.setText("");
        textsage.setText("");
        textsemal.setText("");
        textsid.setEditable(false);
        textsfname.setEditable(false);
        textsmname.setEditable(false);
        textslname.setEditable(false);
        textsage.setEditable(false);
        textsgender.setEnabled(false);
        comboCourse.setEnabled(false);
        textyrlvl.setEnabled(false);
        textsemal.setEditable(false);
    }//GEN-LAST:event_btnCancelRecActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        graddbid.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        subfname1.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        sublname1.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
        subdbid.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        subfname.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        sublname.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
        
        textsdbid.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        textsid.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        textsfname.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        textsmname.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
        textslname.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
        textsage.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
        textsgender.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
        comboCourse.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
        textyrlvl.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 8).toString());
        textsemal.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 9).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int dbid = Integer.parseInt(textsdbid.getText());
        int studID = Integer.parseInt(textsid.getText());
        String fname = textsfname.getText();
        String mname = textsmname.getText();
        String lname = textslname.getText();
        int age = Integer.parseInt(textsage.getText());
        String gender = textsgender.getSelectedItem().toString();
        String course = comboCourse.getSelectedItem().toString();
        String yrlvl = textyrlvl.getSelectedItem().toString();
        String email = textsemal.getText();
        String sql = "UPDATE student_info SET "
                + "StudentID=?,Firstname=?,Middlename=?,Lastname=?,Age=?,Gender=?,Course=?,YearLevel=?,Email=? "
                + "WHERE student_dbid='"+dbid+"'";
        try(PreparedStatement pstmt = con.prepareStatement(sql)){
        /*
        if (textsdbid.equals(" ")) {
            JOptionPane.showMessageDialog(this, "You need to have dbid when updating! Try add new record instead.", "Invalid", JOptionPane.ERROR_MESSAGE);
        }
        else {
        }
        */
            pstmt.setInt(1, studID);
            pstmt.setString(2, fname);
            pstmt.setString(3, mname);
            pstmt.setString(4, lname);
            pstmt.setInt(5, age);
            pstmt.setString(6, gender);
            pstmt.setString(7, course);
            pstmt.setString(8, yrlvl);
            pstmt.setString(9, email);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Updated!");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }           
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int dbid = Integer.parseInt(textsdbid.getText());
        String sql = "DELETE FROM student_info WHERE student_dbid='"+dbid+"'";
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
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem8MousePressed
        new profile().setVisible(true);
    }//GEN-LAST:event_jMenuItem8MousePressed

    private void jMenuItem1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MousePressed
        new Course().setVisible(true);
    }//GEN-LAST:event_jMenuItem1MousePressed

    private void jMenuItem2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MousePressed
        new Classes().setVisible(true);
    }//GEN-LAST:event_jMenuItem2MousePressed

    private void jMenuItem3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MousePressed
        new Section().setVisible(true);
    }//GEN-LAST:event_jMenuItem3MousePressed

    private void jMenuItem4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MousePressed
        new Rooms().setVisible(true);
    }//GEN-LAST:event_jMenuItem4MousePressed

    private void jMenuItem5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem5MousePressed
        new Instructor().setVisible(true);
    }//GEN-LAST:event_jMenuItem5MousePressed

    private void jMenuItem7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem7MouseClicked
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?");
        if (result == JOptionPane.OK_OPTION) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jMenuItem7MouseClicked

    private void jMenuItem7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem7MousePressed
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?");
        if (result == JOptionPane.OK_OPTION) {
            
            //this.invalidate();
            this.dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem7MousePressed

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        int dbid = Integer.parseInt(graddbid.getText());
        String sql = "DELETE FROM ratings WHERE Ratings_dbid='"+dbid+"'";
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
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnSaveNew1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveNew1ActionPerformed
            String sql = "INSERT INTO ratings "
                + "(Firstname,Lastname,ClassName,Semester,Prelim,Midterm,Prefinal,Final,OverallRating) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";   
        try(PreparedStatement stmt = con.prepareStatement(sql)){
            String sclass = gradSelClass.getSelectedItem().toString();
            String ssem = gradSem.getSelectedItem().toString();
            String fname = subfname1.getText();
            String lname = sublname1.getText();
            double prelim = Double.parseDouble(gradPrelim.getText());
            double midterm = Double.parseDouble(gradMidterm.getText());
            double prefinal = Double.parseDouble(gradPrefinal.getText());
            double finals = Double.parseDouble(gradFinal.getText());
            double overallr = Double.parseDouble(gradOR.getText());
            
            stmt.setString(1, fname);
            stmt.setString(2, lname);
            stmt.setString(3, sclass);
            stmt.setString(4, ssem);
            stmt.setDouble(5, prelim);
            stmt.setDouble(6, midterm);
            stmt.setDouble(7, prefinal);
            stmt.setDouble(8, finals);
            stmt.setDouble(9, overallr);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Added!");
            update_tableGrade();
            gradPrelim.setText("");
            gradMidterm.setText("");
            gradPrefinal.setText("");
            gradFinal.setText("");
            gradOR.setText("");
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnSaveNew1ActionPerformed

    private void btnCancelRec1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelRec1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelRec1ActionPerformed

    private void btnEdt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEdt1ActionPerformed

    private void btnSaveNew2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveNew2ActionPerformed
        String sql = "INSERT INTO enrolled_to_classes "
                + "(ClassDetails,Firstname,Lastname) "
                + "VALUES (?,?,?)";   
        try(PreparedStatement stmt = con.prepareStatement(sql)){

            String cdet = selectClass.getSelectedItem().toString();
            String fname = subfname.getText();
            String lname = sublname.getText();

            stmt.setString(1, cdet);
            stmt.setString(2, fname);
            stmt.setString(3, lname);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Enrolled!");
            etoc();
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnSaveNew2ActionPerformed

    private void btnCancelRec2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelRec2ActionPerformed
        int dbid = Integer.parseInt(subdbid.getText());
        String sql = "DELETE FROM enrolled_to_classes WHERE ec_id='"+dbid+"'";
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
    }//GEN-LAST:event_btnCancelRec2ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        subdbid.setText(jTable3.getValueAt(jTable3.getSelectedRow(), 0).toString());
        selectClass.setSelectedItem(jTable3.getValueAt(jTable3.getSelectedRow(), 1).toString());
        subfname.setText(jTable3.getValueAt(jTable3.getSelectedRow(), 2).toString());
        sublname.setText(jTable3.getValueAt(jTable3.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_jTable3MouseClicked

    private void jMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MousePressed
        new credits().setVisible(true);
    }//GEN-LAST:event_jMenu3MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        a = Double.parseDouble(gradPrelim.getText());
        b = Double.parseDouble(gradMidterm.getText());
        c = Double.parseDouble(gradPrefinal.getText());
        d = Double.parseDouble(gradFinal.getText());
        overall = (a + b + c +d)/4;
        gradOR.setText("" + overall);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        graddbid.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString());
        subfname1.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString());
        sublname1.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString());
        gradSelClass.setSelectedItem(jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString());
        gradSem.setSelectedItem(jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString());
        gradPrelim.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 5).toString());
        gradMidterm.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 6).toString());
        gradPrefinal.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 7).toString());
        gradFinal.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 8).toString());
        gradOR.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 9).toString());
    }//GEN-LAST:event_jTable2MouseClicked

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
            java.util.logging.Logger.getLogger(enrollment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(enrollment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(enrollment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(enrollment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new enrollment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelRec;
    private javax.swing.JButton btnCancelRec1;
    private javax.swing.JButton btnCancelRec2;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnEdt;
    private javax.swing.JButton btnEdt1;
    private javax.swing.JButton btnNewRec;
    private javax.swing.JButton btnSaveNew;
    private javax.swing.JButton btnSaveNew1;
    private javax.swing.JButton btnSaveNew2;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JComboBox<String> comboCourse;
    private java.util.List<students.EnrolledToClasses> enrolledToClassesList;
    private javax.persistence.Query enrolledToClassesQuery;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JTextField gradFinal;
    private javax.swing.JTextField gradMidterm;
    private javax.swing.JTextField gradOR;
    private javax.swing.JTextField gradPrefinal;
    private javax.swing.JTextField gradPrelim;
    private javax.swing.JComboBox<String> gradSelClass;
    private javax.swing.JComboBox<String> gradSem;
    private javax.swing.JTextField graddbid;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private java.util.List<students.Ratings> ratingsList;
    private java.util.List<students.Ratings> ratingsList1;
    private javax.persistence.Query ratingsQuery;
    private javax.persistence.Query ratingsQuery1;
    private javax.swing.JComboBox<String> selectClass;
    private java.util.List<students.StudentInfo> studentInfoList;
    private javax.persistence.Query studentInfoQuery;
    private javax.swing.JTextField subdbid;
    private javax.swing.JTextField subfname;
    private javax.swing.JTextField subfname1;
    private javax.swing.JTextField sublname;
    private javax.swing.JTextField sublname1;
    private javax.swing.JTextField textsage;
    private javax.swing.JTextField textsdbid;
    private javax.swing.JTextField textsemal;
    private javax.swing.JTextField textsfname;
    private javax.swing.JComboBox<String> textsgender;
    private javax.swing.JTextField textsid;
    private javax.swing.JTextField textslname;
    private javax.swing.JTextField textsmname;
    private javax.swing.JComboBox<String> textyrlvl;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
