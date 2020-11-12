import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class MyApp extends JFrame implements ActionListener{
	
	private JRadioButton A, B, C;
	private JButton calculate;
	private JTextField grade;
	private JTextArea menu, overall ,gradeText;
	private Grade student;
	
	public MyApp(Grade student) {
		
		this.student = student;
		
		setTitle("Grade Calculator");
		setSize(1000, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		A = new JRadioButton("A");
		B = new JRadioButton("B");
		C = new JRadioButton("C");
		
		calculate = new JButton("Calculate Overall Grade");
		
		grade = new JTextField(10);
		
		String menuInformation = "The goal of this program is determined your current grade of the class."
				+ "\nTo do so, enter your grades in the format grade/maximum possible grade separated by a comma."
				+ "\nFor instance, enter the grades as follow: 10/10, 41.5/50, etc..."
				+ "Then click 'Calculate Overall Grade' to determine your overall grade\n"
				+ "at the center area below.\nTo see whether you already have an A, B, or C for this class,"
				+ "click on the appropriate button and a message will be displayed\nabout the state of the grade "
				+ "you want.";
		
		menu = new JTextArea(menuInformation);
		overall = new JTextArea();  // displays overall grade
		gradeText = new JTextArea(); // displays A, B, and C grade update
		
		menu.setEditable(false);
		overall.setEditable(false);
		
		setVisible(true);
		
		// ButtonGroup enables us to only select one JRadioButton
		// at the time
		ButtonGroup group = new ButtonGroup();
		
		group.add(A);
		group.add(B);
		group.add(C);
		
		//adding action listener
		A.addActionListener(this);
		B.addActionListener(this);
		C.addActionListener(this);
		calculate.addActionListener(this);
		
		Container mainContainer = this.getContentPane();
		mainContainer.setLayout(new BorderLayout(6, 2));
		mainContainer.setBackground(Color.RED);
		this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN));
		 
		// menu Panel
		JPanel topPanel = new JPanel();
		topPanel.setBorder(new LineBorder(Color.BLACK, 3));
		topPanel.setBackground(Color.ORANGE);
		topPanel.setLayout(new FlowLayout(1));
		add(topPanel, BorderLayout.NORTH);
		mainContainer.add(topPanel, BorderLayout.NORTH);
		topPanel.add(menu);
		
		// grades calculator panel
		JPanel midPanel = new JPanel();
		midPanel.setBorder(new LineBorder(Color.BLACK, 3));
		midPanel.setBackground(Color.CYAN);
		midPanel.setLayout(new FlowLayout(2, 4, 4));
		
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(2, 2, 5, 5));
		gridPanel.setBorder(new LineBorder(Color.BLACK, 4));
		gridPanel.setBackground(Color.BLUE);
		gridPanel.add(grade);
		gridPanel.add(calculate);
		midPanel.add(gridPanel);
		mainContainer.add(midPanel, BorderLayout.EAST);
		
		// grade display panel
		JPanel cenPanel = new JPanel();
		cenPanel.setOpaque(true);
		cenPanel.setBorder(new LineBorder(Color.BLACK, 3));
		cenPanel.add(overall);
		mainContainer.add(cenPanel);
		
		// grade letter option panel
		JPanel westPanel = new JPanel();
		westPanel.setBorder(new LineBorder(Color.BLACK, 3));
		westPanel.setBackground(Color.MAGENTA);
		westPanel.setLayout(new GridLayout(1, 3));
		mainContainer.add(westPanel, BorderLayout.WEST);
		
		westPanel.add(A);
		westPanel.add(B);
		westPanel.add(C);
		
		// grades result updates panel
		JPanel southPanel = new JPanel();
		southPanel.setBorder(new LineBorder(Color.BLACK, 3));
		southPanel.setBackground(Color.GRAY);
		southPanel.setLayout(new FlowLayout(1));
		mainContainer.add(southPanel, BorderLayout.SOUTH);
		
		southPanel.add(gradeText);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == calculate) {
			student.addGrade(grade.getText());
			overall.setText(student.toString());
			gradeText.setText("");
		} else if (e.getSource() == A) {
			gradeText.setText(student.toGetA());
		} else if (e.getSource() == B) {
			gradeText.setText(student.toGetB());
		} else {
			gradeText.setText(student.toGetC());
		}
	}
}
