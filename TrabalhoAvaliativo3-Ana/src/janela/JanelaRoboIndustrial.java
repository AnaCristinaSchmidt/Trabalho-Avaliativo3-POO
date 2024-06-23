package janela;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.util.InputMismatchException;

import com.sun.jdi.DoubleValue;
import dados.*;

public class JanelaRoboIndustrial extends JFrame implements ActionListener {
    private JTextField campoId, campoModelo, campoValorDiario, campoSetor;
    private JTextArea textoArea;
    private JButton confirmar, limpar, consultar, voltar, fechar;
    private GerenciaRobo gerenciaRobo;

    public JanelaRoboIndustrial(GerenciaRobo gerenciaRobo) {
        super();
        this.gerenciaRobo = gerenciaRobo;
        this.setTitle("Janela Robo Industrial");
        this.setSize(680,400);
        this.setResizable(false);
        JLabel idTexto = new JLabel("id");
        campoId = new JTextField(15);
        JLabel modeloTexto = new JLabel("modelo");
        campoModelo = new JTextField(15);
        JLabel valorDiarioTexto = new JLabel("valor diario");
        campoValorDiario = new JTextField(15);
        JLabel setorTexto = new JLabel("setor");
        campoSetor = new JTextField(15);
        confirmar = new JButton("Confirmar");
        limpar = new JButton("Limpar");
        consultar = new JButton("Consultar");
        voltar = new JButton("Voltar");
        fechar = new JButton("Fechar");
        textoArea = new JTextArea(10, 60);
        JPanel painel = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        painel.setLayout(flowLayout);
        painel.add(idTexto);
        painel.add(campoId);
        painel.add(modeloTexto);
        painel.add(campoModelo);
        painel.add(valorDiarioTexto);
        painel.add(campoValorDiario);
        painel.add(setorTexto);
        painel.add(campoSetor);
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
        String setor;
        if (actionEvent.getSource() == confirmar) {
            try {
                id = Integer.parseInt(campoId.getText());
                modelo = campoModelo.getText();
                valorDiario = Double.parseDouble(campoValorDiario.getText());
                setor = campoSetor.getText();
                Industrial roboIndustrial = new Industrial(id, modelo, valorDiario, setor);
                if (gerenciaRobo.cadastraRobo(roboIndustrial)) {
                    textoArea.append("Robo cadastrado com sucesso: " + roboIndustrial.toString() + "\n");
                }else {
                    textoArea.append("Erro! Robo já cadastrado.");
                }
            } catch (NumberFormatException | InputMismatchException numberFormatException) {
                textoArea.append("Dados invalidos! Verifique os campos.");
            }
        } else if (actionEvent.getSource() == limpar) {
            campoId.setText("");
            campoModelo.setText("");
            campoValorDiario.setText("");
            campoSetor.setText("");
            textoArea.setText("");
        } else if (actionEvent.getSource() == consultar) {
            if (!gerenciaRobo.getRobos().isEmpty()) {
                for (Robo robo : gerenciaRobo.getRobos()) {
                    textoArea.append(robo.toString() + "\n");
                }
            }
        } else if (actionEvent.getSource() == voltar) {
            setVisible(false);
        } else if (actionEvent.getSource() == fechar) {
            System.exit(0);
        }
    }
}

