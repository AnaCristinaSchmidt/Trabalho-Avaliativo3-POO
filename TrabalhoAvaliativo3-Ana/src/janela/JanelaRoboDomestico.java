package janela;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

import dados.*;

public class JanelaRoboDomestico extends JFrame implements ActionListener {
    private JTextField campoId, campoModelo, campoValorDiario, campoNivel;
    private JTextArea textoArea;
    private JButton confirmar, limpar, consultar, voltar, fechar;
    private GerenciaRobo gerenciaRobo;
    public JanelaRoboDomestico(GerenciaRobo gerenciaRobo) {
        super();
        this.gerenciaRobo = gerenciaRobo;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("RoboDomestico");
        this.setSize(680, 600);
        this.setResizable(false);
        JLabel idTexto = new JLabel("ID");
        campoId = new JTextField(15);
        JLabel modeloTexto = new JLabel("Modelo");
        campoModelo = new JTextField(15);
        JLabel campoValorDiarioTexto = new JLabel("Valor diario");
        campoValorDiario = new JTextField(15);
        JLabel campoNivelTexto = new JLabel("Nivel");
        campoNivel = new JTextField(15);
        confirmar = new JButton("Confirmar");
        limpar = new JButton("Limpar");
        consultar = new JButton("Consultar");
        voltar = new JButton("Voltar");
        fechar = new JButton("Fechar");
        textoArea = new JTextArea(10,60);
        JPanel painel = new JPanel();
        painel.add(idTexto);
        painel.add(campoId);
        painel.add(modeloTexto);
        painel.add(campoModelo);
        painel.add(campoValorDiarioTexto);
        painel.add(campoValorDiario);
        painel.add(campoNivelTexto);
        painel.add(campoNivel);
        painel.add(confirmar);
        painel.add(limpar);
        painel.add(consultar);
        painel.add(voltar);
        painel.add(fechar);
        painel.add(textoArea);
        confirmar.addActionListener(this);
        limpar.addActionListener(this);
        consultar.addActionListener(this);
        voltar.addActionListener(this);
        fechar.addActionListener(this);
        this.add(painel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int id;
        String modelo;
        double valorDiario;
        int nivel;
        if(actionEvent.getSource() == confirmar){
            try {
                id = Integer.parseInt(campoId.getText());
                modelo = campoModelo.getText();
                valorDiario = Double.parseDouble(campoValorDiario.getText());
                nivel = Integer.parseInt(campoNivel.getText());
                Domestico roboDomestico = new Domestico(id, modelo, valorDiario, nivel);
                if (gerenciaRobo.cadastraRobo(roboDomestico)) {
                    textoArea.append("Robo cadastrado com sucesso: " + roboDomestico.toString() + "\n");
                }else {
                    textoArea.append("Erro! Robo já cadastro.\n");
                }
            }catch(NumberFormatException | InputMismatchException numberFormatException) {
                textoArea.append("Dados invalidos! Verifique os campos.");
            }
        }  else if (actionEvent.getSource() == limpar) {
            campoId.setText("");
            campoModelo.setText("");
            campoValorDiario.setText("");
            campoNivel.setText("");
            textoArea.setText("");
        } else if (actionEvent.getSource() == consultar) {
            if (!gerenciaRobo.getRobos().isEmpty()){
                for(Robo robo:gerenciaRobo.getRobos()){
                    textoArea.append(robo.toString() +"\n");
                }
            }
        } else if (actionEvent.getSource() == voltar) {
            setVisible(false);
        } else if (actionEvent.getSource() == fechar) {
            System.exit(0);
        }
    }
}


