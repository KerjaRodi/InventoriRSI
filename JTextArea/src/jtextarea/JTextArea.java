/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jtextarea;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
/**
 *
 * @author Fatur
 */
public class JTextArea extends Frame {
    //JTextArea tArea;
    TextField tArea;
    JButton bSimpan, bMuat, bHapus;
    String namaBerkas = "Tarea.out";
    
    public static void main(String[] args) {
        JTextArea apl = new JTextArea();
    }
    
    public JTextArea(){
        super ("Text JTextArea");
        setSize(450,150);
        tArea = new TextField ();
        //tArea = new TextField ("Silahkan menulis teks\n" + "dan klik Simpan untuk menyimpan",5,30);
        bSimpan = new JButton ("Simpan");
        bMuat = new JButton ("Muat");
        bHapus = new JButton ("Hapus");
        
        JPanel p1 = new JPanel();
        p1.add(tArea);
        
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout (3,1));
        p2.add(bSimpan);
        p2.add(bMuat);
        p2.add(bHapus);
        
        bSimpan.addActionListener(new JTextArea.PenangananTombol());
        bMuat.addActionListener(new JTextArea.PenangananTombol());
        bHapus.addActionListener(new JTextArea.PenangananTombol());
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show();
    }
    
    class PenangananTombol implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String s = e.getActionCommand();
            if (s.equals("Simpan")){
                try{
                    FileWriter berkasKeluaran = new FileWriter(namaBerkas);  
                    String isiTextArea = tArea.getText();  
                    berkasKeluaran.write (isiTextArea);  
                    berkasKeluaran.close(); 
                }
                catch (IOException i ){
                    System.err.println("Gagal Menyimpan Berkas"); 
                        System.exit (1); 
                } 
                tArea.setText ("Teks sudah disimpan di berkas\n" + "Cek dengan mengklik Muat");
                
            }
            //else if (s.equals(“Muat”)) {
            else if (s.equals("Muat")){
                try {  
                    FileReader berkasMasukan = new FileReader (namaBerkas); 
                    BufferedReader streamMasukan = new BufferedReader (berkasMasukan);
                    String teks="";
                    while (true) { 
                        String barisData = streamMasukan.readLine(); 
                        if (barisData == null) break;
                        teks = teks + barisData + '\n';
                    }
                    berkasMasukan.close();
                    tArea.setText(teks);
                         
                    } 
                catch (IOException i) {
                    tArea.setText ("Berkas tak dapat dibaca");
                } 
            } 
            else if (s.equals("Hapus")){
                tArea.setText("");
                 
            }
        }
    }
}
