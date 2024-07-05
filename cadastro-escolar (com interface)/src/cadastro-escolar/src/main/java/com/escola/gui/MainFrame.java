package com.escola.gui;

import com.escola.dao.AlunoDAO;
import com.escola.model.Aluno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AlunoDAO alunoDAO;
    private AlunoTableModel tableModel;
    private JTable table;
    private AlunoForm form;
    private JTextField searchField;

    public MainFrame() {
        alunoDAO = new AlunoDAO();
        tableModel = new AlunoTableModel(alunoDAO.listar());
        table = new JTable(tableModel);
        form = new AlunoForm();

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new BorderLayout());
        formPanel.add(form, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Adicionar");
        JButton updateButton = new JButton("Atualizar");
        JButton deleteButton = new JButton("Remover");
        JButton searchButton = new JButton("Pesquisar");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aluno aluno = form.getAluno();
                alunoDAO.inserir(aluno);
                refreshTable();
                form.setAluno(new Aluno());
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    Aluno aluno = tableModel.getAlunoAt(selectedRow);
                    Aluno updatedAluno = form.getAluno();
                    updatedAluno.setId(aluno.getId());
                    alunoDAO.alterar(updatedAluno);
                    refreshTable();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    Aluno aluno = tableModel.getAlunoAt(selectedRow);
                    alunoDAO.remover(aluno.getId());
                    refreshTable();
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText();
                if (searchTerm != null && !searchTerm.trim().isEmpty()) {
                    List<Aluno> alunos = alunoDAO.listarPorNomeInicial(searchTerm);
                    tableModel.setAlunos(alunos);
                }
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchButton);

        formPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(formPanel, BorderLayout.SOUTH);

        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Pesquisar por nome ou inicial:"));
        searchField = new JTextField(20);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        add(searchPanel, BorderLayout.NORTH);

        setTitle("Cadastro Escolar");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void refreshTable() {
        List<Aluno> alunos = alunoDAO.listar();
        tableModel.setAlunos(alunos);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

	public AlunoDAO getAlunoDAO() {
		return alunoDAO;
	}

	public void setAlunoDAO(AlunoDAO alunoDAO) {
		this.alunoDAO = alunoDAO;
	}

	public AlunoTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(AlunoTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public AlunoForm getForm() {
		return form;
	}

	public void setForm(AlunoForm form) {
		this.form = form;
	}

	public JTextField getSearchField() {
		return searchField;
	}

	public void setSearchField(JTextField searchField) {
		this.searchField = searchField;
	}
}
