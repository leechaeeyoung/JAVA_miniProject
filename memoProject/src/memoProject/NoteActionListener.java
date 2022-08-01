package memoProject;
import java.awt.event.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NoteActionListener implements ActionListner{
	Notepad frm;
	String cmd;
	
	public NoteActionListener(Notepad frm) {
		this.frm=frm;
	}
	public void actionPerformed(ActionEvent ae) {
		cmd=ae.getActionCommand();
		switch(cmd) {
		case "������":
			frm.newFile();
			break;
		case "����":
			JFileChooser opchooser = new JFileChooser();
			FileNameExtensionFilter opfilter = new FileNameExtensionFilter("*.txt& *.java","txt","java");
			
			int ret = opchooser.showOpenDialog(null);
			if(ret!=JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null,"������ �������� �ʾҽ��ϴ�.","���",JOptionPane.WARNING_MESSAGE);
				return;
			}
			String oFile = opchooser.getSelectedFile().getPath();
			
			frm.setTitle(oFile);
			frm.loadFile(oFile);
			break;
		case "����":
			if(frm.getTitle()=="������"||frm.getTitle()=="�޸���") {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt& *.java","txt","java");
				chooser.setFileFilter(filter);
			}
			break;
		case "�ٸ��̸����� ����":
			break;
		case "����":
			frm.windowClosing(null);
			break;
		}
	}
}
