package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Apartamentos extends Operadores
{
	//Atributos
	@JsonProperty(value="Muebles")
	protected boolean Muebles;

	public Apartamentos(@JsonProperty(value="Nombre")String nombre,@JsonProperty(value="Tipo") String tipo,@JsonProperty(value="MinDeTiempo") double minTiempo,@JsonProperty(value="Capacidad")double capacidad,@JsonProperty(value="id") Long id,@JsonProperty(value="Muebles")boolean muebles)
	{
	super(nombre, tipo, minTiempo, capacidad, id);
	this.Muebles=muebles;
	
	}
	//Metodos
	/**
	 * 
	 * @return si el apartamento tiene muebles
	 */
	private boolean isMuebles() {
		return this.Muebles;
	}
	/**
	 * 
	 * @param myMuebles condicion de amoblado
	 */
	private void setMuebles(boolean myMuebles) {
		this.Muebles = myMuebles;
	}



}

