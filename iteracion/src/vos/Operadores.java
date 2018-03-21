package vos;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonProperty;


public class Operadores
{	
	private final static int CAPACIDAD=100;
	//Atributos 
	@JsonProperty(value="Nombre")
	protected String Nombre;
	@JsonProperty(value="Tipo")
	protected String Tipo;
	@JsonProperty(value="MinDeTiempo")
	protected double MinDeTiempo;
	@JsonProperty(value="Capacidad")
	protected double Capacidad;
	@JsonProperty(value="id")
	protected  Long id;
	
	
	//Asociaciones
	@JsonProperty(value="Propuestas")
	protected List<Propuesta> Propuestas;
	@JsonProperty(value="ReservasVigentes")
	protected List<Reserva> ReservasVigentes;


    //Constructor
	public Operadores(@JsonProperty(value="Nombre")String nombre,@JsonProperty(value="Tipo") String tipo,@JsonProperty(value="MinDeTiempo") double minTiempo,@JsonProperty(value="Capacidad")double capacidad,@JsonProperty(value="id") Long id)
	{
		this.Nombre=nombre;
		this.Tipo=tipo;
		this.MinDeTiempo=minTiempo;
		this.Capacidad=capacidad;
		this.id=id;
		this.Propuestas= new ArrayList<>();
		this.ReservasVigentes= new ArrayList<>();
	}

	//Metodos get,set
	private String getNombre() {
		return this.Nombre;
	}


	private String getTipo() {
		return this.Tipo;
	}

	private double getMinDeTiempo() {
		return this.MinDeTiempo;
	}

	
	private double isCapacidad() {
		return this.Capacidad;
	}


	public List<Propuesta> getPropuestas() {
		if(this.Propuestas == null) {
				this.Propuestas = new ArrayList<>();
		}
		return this.Propuestas;
	}

	public List<Reserva> getReservasVigentes() {
		if(this.ReservasVigentes == null) {
				this.ReservasVigentes = new ArrayList<>();
		}
		return  this.ReservasVigentes;
	}


	public long getId() {
		return this.id;
	}


	public void addAllPropuestas(Set<Propuesta> newPropuestas) {
		if (this.Propuestas == null) {
			this.Propuestas = new ArrayList<>();
		}
		for (Propuesta tmp : newPropuestas)
			tmp.setOperador(this);
		
	}

	
	public void addAllReservasVigentes(Set<Reserva> newReservasVigentes) {
		if (this.ReservasVigentes == null) {
			this.ReservasVigentes = new ArrayList<>();
		}
		this.ReservasVigentes.addAll(newReservasVigentes);
	}

	
	public void removeAllPropuestas(Set<Propuesta> newPropuestas) {
		if(this.Propuestas == null) {
			return;
		}
		
		this.Propuestas.removeAll(newPropuestas);
	}


	public void removeAllReservasVigentes(Set<Reserva> newReservasVigentes) {
		if(this.ReservasVigentes == null) {
			return;
		}
		
		this.ReservasVigentes.removeAll(newReservasVigentes);
	}


	private void setNombre(String myNombre) {
		this.Nombre = myNombre;
	}


	private void setTipo(String myTipo) {
		this.Tipo = myTipo;
	}

	
	private void setMinDeTiempo(double myMinDeTiempo) {
		this.MinDeTiempo = myMinDeTiempo;
	}

	
	private void setCapacidad(double myCapacidad) {
		this.Capacidad = myCapacidad;
	}

	
	public void addPropuestas(Propuesta newPropuestas) {
		if(this.Propuestas == null) {
			this.Propuestas = new ArrayList<>();
		}
		
		if (this.Propuestas.add(newPropuestas))
			newPropuestas.basicSetOperador(this);
	}

	
	public void addReservasVigentes(Reserva newReservasVigentes) {
		if(this.ReservasVigentes == null) {
			this.ReservasVigentes = new ArrayList<>();
		}
		
		this.ReservasVigentes.add(newReservasVigentes);
	}
	
	public void removePropuestas(Propuesta oldPropuestas) {
		if(this.Propuestas == null)
			return;
		
		if (this.Propuestas.remove(oldPropuestas))
			oldPropuestas.unsetOperador();
		
	}



}

