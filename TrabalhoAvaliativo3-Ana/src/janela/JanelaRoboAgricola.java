package janela;
import dados.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class JanelaRoboAgricola extends JFrame implements ActionListener {
    private JTextField campoId, campoModelo, campoValorDiario, campoArea, campoUso;
    private JTextArea textoArea;
    private JButton confirmar, limpar, consultar, voltar, fechar;
    private GerenciaRobo gerenciaRobo;


    public JanelaRoboAgricola(GerenciaRobo gerenciaRobo) {
        super();
        this.gerenciaRobo = gerenciaRobo;
        this.setTitle("Janela Robo Agricola");
        this.setSize(680, 400);
        this.setResizable(false);
        JLabel idTexto = new JLabel("id");
        campoId = new JTextField(15);
        JLabel modeloTexto = new JLabel("modelo");
        campoModelo = new JTextField(15);
        JLabel valorDiarioTexto = new JLabel("valor diario");
        campoValorDiario = new JTextField(15);
        JLabel areaTexto = new JLabel("area");
        campoArea = new JTextField(15);
        JLabel usoTexto = new JLabel("uso");
        campoUso = new JTextField(15);
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
        painel.add(areaTexto);
        painel.add(campoArea);
        painel.add(usoTexto);
        painel.add(campoUso);
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
        double area;
        String uso;
        if (actionEvent.getSource() == confirmar) {
            try {
                id = Integer.parseInt(campoId.getText());
                modelo = campoModelo.getText();
                valorDiario = Double.parseDouble(campoValorDiario.getText());
                area = Double.parseDouble(campoArea.getText());
                uso = campoUso.getText();
                Agricola roboAgricola = new Agricola(id, modelo, valorDiario, area, uso);
                if (gerenciaRobo.cadastraRobo(roboAgricola)) {
                    textoArea.append("Robo cadastrado com sucesso: " + roboAgricola.toString() + "\n");
                }else {
                    textoArea.append("Erro! Robo já cadastrado.\n");
                }
            }catch (NumberFormatException | InputMismatchException numberFormatException){
                textoArea.append("Dados invalidos! Verifique os campos.");
            }
        } else if (actionEvent.getSource() == limpar) {
            campoId.setText("");
            campoModelo.setText("");
            campoValorDiario.setText("");
            campoArea.setText("");
            campoUso.setText("");
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
