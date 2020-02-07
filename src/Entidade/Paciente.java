package Entidade;

import java.util.Date;

public class Paciente {
	
	private Long idPaciente;
	private String nomePaciente;
	private String sexoPaciente;
	private String rgPaciente;
	private String cpfPaciente;
	private Date dataNascPaciente;
	private String enderecoPaciente;
	private String telefonePaciente;
	public Long getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getNomePaciente() {
		return nomePaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	public String getSexoPaciente() {
		return sexoPaciente;
	}
	public void setSexoPaciente(String sexoPaciente) {
		this.sexoPaciente = sexoPaciente;
	}
	public String getRgPaciente() {
		return rgPaciente;
	}
	public void setRgPaciente(String rgPaciente) {
		this.rgPaciente = rgPaciente;
	}
	public String getCpfPaciente() {
		return cpfPaciente;
	}
	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}
	public Date getDataNascPaciente() {
		return dataNascPaciente;
	}
	public void setDataNascPaciente(Date dataNascPaciente) {
		this.dataNascPaciente = dataNascPaciente;
	}
	public String getEnderecoPaciente() {
		return enderecoPaciente;
	}
	public void setEnderecoPaciente(String enderecoPaciente) {
		this.enderecoPaciente = enderecoPaciente;
	}
	public String getTelefonePaciente() {
		return telefonePaciente;
	}
	public void setTelefonePaciente(String telefonePaciente) {
		this.telefonePaciente = telefonePaciente;
	}


}