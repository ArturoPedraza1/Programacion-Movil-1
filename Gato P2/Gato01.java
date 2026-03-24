//Pedraza Cruz José Arturo

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Gato01 extends JFrame implements ActionListener {
    JButton botones [] = new JButton[9];
    JButton btnReinciar;
    boolean turnoX=true;
    Font fuente = new Font("Arial",1,60);  
    JPanel pJuego, pOpciones;
    String letra;
   
    public Gato01(){
        setTitle("Gato");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        pJuego = new JPanel();
        pJuego.setLayout(new GridLayout(3,3));
       
        for(int i=0;i<botones.length;i++){
            botones[i] = new JButton("");
            botones[i].setFont(fuente);
            botones[i].addActionListener(this);
            pJuego.add(botones[i]);            
        }
       
        add(pJuego, BorderLayout.CENTER);
       
        btnReinciar = new JButton("Reiniciar Juego");
        pOpciones = new JPanel();
       
        btnReinciar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ex){
                  for(int i=0;i<botones.length;i++){
                        botones[i].setText("");  
                        botones[i].setEnabled(true);                      
                  }
                  turnoX=true;                  
            }            
        });
       
        pOpciones.add(btnReinciar);
        add(pOpciones, BorderLayout.SOUTH);
    }
   
    public static void main(String a []){
        Gato01 g01 = new Gato01();
        g01.setVisible(true);
    }
   
    public void actionPerformed(ActionEvent btnApretado){
        if(turnoX){
           letra="X";
           turnoX=false;
        }else{
            letra="O";
            turnoX=true;
        }
       
        for(int i=0;i<botones.length;i++){
            if(btnApretado.getSource()==botones[i]){
                botones[i].setText(letra);  
                botones[i].setEnabled(false);
            }    
        }

        if(verificarGanador()){
            JOptionPane.showMessageDialog(this, "Ganó: " + letra);
            bloquearTablero();
        }
    }
    public boolean verificarGanador(){
        String[][] lineas = {
            {botones[0].getText(), botones[1].getText(), botones[2].getText()},
            {botones[3].getText(), botones[4].getText(), botones[5].getText()},
            {botones[6].getText(), botones[7].getText(), botones[8].getText()},
            {botones[0].getText(), botones[3].getText(), botones[6].getText()},
            {botones[1].getText(), botones[4].getText(), botones[7].getText()},
            {botones[2].getText(), botones[5].getText(), botones[8].getText()},
            {botones[0].getText(), botones[4].getText(), botones[8].getText()},
            {botones[2].getText(), botones[4].getText(), botones[6].getText()}
        };

        for(String[] linea : lineas){
            if(!linea[0].equals("") && linea[0].equals(linea[1]) && linea[1].equals(linea[2])){
                return true;
            }
        }
        return false;
    }
    public void bloquearTablero(){
        for(JButton boton : botones){
            boton.setEnabled(false);
        }
    }
}