package vos;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonProperty;



/**
 * 
 * Clase que representa una propuesta,una propuesta es quuella que que es ofrecida por un operador ademas se encarga de manejar los servicios. 
 */


public class Propuesta
{
	/**
	 * Representa si una  propuesta tiene servicio de agua
	 */
	@JsonProperty(value="ServicioAgua")
	protected boolean SevicioAgua;	
	/**
	 * Representa si una  propuesta tiene servicio de luz
	 */
	@JsonProperty(value="ServicioLuz")
	protected boolean ServicioLuz;	
	/**
	 * Representa si una  propuesta tiene servicio de wifi
	 */
	@JsonProperty(value="ServicioWifi")
	protected boolean ServicoWifi;	
	/**
	 * Representa el operador encargado de una reserva  
	 * 
	 */
	@JsonProperty(value="Operador")
	protected Operadores Operador;	
	/**
	 * Representa la lista de servicios adicionales asociadas con una propuesta 
	 * 
	 */
	@JsonProperty(value="Servicios")
	protected List<Servicios_Adicionales> Servicios;
	/**
	 * Identificador de una propuesta
	 */
	@JsonProperty(value="id")
	protected Long id ;
	
	///Constructor
	
	public Propuesta(@JsonProperty(value="ServicioAgua") boolean servicioAgua,@JsonProperty(value="ServicioLuz") boolean servicioLuz,@JsonProperty(value="ServicioWifi") boolean servicioWifi,@JsonProperty(value="Operador") Operadores operador,@JsonProperty(value="id")Long id)
	{
		this.SevicioAgua=servicioAgua;
		this.ServicioLuz=servicioLuz;
		this.ServicoWifi=servicioWifi;
		if(operador!=null)
		this.Operador=operador;
		this.Servicios= new ArrayList<>();
		this.id=id;
	}
	// Getters y setters

	/**
	 * 
	 * @param myOperador nuevo operador  responsable de la propuesta
	 */
	public void basicSetOperador(Operadores myOperador) {
		if (this.Operador != myOperador) {
			if (myOperador != null){
				if (this.Operador != myOperador) {
					Operadores oldOperador = this.Operador;
					this.Operador = myOperador;
					if (oldOperador != null)
						oldOperador.removePropuestas(this);
				}
			}
		}
	}
	/**
	 * 
	 * @return si la propuesta tiene servicio de agua
	 */
	private boolean isSevicioAgua() {
		return this.SevicioAgua;
	}

	/**
	 * 
	 * @return si la propuesta tiene servicio de luz
	 */
	private boolean isServicioLuz() {
		return this.ServicioLuz;
	}

	/**
	 * 
	 * @return si la propuesta tiene servicio de wifi
	 */
	private boolean isServicoWifi() {
		return this.ServicoWifi;
	}
	/**
	 * 
	 * @return el operador relacionado con la propuesta
	 */
	public Operadores getOperador() {
		return this.Operador;
	}

	/**
	 * 
	 * @return todos los servicios adicionales asociados a una propuesta
	 */
	public List<Servicios_Adicionales> getServicios() {
		if(this.Servicios == null) {
			this.Servicios = new ArrayList<>();
		}
		return this.Servicios;
	}

	/**
	 * 
	 * @return el identificador de una propuesta
	 */
	public long getId() {
		return this.id;
	}
	/**
	 * 
	 * @param newServicios nueva lista de servicios adicionales a agregar
	 */

	public void addAllServicios(Set<Servicios_Adicionales> newServicios) {
		if (this.Servicios == null) {
			this.Servicios = new ArrayList<>();
		}
		this.Servicios.addAll(newServicios);
	}
	/**
	 * 
	 * @param newServicios lista de servicios adicionales a elliminar
	 */
	public void removeAllServicios(Set<Servicios_Adicionales> newServicios) {
		if(this.Servicios == null) {
			return;
		}

		this.Servicios.removeAll(newServicios);
	}

	/**
	 * 
	 * @param mySevicioAgua cambio el estado respecto al servicio
	 */
	private void setSevicioAgua(boolean mySevicioAgua) {
		this.SevicioAgua = mySevicioAgua;
	}

	/**
	 * 
	 * @param myServicioLuzcambio el estado respecto al servicio
	 */
	private void setServicioLuz(boolean myServicioLuz) {
		this.ServicioLuz = myServicioLuz;
	}
	/**
	 * 
	 * @param mySevicioAgua cambio el estado respecto al servicio
	 */
	private void setServicoWifi(boolean myServicoWifi) {
		this.ServicoWifi = myServicoWifi;
	}


	public void setOperador(Operadores myOperador) {
		this.basicSetOperador(myOperador);
		myOperador.addPropuestas(this);
	}

	public void addServicios(Servicios_Adicionales newServicios) {
		if(this.Servicios == null) {
			this.Servicios = new ArrayList<>();
		}

		this.Servicios.add(newServicios);
	}

	private void unsetSevicioAgua() {
		this.SevicioAgua = false;
	}


	private void unsetServicioLuz() {
		this.ServicioLuz = false;
	}


	private void unsetServicoWifi() {
		this.ServicoWifi = false;
	}

	public void unsetOperador() {
		if (this.Operador == null)
			return;
		Operadores oldOperador = this.Operador;
		this.Operador = null;
		oldOperador.removePropuestas(this);
	}

	public void removeServicios(Servicios_Adicionales oldServicios) {
		if(this.Servicios == null)
			return;

		this.Servicios.remove(oldServicios);
	}

}

