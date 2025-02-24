package pucgo.edu.br;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class UserLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField campoTexto;
    private JPasswordField campoSenha;
    private JButton btnNovoBotao;
    private JButton btnSairBotao;
    private JButton btnListarUsuarios;
    private JButton btnBuscar;
    private JLabel label;
    private JPanel painelConteudo;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLogin frame = new UserLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UserLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        painelConteudo = new JPanel();
        painelConteudo.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(painelConteudo);
        painelConteudo.setLayout(null);

        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(423, 13, 273, 93);
        painelConteudo.add(lblNewLabel);

        campoTexto = new JTextField();
        campoTexto.setFont(new Font("Tahoma", Font.PLAIN, 32));
        campoTexto.setBounds(481, 170, 281, 68);
        painelConteudo.add(campoTexto);
        campoTexto.setColumns(10);

        campoSenha = new JPasswordField();
        campoSenha.setFont(new Font("Tahoma", Font.PLAIN, 32));
        campoSenha.setBounds(481, 286, 281, 68);
        painelConteudo.add(campoSenha);

        JLabel lblUsername = new JLabel("Usuário");
        lblUsername.setForeground(Color.DARK_GRAY);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblUsername.setBounds(250, 166, 193, 52);
        painelConteudo.add(lblUsername);

        JLabel lblPassword = new JLabel("Senha");
        lblPassword.setForeground(Color.DARK_GRAY);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(250, 286, 193, 52);
        painelConteudo.add(lblPassword);

        btnSairBotao = new JButton("Sair");
        btnSairBotao.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnSairBotao.setBounds(333, 392, 162, 73);
        btnSairBotao.setForeground(Color.DARK_GRAY);
        btnSairBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        painelConteudo.add(btnSairBotao);

        btnListarUsuarios = new JButton("Listar");
        btnListarUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnListarUsuarios.setBounds(111, 392, 162, 73);
        btnListarUsuarios.setForeground(Color.DARK_GRAY);
        btnListarUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection connection = null;
                PreparedStatement st = null;
                ResultSet rs = null;

                try {
                    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
                    st = connection.prepareStatement("SELECT nome FROM estudante");
                    rs = st.executeQuery();

                    DefaultTableModel model = new DefaultTableModel();
                    model.addColumn("Nome");

                    while (rs.next()) {
                        model.addRow(new Object[]{rs.getString("nome")});
                    }

                    JTable tabela = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(tabela);
                    JFrame frame = new JFrame("Lista de Estudantes");
                    frame.add(scrollPane);
                    frame.setSize(400, 300);
                    frame.setVisible(true);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                    JOptionPane.showMessageDialog(btnListarUsuarios, "Erro ao conectar ao banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                } finally {
                    try {
                        if (rs != null) rs.close();
                        if (st != null) st.close();
                        if (connection != null) connection.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        painelConteudo.add(btnListarUsuarios);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnBuscar.setBounds(750, 392, 162, 73);
        btnBuscar.setForeground(Color.DARK_GRAY);
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Connection connection = null;
                PreparedStatement st = null;
                ResultSet rs = null;

                try {
                    String consultaSQL = "SELECT * FROM estudante";
                    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
                    st = connection.prepareStatement(consultaSQL);
                    rs = st.executeQuery();

                    DefaultTableModel model = new DefaultTableModel();
                    ResultSetMetaData metaData = rs.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    for (int i = 1; i <= columnCount; i++) {
                        model.addColumn(metaData.getColumnName(i));
                    }

                    while (rs.next()) {
                        Object[] row = new Object[columnCount];
                        for (int i = 1; i <= columnCount; i++) {
                            row[i - 1] = rs.getObject(i);
                        }
                        model.addRow(row);
                    }

                    JTable tabela = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(tabela);
                    JFrame frame = new JFrame("Lista de Estudantes");
                    frame.add(scrollPane);
                    frame.setSize(400, 300);
                    frame.setVisible(true);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                    JOptionPane.showMessageDialog(btnListarUsuarios, "Erro ao conectar ao banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                } finally {
                    try {
                        if (rs != null) rs.close();
                        if (st != null) st.close();
                        if (connection != null) connection.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        painelConteudo.add(btnBuscar);

        btnNovoBotao = new JButton("Login");
        btnNovoBotao.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNovoBotao.setBounds(545, 392, 162, 73);
        btnNovoBotao.setForeground(Color.DARK_GRAY);
        btnNovoBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String userName = campoTexto.getText();
                String password = campoSenha.getText();

                try {
                    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
                    PreparedStatement st = connection.prepareStatement("SELECT nome, senha FROM estudante WHERE nome=? AND senha=?");
                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();

                    if (rs.next()) {
                        dispose();
                        UserHome ah = new UserHome(userName);
                        ah.setTitle("Bem-Vindo");
                        ah.setVisible(true);
                        JOptionPane.showMessageDialog(btnNovoBotao, "Login realizado");
                    } else {
                        JOptionPane.showMessageDialog(btnNovoBotao, "UserName ou Senha incorretos");
                    }

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });
        painelConteudo.add(btnNovoBotao);

        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        painelConteudo.add(label);
    }
}
