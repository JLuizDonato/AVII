package com.escola.gui;

import com.escola.model.Aluno;

import javax.swing.*;
import java.awt.*;

public class AlunoForm extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nomeField;
    private JTextField emailField;
    private JTextField cpfField;
    private JTextField dataNascimentoField;
    private JTextField naturalidadeField;
    private JTextField enderecoField;

    public AlunoForm() {
        setLayout(new GridLayout(6, 2));

        add(new JLabel("   Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("   Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("   CPF:"));
        cpfField = new JTextField();
        add(cpfField);

        add(new JLabel("   Data de Nascimento (yyyy-MM-dd):"));
        dataNascimentoField = new JTextField();
        add(dataNascimentoField);

        add(new JLabel("   Naturalidade:"));
        naturalidadeField = new JTextField();
        add(naturalidadeField);

        add(new JLabel("   Endereço:"));
        enderecoField = new JTextField();
        add(enderecoField);
    }

    public Aluno getAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome(nomeField.getText());
        aluno.setEmail(emailField.getText());
        aluno.setCpf(cpfField.getText());
        aluno.setDataNascimento(java.sql.Date.valueOf(dataNascimentoField.getText()));
        aluno.setNaturalidade(naturalidadeField.getText());
        aluno.setEndereco(enderecoField.getText());
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        nomeField.setText(aluno.getNome());
        emailField.setText(aluno.getEmail());
        cpfField.setText(aluno.getCpf());
        dataNascimentoField.setText(aluno.getDataNascimento().toString());
        naturalidadeField.setText(aluno.getNaturalidade());
        enderecoField.setText(aluno.getEndereco());
    }

	public JTextField getNomeField() {
		return nomeField;
	}

	public void setNomeField(JTextField nomeField) {
		this.nomeField = nomeField;
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public void setEmailField(JTextField emailField) {
		this.emailField = emailField;
	}

	public JTextField getCpfField() {
		return cpfField;
	}

	public void setCpfField(JTextField cpfField) {
		this.cpfField = cpfField;
	}

	public JTextField getDataNascimentoField() {
		return dataNascimentoField;
	}

	public void setDataNascimentoField(JTextField dataNascimentoField) {
		this.dataNascimentoField = dataNascimentoField;
	}

	public JTextField getNaturalidadeField() {
		return naturalidadeField;
	}

	public void setNaturalidadeField(JTextField naturalidadeField) {
		this.naturalidadeField = naturalidadeField;
	}

	public JTextField getEnderecoField() {
		return enderecoField;
	}

	public void setEnderecoField(JTextField enderecoField) {
		this.enderecoField = enderecoField;
	}
}
