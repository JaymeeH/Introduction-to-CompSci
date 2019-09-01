// Lab 9 Gui / Jaymee Hyppolite
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files; 
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class main {
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		*/
		try {
		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		javax.swing.UIManager.setLookAndFeel(info.getClassName());
		break;
		}
		}
		} catch (ClassNotFoundException ex) {
		java.util.logging.Logger.getLogger(FileChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
		java.util.logging.Logger.getLogger(FileChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
		java.util.logging.Logger.getLogger(FileChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
		java.util.logging.Logger.getLogger(FileChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
		public void run() {
		new FileChooser().setVisible(true);
		}
		});
		}

		// Variables declaration - do not modify   
		private javax.swing.JButton btnOpenFile;
		private javax.swing.JButton btnUpdate;
		private javax.swing.JScrollPane jScrollPane1;
		private javax.swing.JTextArea txtContent;
		// End of variables declaration   
		}
class FileChooser extends javax.swing.JFrame {

/**
	 * 
	 */
	
final JFileChooser fileDialog = new JFileChooser();
private JScrollPane jScrollPane1;
private JTextArea txtContent;
private JButton btnUpdate;
private JButton btnOpenFile;

/**
* Creates new form FileChooser
*/
public FileChooser() {
initComponents();
}


@SuppressWarnings("unchecked")

private void initComponents() {

jScrollPane1 = new javax.swing.JScrollPane();
txtContent = new javax.swing.JTextArea();
btnUpdate = new javax.swing.JButton();
btnOpenFile = new javax.swing.JButton();

setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

txtContent.setColumns(20);
txtContent.setRows(5);
jScrollPane1.setViewportView(txtContent);

btnUpdate.setText("Update");
btnUpdate.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
btnUpdateActionPerformed(evt);
}
});

btnOpenFile.setText("Open File");
btnOpenFile.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
btnOpenFileActionPerformed(evt);
}
});

javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGap(78, 78, 78)
.addComponent(btnOpenFile)
.addGap(28, 28, 28)
.addComponent(btnUpdate))
.addGroup(layout.createSequentialGroup()
.addGap(43, 43, 43)
.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)))
.addContainerGap(44, Short.MAX_VALUE))
);
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGap(24, 24, 24)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(btnOpenFile)
.addComponent(btnUpdate))
.addGap(18, 18, 18)
.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
.addContainerGap(44, Short.MAX_VALUE))
);

pack();
}// </editor-fold>

private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
try {
java.io.File file = fileDialog.getSelectedFile();
PrintWriter out = new PrintWriter(file.getPath());
out.println(txtContent.getText());
out.close();
JOptionPane.showMessageDialog(this, "File Update Successfully");
} catch (Exception x) {
JOptionPane.showMessageDialog(this, "OOps something went wrong");
}
}   

private void btnOpenFileActionPerformed(java.awt.event.ActionEvent evt) {
try {
int returnVal = fileDialog.showOpenDialog(this);
if (returnVal == JFileChooser.APPROVE_OPTION) {
java.io.File file = fileDialog.getSelectedFile();
txtContent.setText(Files.readAllLines(Paths.get(file.getAbsolutePath().toString()), Charset.defaultCharset()).toString());
txtContent.setText(txtContent.getText(1, txtContent.getText().length()-2));
}
} catch (Exception ex) {
JOptionPane.showMessageDialog(this, "OOps something went wrong");

System.exit(1);
}

}   
}



		


