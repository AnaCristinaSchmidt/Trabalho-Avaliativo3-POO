package janela;

import dados.GerenciaRobo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaRobo extends JFrame implements ActionListener { //JanelaRobo(subclasse), JFrame(superclasse), ActionListener(Interface)
    private JButton roboAgricola, roboDomestico, roboIndustrial, fechar;
    private GerenciaRobo gerenciaRobo;

    public JanelaRobo(GerenciaRobo gerenciaRobo){
        super(); //Chama o construtor da superclasse (JFrame)
        this.gerenciaRobo = gerenciaRobo;
        this.setTitle("Janela Principal"); //Define o titulo da janela
        this.setSize(600,400); //Define o tamanho da janela
        this.setResizable(false); //Não deixa o usuário alterar o tamanho da janela
        roboAgricola = new JButton("Robo Agricola"); //Define o nome do botão
        roboDomestico = new JButton("Robo Domestico"); //Define o nome do botão
        roboIndustrial = new JButton("Robo Industrial"); //Define o nome do botão
        fechar = new JButton("Fechar"); //Define o nome do botão
        JPanel painel = new JPanel(); //Cria um painel
        BoxLayout boxLayout = new BoxLayout(painel, BoxLayout.Y_AXIS); //Cria um tipo de Layout
        painel.setLayout(boxLayout); //Define o Layout do painel
        painel.add(roboAgricola); //Adiciona o botão ao painel
        painel.add(roboDomestico); //Adiciona o botão ao painel
        painel.add(roboIndustrial); //Adiciona o botão ao painel
        painel.add(fechar); //Adiciona o botão ao painel
        fechar.addActionListener(this);
        roboAgricola.addActionListener(this);
        roboDomestico.addActionListener(this);
        roboIndustrial.addActionListener(this);
        this.add(painel); //Adiciona o painel a Janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Define a operação de fechar no X
        this.setVisible(true); //Define a Janela como visível
    }
    //Serve para dar acao ao botoes, campos de txt e area..
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == fechar){
            System.exit(0);
        } else if (actionEvent.getSource() == roboAgricola) {
            new JanelaRoboAgricola(gerenciaRobo);
        } else if (actionEvent.getSource() == roboDomestico) {
            new JanelaRoboDomestico(gerenciaRobo);
        } else if (actionEvent.getSource() == roboIndustrial) {
            new JanelaRoboIndustrial(gerenciaRobo);
        }
    }
}
