import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Main {
    public static void operate(int key)
    {

        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();
        //file FileInputStream
        try
        {

            FileInputStream fis=new FileInputStream(file);

            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }

            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done! Go and Check your selected image path!");

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        JFrame f=new JFrame();
        f.setTitle("Image Encryption/Decryption Tool");
        f.setSize(390,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        Font fonts=new Font("Roboto",Font.ITALIC,18);
        JButton button1=new JButton();
        button1.setText("Enter Key To Encrypt/ Decrypt Image");
        button1.setFont(fonts);

        JTextField textField=new JTextField(15);
        textField.setFont(fonts);

        Font font=new Font("Roboto",Font.ITALIC,18);
        JButton button=new JButton();
        button.setText("Select Image");
        button.setFont(font);

        Label l1,l2;
        l1=new Label("To Decrypt image give the same key as given on Encryption time!");
        l1.setBounds(50,100, 100,30);
        l2=new Label("And select the same image!");
        l2.setBounds(50,150, 100,30);


        button.addActionListener(e->{
            System.out.println("button clicked");
            String text=textField.getText();
            int temp=Integer.parseInt(text);
            operate(temp);
        });

        f.setLayout(new FlowLayout());
        f.add(button1);
        f.add(textField);
        f.add(button);
        f.add(l1); f.add(l2);
        f.setVisible(true);
      
    }

}

