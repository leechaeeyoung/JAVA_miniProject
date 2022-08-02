package memoProject;
import java.awt.event.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NoteActionListener implements ActionListener{
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
			opchooser.setFileFilter(opfilter);
			
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
				ret = chooser.showSaveDialog(null);
				
				if(ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "������ ����ϼ̽��ϴ�.","���",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String sFile = chooser.getSelectedFile().getPath();
				frm.setTitle(sFile);
				frm.saveFile(sFile);
			} else {
				frm.setTitle(frm.getTitle());
				frm.saveFile(frm.getTitle());
			}
			break;
		case "�ٸ��̸����� ����":
			if(frm.getTitle()=="������"||frm.getTitle()=="�޸���") {
				JFileChooser chooser = new JFileChooser();
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt& *.java","txt","java");
				chooser.setFileFilter(filter);
				ret = chooser.showSaveDialog(null);
				
				if(ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "������ ����ϼ̽��ϴ�.","���",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String sFile = chooser.getSelectedFile().getPath();
				frm.setTitle(sFile);
				frm.saveFile(sFile);
			} else {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt& *.java","txt","java");
				chooser.setFileFilter(filter);
				ret = chooser.showSaveDialog(null);
				
				if(ret!=JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "�ٸ��̸����� ������ ����ϼ̽��ϴ�.","���",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String sFile = chooser.getSelectedFile().getPath();
				frm.setTitle(sFile);
				frm.saveFile(sFile);
			}
			break;
		case "����":
			frm.windowClosing(null);
			break;
		}
	}
}
