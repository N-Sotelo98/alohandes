package vos;
import javax.*;

import org.codehaus.jackson.annotate.JsonProperty;
/**
 * 
 * Clase que representa a un cliente 
 *
 */
public class Cliente {
	//Atributos de la entidad
	/**
	 * Codigo que reoresenta a un cliente
	 */
	@JsonProperty(value="Codigo")
	protected String Codigo;
	/**
	 * Nmbre de un cliente
	 */
	@JsonProperty(value="Nombre")
	protected String Nombre;
	/**
	 * Apellido de un cliente
	 */	
	@JsonProperty(value="Apelllido")
	protected String Apellido;
	/**
	 * Define la relacion con la entidad tiene que ser alguno de los siguientes:Estudiante; Egresado, Empleado,Profesores,PadresDeEstudiante,ProfesoresInvitados
	 */
	@JsonProperty(value="Tipo")
	protected String Tipo;
	/**
	 * Relacion que permite a un cliente acceder a una propuesta
	 */
	@JsonProperty(value="Contrato")
	protected Reserva Contrato;
	/**
	 * id que identifica a un cliente
	 */
	@JsonProperty(value="id")
	protected  Long id;
	///Metodo constructor 

	public Cliente(@JsonProperty(value="Codigo")String codigo,@JsonProperty(value="Nombre")String nombre,@JsonProperty(value="Appellido")String apellido,@JsonProperty(value="Tipo")String tipo,	@JsonProperty(value="id") Long id,@JsonProperty(value="Contrato") Reserva reserva)
	{
		this.Codigo=codigo;
		this.Nombre=nombre;
		this.Apellido=apellido;
		if (tipo.equalsIgnoreCase("Estudiante")||tipo.equalsIgnoreCase("Profesor")||tipo.equalsIgnoreCase("Egresado")||tipo.equalsIgnoreCase("Empleado")||tipo.equalsIgnoreCase("Padres de estudiante")||tipo.equalsIgnoreCase("Profesores invitados"))
		{
			this.Tipo=tipo;
		}
		this.id=id;
		if(Contrato!=null)
		{			
			this.Contrato=reserva;
		}
	}
	//Metodos getter y setter
	/**
	 * 
	 * @return codigo de el cliente
	 */
	private String getCodigo() {
		return this.Codigo;
	}
	/**
	 * 
	 * @return nombre de el cliente
	 */
	private String getNombre() {
		return this.Nombre;
	}
	/**
	 * 
	 * @return apellido del cliente
	 */
	private String getApellido() {
		return this.Apellido;
	}
	/**
	 * 
	 * @return tipo de relacion con la insitucion
	 */

	private String getTipo() {
		return this.Tipo;
	}
	/**
	 * 
	 * @return contrato de un cliente
	 */
	public Reserva getContrato() {
		return this.Contrato;
	}
	/**
	 * 
	 * @return el id de un cliente
	 */
	public long getId() {
		return this.id;
	}
	/**
	 * 
	 * @param myCodigo de identificacion 
	 */
	private void setCodigo(String myCodigo) {
		this.Codigo = myCodigo;
	}
	/**
	 * 
	 * @param myNombre del cliente
	 */
	private void setNombre(String myNombre) {
		this.Nombre = myNombre;
	}
	/**
	 * 
	 * @param myApellido apellido del cliente
	 */
	private void setApellido(String myApellido) {
		this.Apellido = myApellido;
	}

	/**
	 * 
	 * @param myTipo tipo de relacion con la  institucion
	 */
	private void setTipo(String myTipo) {
		this.Tipo = myTipo;
	}

	/**
	 * 
	 * @param myContrato contrato nuevo 
	 */
	public void setContrato(Reserva myContrato) {
		this.Contrato = myContrato;
	}



}



