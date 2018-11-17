package team.qicaipintu.tongxuelu.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class MainJFrame extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JScrollPane jscrolpanel;
	private JTable table;
	private DefaultTableModel model;
	private String[] col= {"姓名","家庭住址","电话","微信","邮箱","QQ","个性语言"};
	//private String data[][]=new String[7][7];

	private String[][] data;
	private JButton button_insert;
	private JButton button_select;
	private JButton button_update;
	private JButton button_delete;
	
	private JButton button_excel;
	public MainJFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("毕业同学录");
		this.setSize(1020, 820);
		this.setLocationRelativeTo(null);
		
		button_insert=new JButton("添加");
		button_delete=new JButton("删除");
		button_update=new JButton("更改");
		button_select=new JButton("查询");
		button_excel=new JButton("导出到excel");
		
		button_insert.setBounds(820, 20, 120, 60);
		button_insert.addActionListener(this);
		
		button_delete.setBounds(820, 90, 120, 60);
		
		button_update.setBounds(820, 160, 120, 60);
		
		button_select.setBounds(820, 230, 120, 60);
	
		button_excel.setBounds(820, 300, 120, 60);
		button_excel.addActionListener(this);
		this.getContentPane().add(button_insert);
		this.getContentPane().add(button_delete);
		this.getContentPane().add(button_update);
		this.getContentPane().add(button_select);
		this.getContentPane().add(button_excel);
		
		
		
		init();
		this.setVisible(true);
	}
	
	public void initData() {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","123456");
			String sql = "select * from student"; 
			PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
			int count = 0;
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
			count++;
			}
			data=new String[count][7];
			rs=pstm.executeQuery();
			count=0;
			while(rs.next()) {
				data[count][0]=rs.getString("sname");
				data[count][1]=rs.getString("saddress");
				data[count][2]=rs.getString("sphone");
				data[count][3]=rs.getString("sweixing");
				data[count][4]=rs.getString("semail");
				data[count][5]=rs.getString("sqq");
				data[count][6]=rs.getString("sself");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public void init() {
		initData();
		
		model=new DefaultTableModel(data,col);
		table=new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(700,600));
		jscrolpanel=new JScrollPane(table);
		jscrolpanel.setBounds(0, 0, 800, 700);
		this.getContentPane().add(jscrolpanel);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainJFrame main=new MainJFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
		case "添加":
			InsertFrame frame = new InsertFrame();
			break;
		case "导出到excel":
			getExcel.toExcel(data);
			break;
		}
	}

}
