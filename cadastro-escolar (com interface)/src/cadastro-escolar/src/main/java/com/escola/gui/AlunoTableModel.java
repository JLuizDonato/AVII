package com.escola.gui;

import com.escola.model.Aluno;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class AlunoTableModel extends AbstractTableModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Aluno> alunos;
    private String[] colunas = {"ID", "Nome", "Email", "CPF", "Data de Nascimento", "Naturalidade", "Endereço"};

    public AlunoTableModel(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public int getRowCount() {
        return alunos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aluno aluno = alunos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return aluno.getId();
            case 1:
                return aluno.getNome();
            case 2:
                return aluno.getEmail();
            case 3:
                return aluno.getCpf();
            case 4:
                return aluno.getDataNascimento();
            case 5:
                return aluno.getNaturalidade();
            case 6:
                return aluno.getEndereco();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public Aluno getAlunoAt(int row) {
        return alunos.get(row);
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
        fireTableDataChanged();
    }

	public String[] getColunas() {
		return colunas;
	}

	public void setColunas(String[] colunas) {
		this.colunas = colunas;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}
}
