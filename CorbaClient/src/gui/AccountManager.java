package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import AccountSection.Account;

public class AccountManager {

	private JFrame frame;
	private JRadioButton rdbtnDeposit;
	private JRadioButton rdbtnWithraw;
	private JTextField tfDeposit;
	private JTextField tfWithdraw;
	private Account a;
	private int bal;
	private JLabel lblCurrentBalance;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new AccountManager();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AccountManager() {
		WindowUtil.setNimbusLook();
		initialize();
		frame.setVisible(true);
	}
	public AccountManager(Account a) {
		WindowUtil.setNimbusLook();
		this.a=a;
		initialize();
	
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 530, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblAccountManagmentSystem = new JLabel("Manage Your Account");
		lblAccountManagmentSystem.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblAccountManagmentSystem.setForeground(new Color(128, 0, 0));
		lblAccountManagmentSystem.setFont(new Font("Century", Font.BOLD, 20));
		panel.add(lblAccountManagmentSystem, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AccountManager.class.getResource("/images/deposit-01.png")));
		panel_1.add(label, BorderLayout.EAST);
		
		JPanel backLeft = new JPanel();
		backLeft.setBorder(new EmptyBorder(10, 0, 10, 0));
		backLeft.setBackground(Color.WHITE);
		panel_1.add(backLeft, BorderLayout.CENTER);
		backLeft.setLayout(new GridLayout(0, 1, 10, 10));
		
		JPanel pnlDeposit = new JPanel();
		pnlDeposit.setBorder(UIManager.getBorder("TitledBorder.border"));
		pnlDeposit.setBackground(new Color(255, 250, 250));
		backLeft.add(pnlDeposit);
		
		rdbtnDeposit = new JRadioButton("DEPOSIT",true);
		rdbtnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfWithdraw.setEnabled(false);
				tfDeposit.setEnabled(true);
			}
		});
		pnlDeposit.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
		
		rdbtnDeposit.setFont(new Font("Calisto MT", Font.BOLD, 14));
		pnlDeposit.add(rdbtnDeposit);
		
		JPanel pnlWithdraw = new JPanel();
		pnlWithdraw.setBorder(UIManager.getBorder("TitledBorder.border"));
		pnlWithdraw.setBackground(new Color(255, 250, 250));
		backLeft.add(pnlWithdraw);
		

		rdbtnWithraw = new JRadioButton("WITHDRAW");
		rdbtnWithraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfWithdraw.setEnabled(true);
				tfDeposit.setEnabled(false);
			}
		});
		pnlWithdraw.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		rdbtnWithraw.setFont(new Font("Calisto MT", Font.BOLD, 13));
		pnlWithdraw.add(rdbtnWithraw);
		
		
		ButtonGroup g=new ButtonGroup();
		g.add(rdbtnDeposit);
		
		tfDeposit = new JTextField();
		tfDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					int amount=Integer.parseInt(tfDeposit.getText());
					if(a!=null){
						
						a.deposit(amount);
						if(bal==a.getBalance())
							JOptionPane.showMessageDialog(frame, "Trasanction:Deposit Failed","error", JOptionPane.ERROR_MESSAGE, null);
						else{
							bal=a.getBalance();
							JOptionPane.showMessageDialog(frame, "Transaction:Deposit Successful");
							tfDeposit.setText("");
							lblCurrentBalance.setText("Current Balance:"+bal);
						} 
							
					}
				}catch(Exception e1){
					e1.printStackTrace();
					JOptionPane.showMessageDialog(frame, "Please Enter Valid Amount!!");
				}
			}
		});
		pnlDeposit.add(tfDeposit);
		tfDeposit.setColumns(10);
		g.add(rdbtnWithraw);
		
		tfWithdraw = new JTextField();
		tfWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int amount=Integer.parseInt(tfWithdraw.getText());
					if(a!=null){
						
						a.withdraw(amount);
						
						if(bal==a.getBalance())
							JOptionPane.showMessageDialog(frame, "Trasanction:Withdraw Failed","error", JOptionPane.ERROR_MESSAGE, null);
						else{
							bal=a.getBalance();
							lblCurrentBalance.setText("Current Balance:"+bal);
							JOptionPane.showMessageDialog(frame, "Transaction:Withdraw Successful");
							tfWithdraw.setText("");
						} 
							
					}
				}catch(Exception e1){
					JOptionPane.showMessageDialog(frame, "Please Enter Valid Amount!!");
				}
			}
		});
		pnlWithdraw.add(tfWithdraw);
		tfWithdraw.setEnabled(false);
		tfWithdraw.setColumns(10);
		
		JPanel pnlBottom = new JPanel();
		pnlBottom.setBorder(UIManager.getBorder("TitledBorder.border"));
		pnlBottom.setBackground(Color.WHITE);
		panel.add(pnlBottom, BorderLayout.SOUTH);
		if(a!=null)
		bal=a.getBalance();
		lblCurrentBalance = new JLabel("Current Balance :"+bal);
		lblCurrentBalance.setForeground(new Color(128, 0, 0));
		lblCurrentBalance.setFont(new Font("Century", Font.BOLD, 20));
		pnlBottom.add(lblCurrentBalance);
	}

}
