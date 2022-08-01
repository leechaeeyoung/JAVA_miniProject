package memoProject;
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class Notepad extends JFrame{
	NoteActionListener nal = new NoteActionListener(this);
	JTextArea ta = new JTextArea();
	
	JMenu mfile = new JMenu("파일");
	JMenuBar mb = new JMenuBar();
	
	String filename;
	
	public Notepad() {
		this.setTitle("메모장");
		this.setBounds(500,100,1000,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		String[] scrItem= {"새파일","열기","저장","다른이름으로 저장","종료"};
	
		for(int i=0; i<scrItem.length; i++) {
			itemAdd(scrItem[i], mfile);
		}
		mb.add(mfile);
		ta.setLineWrap(true);
		
		this.setJMenuBar(mb);
		this.add(new JScrollPane(ta), BorderLayout.CENTER);
		this.setVisible(true);
	}
	public void itemAdd(String title, JMenu m) {
		JMenuItem item = new JMenuItem(title);
		m.add(item);
		item.addActionListener(nal);
	}
	public void windowClosing(WindowEvent we) {
		System.out.println("Closing");
		System.exit(0);
	}
	public void newFile() {
		ta.setText("");
		this.setTitle("새파일");
	}
	public void loadFile(String fn) {
		try {
			FileReader fin = new FileReader(new File(fn));
			ta.setText("");
			int c=0;
			while((c=fin.read()!=-1)) {
				String s = String.valueOf((char)c);
				ta.append(s);
			}
			fin.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void saveFile(String fn) {
		try {
			FileWriter ft = new FileWriter(new File(fn));
			ft.write(ta.getText());
			ft.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Notepad();
	}
}
