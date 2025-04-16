import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class List {
	JTextField text;
	JTextField city;

	public static void main(String[] args) {
		new List().setUp();
	}

	void setUp() {
		JFrame frame = new JFrame("List");
//		DefaultListModel<Animal> lmodel = new DefaultListModel<Animal>();
		DefaultComboBoxModel<Animal>llmodel=new DefaultComboBoxModel<Animal>();
		llmodel.addElement(new Animal("ram", "khagual", "546547657"));
		llmodel.addElement(new Animal("sita", "delhi", "546547657"));
		llmodel.addElement(new Animal("tutu", "patna", "546547657"));
		llmodel.addElement(new Animal("raghav", "sonpur", "546547657"));
		

//		JList list = new JList(lmodel);
        JComboBox box=new JComboBox(llmodel);	
        box.setEditable(true);
        
        
		// list.setSelectedIndex(2);
		// list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		ListSelectionModel model = list.getSelectionModel();
//		model.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		list.setSelectionModel(model);
//		model.addListSelectionListener(event -> {
//			text.setText(lmodel.get(list.getSelectedIndex()).getName());
//			city.setText(lmodel.get(list.getSelectedIndex()).getCity());
//		});
//		JScrollPane pane = new JScrollPane(list);

		JButton add = new JButton("ADD");
		JButton remove= new JButton("Remove");
		JPanel panel=new JPanel();
		panel.add(add);
		panel.add(remove);
		remove.addActionListener(event ->{ llmodel.removeElementAt(box.getSelectedIndex());
		text.setText(null);
		city.setText(null);
		});
		add.addActionListener(event->{
			text.setText(llmodel.getElementAt(box.getSelectedIndex()).getName());
			city.setText(llmodel.getElementAt(box.getSelectedIndex()).getCity());
			
		});
		text = new JTextField(20);
		city = new JTextField(15);
		
		JPanel panel1=new JPanel();
		panel1.add(text);
		panel1.add(city);
		
		frame.getContentPane().add(box, BorderLayout.NORTH);
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		frame.getContentPane().add(panel1, BorderLayout.CENTER);
		frame.setSize(400, 500);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
